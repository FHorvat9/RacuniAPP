/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.controller;

import edunova.model.Proizvod;
import edunova.util.EdunovaException;
import java.util.List;

/**
 *
 * @author Feecho
 */
public class ObradaProizvod extends Obrada<Proizvod> {

    @Override
    public List<Proizvod> read() {
        return session.createQuery("from Proizvod ", Proizvod.class).list();
    }

    @Override
    public void kontrolaUnos() throws EdunovaException {
        kontrolaImeProizvoda();
        kontrolaCijenaProzivoda();

    }

    @Override
    public void kontrolaPromjena() throws EdunovaException {
        kontrolaImeProizvoda();
        kontrolaCijenaProzivoda();

    }

    @Override
    public void kontrolaBrisanje() throws EdunovaException {
 
    }

    private void kontrolaImeProizvoda() throws EdunovaException {
        kontroleImeProizvodaNijeBroj();
        kontrolaImeProizvodaMinDuzina();
        kontrolaImeProizvodaMaxDuzina();
        kontrolaImeProizvodaNijeNull();

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

}
