package edunova.model;

import edunova.util.Aplikacija;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Racun extends Entitet {
    
    
    @ManyToOne
    
    private Blagajnik blagajnik;

    private int brojRacuna;
    private Date datum;
    
    @ManyToMany (cascade = CascadeType.ALL)
    private List<StavkaRacuna> stavkeRacuna;
    private BigDecimal zaPlatiti;

    @Override
    public String toString() {

        

        return String.format("%-6s || %-21s || %s",brojRacuna , Aplikacija.df.format(datum),blagajnik) ;
    }

    public Racun(int sifra, Blagajnik blagajnik, int brojRacuna, Date datum, List<StavkaRacuna> stavkeRacuna,
            BigDecimal zaPlatiti) {
        super(sifra);
        
        this.blagajnik = blagajnik;
        this.brojRacuna = brojRacuna;
        this.datum = datum;
        this.stavkeRacuna = stavkeRacuna;
        this.zaPlatiti = zaPlatiti;
    }

    public Racun() {
        super();
        stavkeRacuna = new ArrayList<>();
    }

    public Blagajnik getBlagajnik() {
        return blagajnik;
    }

    public void setBlagajnik(Blagajnik blagajnik) {
        this.blagajnik = blagajnik;
    }

    public int getBrojRacuna() {
        return brojRacuna;
    }

    public void setBrojRacuna(int brojRacuna) {
        this.brojRacuna = brojRacuna;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public List<StavkaRacuna> getStavkeRacuna() {
        return stavkeRacuna;
    }

    public void setStavkeRacuna(List<StavkaRacuna> stavkeRacuna) {
        this.stavkeRacuna = stavkeRacuna;
    }

    public BigDecimal getZaPlatiti() {
        return zaPlatiti;
    }

    public void setZaPlatiti(BigDecimal zaPlatiti) {
        this.zaPlatiti = zaPlatiti;
    }

}
