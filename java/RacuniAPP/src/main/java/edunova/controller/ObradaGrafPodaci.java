/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.controller;

import edunova.model.GrafPodaci;
import edunova.model.Proizvod;
import edunova.util.HibernateUtil;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;

/**
 *
 * @author Feecho
 */
public class ObradaGrafPodaci {

    private Session session = HibernateUtil.getSession();

    public GrafPodaci read(String imeProizvoda, int godina) {

        Object[] objekt = session.createNativeQuery(" select kolicina, imeProizvoda, sum(kolicina) as ukupno from racun r join racun_stavkaracuna rs on r.sifra = rs.Racun_sifra "
                + " join stavkaracuna s on rs.stavkeRacuna_sifra = s.sifra  "
                + " join proizvod p  on proizvod_sifra = p.sifra "
                + " where imeProizvoda =:ime and datum between '" + godina + "-01-1 00:00:00.000' and '" + godina + "-12-31 23:59:59.000'",
                Object[].class
        ).setParameter("ime", imeProizvoda)
                .getSingleResult();

        GrafPodaci gf = new GrafPodaci();

        gf.setKolicina((BigDecimal) objekt[2]);
        try {
            gf.setImeProizvoda(objekt[1].toString());
        } catch (Exception e) {
          
        }


        return gf;
    }

}
