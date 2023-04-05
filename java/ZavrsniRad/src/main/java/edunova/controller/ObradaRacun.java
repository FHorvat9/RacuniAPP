/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.controller;

import edunova.model.Blagajnik;
import edunova.model.Entitet;
import edunova.model.Racun;
import edunova.util.EdunovaException;
import java.util.Collection;
import java.util.List;

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
                uvjet =  uvjet + "%";

                return session.createQuery("from Racun where cast(brojRacuna as text) like :uvjet", Racun.class).setParameter("uvjet", uvjet).list();
        
        }
        return null;
    }

    @Override
    public void kontrolaUnos() throws EdunovaException {
    }

    @Override
    public void kontrolaPromjena() throws EdunovaException {
    }

    @Override
    public void kontrolaBrisanje() throws EdunovaException {
    }

}
