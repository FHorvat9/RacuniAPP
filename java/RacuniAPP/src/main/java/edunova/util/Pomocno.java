/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.util;

import edunova.controller.ObradaRacun;
import edunova.model.Racun;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Feecho
 */
public class Pomocno {

    

    public static int brojIzmedju(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);

    }
    
   
}
