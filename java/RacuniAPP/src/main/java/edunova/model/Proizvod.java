package edunova.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Entity
public class Proizvod extends Entitet {

	private String imeProizvoda;
	private BigDecimal cijena;
        
        @OneToMany(mappedBy = "proizvod")
        private List<StavkaRacuna> racuni;

	public String getImeProizvoda() {
		return imeProizvoda;
	}

	public void setImeProizvoda(String imeProizvoda) {
		this.imeProizvoda = imeProizvoda;
	}

    public List<StavkaRacuna> getRacuni() {
        return racuni;
    }

    public void setRacuni(List<StavkaRacuna> racuni) {
        this.racuni = racuni;
    }

	public BigDecimal getCijena() {
		return cijena;
	}

	public void setCijena(BigDecimal cijena) {
		this.cijena = cijena;
	}

	public Proizvod() {
		super();
	}

	public Proizvod(int sifra, String imeProizvoda, BigDecimal cijena) {
		super(sifra);
		this.imeProizvoda = imeProizvoda;
		this.cijena = cijena;
	}

	@Override
	public String toString() {			
		return imeProizvoda +" " +cijena.setScale(2, RoundingMode.DOWN) +" kn";
	}
	

}
