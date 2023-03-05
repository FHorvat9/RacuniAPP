/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.controller;

import edunova.model.Blagajnik;
import edunova.util.EdunovaException;
import java.util.List;

/**
 *
 * @author Feecho
 */
public class ObradaBlagajnik extends Obrada<Blagajnik> {

    @Override
    public List<Blagajnik> read() {
        return session.createQuery("from Blagajnik", Blagajnik.class).list();
    }

    @Override
    public void kontrolaUnos() throws EdunovaException {
        kontrolaIme();
        kontrolaPrezime();

    }

    @Override
    public void kontrolaPromjena() throws EdunovaException {
        kontrolaIme();
        kontrolaPrezime();
    }

    @Override
    public void kontrolaBrisanje() throws EdunovaException {

    }

    private void kontrolaIme() throws EdunovaException {
        kontroleImeNijeBroj();
        kontrolaImeMinDuzina();
        kontrolaImeMaxDuzina();
        kontrolaImeNijeNull();

    }

    private void kontroleImeNijeBroj() throws EdunovaException {
        boolean broj = false;

        try {
            Double.parseDouble(entitet.getIme());
            broj = true;
        } catch (Exception e) {

        }
        if (broj) {
            throw new EdunovaException("Ime ne smije biti broj");
        }

    }

    private void kontrolaImeMinDuzina() throws EdunovaException {
        if (entitet.getIme().trim().length() < 3) {
            throw new EdunovaException("Ime mora imati barem 3 znaka");

        }
    }

    private void kontrolaImeMaxDuzina() throws EdunovaException {
        if (entitet.getIme().trim().length() > 15) {
            throw new EdunovaException("Ime moze imati maksimalno 15 znakova");

        }
    }

    private void kontrolaImeNijeNull() throws EdunovaException {
        if (entitet.getIme() == null) {
            throw new EdunovaException("Ime ne smije biti null");
        }
    }

    private void kontrolaPrezime() throws EdunovaException {
        kontrolePrezimeNijeBroj();
        kontrolaPrezimeMinDuzina();
        kontrolaPrezimeMaxDuzina();
        kontrolaPrezimeNijeNull();
    }
     private void kontrolePrezimeNijeBroj() throws EdunovaException {
        boolean broj = false;

        try {
            Double.parseDouble(entitet.getPrezime());
            broj = true;
        } catch (Exception e) {

        }
        if (broj) {
            throw new EdunovaException("Prezime ne smije biti broj");
        }

    }

    private void kontrolaPrezimeMinDuzina() throws EdunovaException {
        if (entitet.getPrezime().trim().length() < 3) {
            throw new EdunovaException("Prezime mora imati barem 3 znaka");

        }
    }

    private void kontrolaPrezimeMaxDuzina() throws EdunovaException {
        if (entitet.getPrezime().trim().length() > 15) {
            throw new EdunovaException("Prezime moze imati maksimalno 15 znakova");

        }
    }

    private void kontrolaPrezimeNijeNull() throws EdunovaException {
        if (entitet.getPrezime() == null) {
            throw new EdunovaException("Prezime ne smije biti null");
        }
    }

 

}
