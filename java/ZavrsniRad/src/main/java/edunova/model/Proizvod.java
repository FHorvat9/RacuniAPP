package edunova.model;

import jakarta.persistence.Entity;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Entity
public class Proizvod extends Entitet {

	private String imeProizvoda;
	private BigDecimal cijena;

	public String getImeProizvoda() {
		return imeProizvoda;
	}

	public void setImeProizvoda(String imeProizvoda) {
		this.imeProizvoda = imeProizvoda;
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
		return imeProizvoda +" " + cijena+" kn || "+ cijena.divide(BigDecimal.valueOf(7.53450), 2, RoundingMode.HALF_DOWN)+" eur";
	}
	

}
