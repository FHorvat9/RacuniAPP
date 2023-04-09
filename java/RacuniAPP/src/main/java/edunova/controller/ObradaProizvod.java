/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.controller;

import edunova.model.Proizvod;
import edunova.model.StavkaRacuna;
import edunova.util.EdunovaException;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Feecho
 */
public class ObradaProizvod extends Obrada<Proizvod> {

    @Override
    public List<Proizvod> read() {
        return session.createQuery("from Proizvod order by imeProizvoda ", Proizvod.class).list();
    }
    
     public List<Proizvod> read(String uvjet) {
        uvjet=uvjet.trim();
        uvjet = "%" + uvjet + "%";
       return session.createQuery("from Proizvod "
               + " where concat(imeProizvoda) "
               + " like :uvjet "
               + " order by imeProizvoda ", 
               Proizvod.class)
               .setParameter("uvjet", uvjet)
               .setMaxResults(12)
               .list();
    }

    @Override
    public void kontrolaUnos() throws EdunovaException {
        kontrolaImeProizvoda();
        kontrolaDuploImeProizvoda();
        kontrolaCijenaProzivoda();

    }

    @Override
    public void kontrolaPromjena() throws EdunovaException {
        kontrolaImeProizvoda();
        kontrolaCijenaProzivoda();

    }

    @Override
    public void kontrolaBrisanje() throws EdunovaException {
        if (entitet.getRacuni() != null && !entitet.getRacuni().isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Proizvod se nemoze obrisati jer se nalazi na sljedecim racunima:\n");
            List<Integer> sortiraniBrojeviRacuna = new ArrayList<>();
            for (StavkaRacuna sr : entitet.getRacuni()) {
                sortiraniBrojeviRacuna.add(sr.getBrojRacuna());
            }
            Collections.sort(sortiraniBrojeviRacuna);
            
            for(int br : sortiraniBrojeviRacuna){
                sb.append(br+"\n");
            }
            throw new EdunovaException(sb.toString());
        }
    }

    private void kontrolaImeProizvoda() throws EdunovaException {
        kontrolaImeProizvodaNijeNull();
        kontroleImeProizvodaNijeBroj();
        kontrolaImeProizvodaMinDuzina();
        kontrolaImeProizvodaMaxDuzina();
        

    }

    private void kontroleImeProizvodaNijeBroj() throws EdunovaException {
        boolean broj = false;

        try {
            Double.parseDouble(entitet.getImeProizvoda());
            broj = true;
        } catch (Exception e) {

        }
        if (broj) {
            throw new EdunovaException("Ime proizvoda ne smije biti broj");
        }

    }

    private void kontrolaImeProizvodaMinDuzina() throws EdunovaException {
        if (entitet.getImeProizvoda().trim().length() < 3) {
            throw new EdunovaException("Ime proizvoda mora imati barem 3 znaka");

        }
    }

    private void kontrolaImeProizvodaMaxDuzina() throws EdunovaException {
        if (entitet.getImeProizvoda().trim().length() > 15) {
            throw new EdunovaException("Ime proizvoda moze imati maksimalno 15 znakova");

        }
    }

    private void kontrolaImeProizvodaNijeNull() throws EdunovaException {
        if (entitet.getImeProizvoda() == null) {
            throw new EdunovaException("Ime proizvoda ne smije biti null");
        }
    }

    private void kontrolaCijenaProzivoda() throws EdunovaException {
        if (entitet.getCijena() == null) {
            throw new EdunovaException("Cijena ne smije biti null");
        }
        try {
            Double.valueOf(String.valueOf(entitet.getCijena()));
        } catch (Exception e) {
            throw new EdunovaException("Cijena mora biti broj");
        }

        if (Double.parseDouble(String.valueOf(entitet.getCijena())) <= 0) {
            throw new EdunovaException("Cijena mora biti pozitivna");
        }

        if (Double.parseDouble(String.valueOf(entitet.getCijena())) > 100000) {
            throw new EdunovaException("Cijena mora biti manja od 100 000");
        }
    }

    private void kontrolaDuploImeProizvoda() throws EdunovaException{
        List<Proizvod> proizvodi=null;
        try {
            proizvodi = session.createQuery("from Proizvod p "
                    + " where p.imeProizvoda=:imeProizvoda ", 
                    Proizvod.class)
                    .setParameter("imeProizvoda", entitet.getImeProizvoda())
                    .list();
        } catch (Exception e) {
        }
        if(proizvodi!=null && !proizvodi.isEmpty()){
            throw new EdunovaException("Proizvod s istim nazivom postoji u bazi");
        }
    }

}
