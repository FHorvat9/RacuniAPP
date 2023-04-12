/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.model;

import java.math.BigDecimal;
import java.sql.Date;





/**
 *
 * @author Feecho
 */
public class GrafPodaci {
    
    
    private BigDecimal kolicina;
    private String imeProizvoda;

    public BigDecimal getKolicina() {
        return kolicina;
    }

    public void setKolicina(BigDecimal kolicina) {
        this.kolicina = kolicina;
    }

   

 

    public String getImeProizvoda() {
        return imeProizvoda;
    }

    public void setImeProizvoda(String imeProizvoda) {
        this.imeProizvoda = imeProizvoda;
    }

   

   

 

  


    @Override
    public String toString() {
        return "GrafPodaci{" + "kolicina=" + kolicina + ", imeProizvoda=" + imeProizvoda + '}';
    }
    
    
}
