package edunova.model;

import jakarta.persistence.Entity;
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
    @ManyToMany
    private List<StavkaRacuna> stavkeRacuna;
    private BigDecimal zaPlatiti;

    @Override
    public String toString() {

        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy. - HH:mm:ss");
//        return String.format("|%-6s||%-6s||%-22s||%-22s||", brojRacuna,zaPlatiti,df.format(datum),blagajnik.toString());
        return brojRacuna + " " + blagajnik + " " + df.format(datum) + " " + zaPlatiti;
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
