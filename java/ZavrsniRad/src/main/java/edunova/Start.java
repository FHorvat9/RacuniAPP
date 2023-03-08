/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package edunova;

import edunova.controller.ObradaBlagajnik;
import edunova.model.Blagajnik;
import edunova.util.EdunovaException;
import edunova.util.PocetniInsert;
import edunova.view.SplashScreen;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dell
 */
public class Start {
    
    public static void main(String[] args) {
//      new PocetniInsert();

//        ObradaBlagajnik ob = new ObradaBlagajnik();
//        
//        Blagajnik bl = new Blagajnik();
//        bl.setIme("");
//        ob.setEntitet(bl);
//        try {
//            ob.create();
//        } catch (EdunovaException ex) {
//            System.out.println(ex.getPoruka());
//        }
//        
//        for (Blagajnik b : ob.read()) {
//            System.out.println(b.getIme());
//        }
        new SplashScreen().setVisible(true);
        
    }
}
