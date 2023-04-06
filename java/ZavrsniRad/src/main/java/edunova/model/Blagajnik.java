package edunova.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Blagajnik extends Entitet {

    private String ime;
    private String prezime;
    private String oib;
    
   @Column(columnDefinition = "char(61)")
    private char[] lozinka;
    private String username;
    
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

    public char[] getLozinka() {
        return lozinka;
    }

    public void setLozinka(char[] lozinka) {
        this.lozinka = lozinka;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Blagajnik() {
        super();
    }

    public Blagajnik(String ime, String prezime, String oib, char[] lozinka, String username) {
        super();
        this.ime = ime;
        this.prezime = prezime;
        this.oib = oib;
        this.lozinka = lozinka;
        this.username = username;
    }

  

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

}
