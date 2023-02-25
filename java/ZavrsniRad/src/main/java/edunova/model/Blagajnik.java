package edunova.model;

import jakarta.persistence.Entity;

@Entity
public class Blagajnik extends Entitet {

    
    private String ime;
    private String prezime;

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Blagajnik(int sifra, String ime, String prezime) {
        super(sifra);
        this.ime = ime;
        this.prezime = prezime;
    }

    public Blagajnik() {
        super();
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

}
