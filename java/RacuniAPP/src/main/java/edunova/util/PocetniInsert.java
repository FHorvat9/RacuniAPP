/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.util;

import com.github.javafaker.Faker;
import edunova.model.Blagajnik;
import edunova.model.Proizvod;
import edunova.model.Racun;
import edunova.model.StavkaRacuna;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.hibernate.Session;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Feecho
 */
public class PocetniInsert {

    private final int BROJ_BLAGAJNIKA = 20;
    private final int BROJ_PROIZVODA = 100;
    private final int BROJ_RACUNA = 1000;
    private final int BROJ_STAVKI = 10;

    private Faker faker = new Faker(new Locale.Builder().setLanguage("hr").setRegion("HR").build());
    private List<Blagajnik> blagajnici;
    private List<Proizvod> proizvodi;
    private List<StavkaRacuna> stavke;
    private List<Racun> racuni;
    private Session s;

    public PocetniInsert() {
        s = HibernateUtil.getSession();
        s.beginTransaction();
        blagajnici = new ArrayList<>();
        proizvodi = new ArrayList<>();
        stavke = new ArrayList<>();
        racuni = new ArrayList<>();

        kreirajLoginBlagajnika();
        kreirajBlagajnike();
        kreirajProizvode();
        kreirajRacune();

        s.getTransaction().commit();

    }

    private void kreirajBlagajnike() {
        Blagajnik b;
        for (int i = 0; i < BROJ_BLAGAJNIKA; i++) {
            b = new Blagajnik();
            b.setIme(faker.name().firstName());
            b.setPrezime(faker.name().lastName());
            b.setOib(OibUtil.generirajOib());
            b.setUsername(b.getIme() + " " + b.getPrezime());
            b.setLozinka(BCrypt.hashpw("123", BCrypt.gensalt()).toCharArray());
            s.persist(b);
            blagajnici.add(b);
        }

    }

    private void kreirajProizvode() {
        Proizvod p;
        for (int i = 0; i < BROJ_PROIZVODA; i++) {
            p = new Proizvod();
            p.setCijena(BigDecimal.valueOf(faker.number().randomDouble(2, 0, 50)));
            p.setImeProizvoda(faker.commerce().productName());
           
            
            s.persist(p);
            proizvodi.add(p);
        }

    }

    private void kreirajRacune() {
        Racun r;
        int indexBlagajnik;
        for (int i = 0; i < BROJ_RACUNA; i++) {
            r = new Racun();
            indexBlagajnik = Pomocno.brojIzmedju(0, BROJ_BLAGAJNIKA - 1);
            r.setBlagajnik(blagajnici.get(indexBlagajnik));
            r.setDatum(faker.date().birthday(0, 10));
            r.setBrojRacuna(faker.number().numberBetween(100000, 1000000));
            r.setStavkeRacuna(kreirajStavke(r.getBrojRacuna()));

            BigDecimal zaPlatit = BigDecimal.valueOf(0);
            for (StavkaRacuna stavka : r.getStavkeRacuna()) {
                zaPlatit = zaPlatit.add(stavka.getUkupnaCijenaProizvoda());
            }
            r.setZaPlatiti(zaPlatit);
            s.persist(r);
        }
    }

    private List<StavkaRacuna> kreirajStavke(int brojRacuna) {
        List<StavkaRacuna> tempStavke = new ArrayList<>();
        StavkaRacuna stavka;
        for (int i = 0; i < Pomocno.brojIzmedju(1, BROJ_STAVKI); i++) {
            stavka = new StavkaRacuna();
            stavka.setProizvod(proizvodi.get(Pomocno.brojIzmedju(0, BROJ_PROIZVODA - 1)));
            stavka.setBrojRacuna(brojRacuna);
            stavka.setKolicina(faker.number().numberBetween(0, 10));
            stavka.setCijenaProizvoda(stavka.getProizvod().getCijena());
            stavka.setUkupnaCijenaProizvoda(stavka.getCijenaProizvoda().multiply(BigDecimal.valueOf(stavka.getKolicina())));
            stavke.add(stavka);
            tempStavke.add(stavka);
            s.persist(stavka);

        }
        return tempStavke;
    }

    public void kreirajLoginBlagajnika() {
        Blagajnik b = new Blagajnik();
        b.setIme("Filip");
        b.setPrezime("Horvat");
        b.setOib(OibUtil.generirajOib());
        b.setUsername(b.getIme() + " " + b.getPrezime());
        b.setLozinka(BCrypt.hashpw("123", BCrypt.gensalt()).toCharArray());
        s.persist(b);
        blagajnici.add(b);
    }

}
