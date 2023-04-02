/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.controller;

import edunova.model.Blagajnik;
import edunova.model.Racun;
import edunova.model.StavkaRacuna;
import edunova.util.EdunovaException;
import edunova.util.OibUtil;
import java.util.ArrayList;
import java.util.Collections;
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
        kontrolaOib();
        kontrolaDupliOib();

    }

    @Override
    public void kontrolaPromjena() throws EdunovaException {
        kontrolaIme();
        kontrolaPrezime();
        kontrolaOib();
    }

    @Override
    public void kontrolaBrisanje() throws EdunovaException {
        if (entitet.getRacuni() != null && !entitet.getRacuni().isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Blagajnik se nemoze obrisati jer se nalazi na sljedecim racunima:\n");
            List<Integer> sortiraniBrojeviRacuna = new ArrayList<>();
            for (Racun sr : entitet.getRacuni()) {
                sortiraniBrojeviRacuna.add(sr.getBrojRacuna());
            }
            Collections.sort(sortiraniBrojeviRacuna);

            for (int br : sortiraniBrojeviRacuna) {
                sb.append(br + "\n");
            }
            throw new EdunovaException(sb.toString());
        }
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

    private void kontrolaDupliOib() throws EdunovaException {
        List<Blagajnik> proizvodi = null;
        try {
            proizvodi = session.createQuery("from Blagajnik b "
                    + " where b.oib=:oib ",
                    Blagajnik.class)
                    .setParameter("oib", entitet.getOib())
                    .list();
        } catch (Exception e) {
        }
        if (proizvodi != null && !proizvodi.isEmpty()) {
            throw new EdunovaException("Blagajnik s istim oibom vec postoji");
        }

    }

    private void kontrolaOib() throws EdunovaException {
        if (entitet.getOib() == null) {
            throw new EdunovaException("Oib ne smije biti null");
        }
        if (!entitet.getOib().matches("[0-9]+")) {
            throw new EdunovaException("Oib moze sadrzavati samo brojeve");
        }

        if (entitet.getOib().length() != 11) {
            throw new EdunovaException("Oib nije ispravne duljine");
        }

        if (!OibUtil.provjeriOib(entitet.getOib())) {
            throw new EdunovaException("Oib nije valjan");
        }

    }

}
