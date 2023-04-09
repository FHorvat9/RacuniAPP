/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.controller;

import edunova.model.Blagajnik;
import edunova.model.Entitet;
import edunova.model.Racun;
import edunova.util.EdunovaException;
import edunova.util.Pomocno;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Feecho
 */
public class ObradaRacun extends Obrada<Racun> {

    @Override
    public List<Racun> read() {
        return session.createQuery("from Racun", Racun.class).list();

    }

    public List<Racun> read(String uvjet, int broj) {

        switch (broj) {
            case 0:
                uvjet = uvjet.trim();
                uvjet = "%" + uvjet + "%";
//                        
                return session.createNativeQuery("SELECT DISTINCT racun.* from Racun INNER JOIN blagajnik ON "
                        + "racun.blagajnik_sifra = blagajnik.sifra "
                        + "where concat(ime,' ',prezime,' ',ime) like :uvjet ", Racun.class).setParameter("uvjet", uvjet).list();

            case 1:
                uvjet = uvjet.trim();
                uvjet = uvjet + "%";

                return session.createQuery("from Racun where cast(brojRacuna as text) like :uvjet", Racun.class).setParameter("uvjet", uvjet).list();
            case 2:
            try {
                System.out.println(uvjet);
                
                return session.createQuery("from Racun where cast(datum as Date)=:uvjet", Racun.class).setParameter("uvjet", LocalDate.parse(uvjet, DateTimeFormatter.ofPattern("dd.MM.yyyy"))).list();
            } catch (Exception e) {
                
            }
             
             

        }
        return null;
    }

    @Override
    public void kontrolaUnos() throws EdunovaException {
        provjeraBrojRacuna();
    }

    @Override
    public void kontrolaPromjena() throws EdunovaException {
    }

    @Override
    public void kontrolaBrisanje() throws EdunovaException {
    }

    private void provjeraBrojRacuna() {
        List<Racun> racuni = null;
        try {
            racuni = session.createQuery("from Racun "
                    + " where racun.BrojRacuna=:BrojRacuna ",
                    Racun.class)
                    .setParameter("BrojRacuna", entitet.getBrojRacuna())
                    .list();
        } catch (Exception e) {
        }
        if (racuni != null && !racuni.isEmpty()) {

            entitet.setBrojRacuna(Pomocno.brojIzmedju(100000, 999999));

            provjeraBrojRacuna();
        }
    }

}
