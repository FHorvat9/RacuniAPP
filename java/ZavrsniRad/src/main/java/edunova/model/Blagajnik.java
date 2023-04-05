package edunova.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Blagajnik extends Entitet {

    private String ime;
    private String prezime;
    private String oib;
  
    
    @OneToMany(mappedBy = "blagajnik")
    private List<Racun> racuni;

    public String getOib() {
        return oib;
    }

    public void setOib(String oib) {
        this.oib = oib;
    }

    public String getIme() {
        return ime;
    }

    public List<Racun> getRacuni() {
        return racuni;
    }

    public void setRacuni(List<Racun> racuni) {
        this.racuni = racuni;
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

    public Blagajnik(String ime, String prezime) {
        super();
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
