package edunova.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
public class StavkaRacuna extends Entitet {

    @ManyToOne
    private Proizvod proizvod;
    private int kolicina;
    private BigDecimal cijenaProizvoda;
    private BigDecimal ukupnaCijenaProizvoda;
    private int brojRacuna;

    public StavkaRacuna() {
        super();
    }

    public StavkaRacuna(int sifra, Proizvod proizvod, int kolicina, BigDecimal cijenaProizvoda,
            BigDecimal ukupnaCijenaProizvoda, int brojRacuna) {
        super(sifra);
        this.proizvod = proizvod;
        this.kolicina = kolicina;
        this.cijenaProizvoda = cijenaProizvoda;
        this.ukupnaCijenaProizvoda = ukupnaCijenaProizvoda;
        this.brojRacuna = brojRacuna;
    }

    public Proizvod getProizvod() {
        return proizvod;
    }

    public void setProizvod(Proizvod proizvod) {
        this.proizvod = proizvod;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public BigDecimal getCijenaProizvoda() {
        return cijenaProizvoda;
    }

    public void setCijenaProizvoda(BigDecimal cijenaProizvoda) {
        this.cijenaProizvoda = cijenaProizvoda;
    }

    public BigDecimal getUkupnaCijenaProizvoda() {
        return ukupnaCijenaProizvoda;
    }

    public void setUkupnaCijenaProizvoda(BigDecimal ukupnaCijenaProizvoda) {
        this.ukupnaCijenaProizvoda = ukupnaCijenaProizvoda;
    }

    public int getBrojRacuna() {
        return brojRacuna;
    }

    public void setBrojRacuna(int brojRacuna) {
        this.brojRacuna = brojRacuna;
    }

    @Override
    public String toString() {
        return proizvod + " " + kolicina + " " + ukupnaCijenaProizvoda + "kn ";
    }

}
