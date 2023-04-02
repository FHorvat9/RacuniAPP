/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.util;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Feecho
 */
public class OibUtil {

    public static String generirajOib() {

        StringBuilder oib = new StringBuilder();
        oib.append(slucajniBroj(10));
        int znamenka = Integer.parseInt(String.valueOf(oib.charAt(0))) + 10;
        int kontrolnaZnamenka = 0;
        for (int i = 0; i < 10; i++) {

            if (znamenka % 10 == 0) {
                znamenka = 10;
            } else {
                znamenka = znamenka % 10;
            }
            znamenka *= 2;
            znamenka = znamenka % 11;
            if (i == 9) {
                break;
            }
            znamenka += Integer.parseInt(String.valueOf(oib.charAt(i + 1)));

        }

        if (11 - znamenka != 10) {

            kontrolnaZnamenka = 11 - znamenka;
        }
        oib.append(kontrolnaZnamenka);

        return oib.toString();
    }

    public static Boolean provjeriOib(String oib)    {
        
        
        StringBuilder sb= new StringBuilder();
        sb.append(oib);
        char kontrolnaZnamenkaUnos = sb.charAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
        
        int znamenka = Integer.parseInt(String.valueOf(oib.charAt(0))) + 10;
        int kontrolnaZnamenkaRacun = 0;
        for (int i = 0; i < 10; i++) {

            if (znamenka % 10 == 0) {
                znamenka = 10;
            } else {
                znamenka = znamenka % 10;
            }
            znamenka *= 2;
            znamenka = znamenka % 11;
            if (i == 9) {
                break;
            }
            znamenka += Integer.parseInt(String.valueOf(oib.charAt(i + 1)));

        }

        if (11 - znamenka != 10) {

            kontrolnaZnamenkaRacun = 11 - znamenka;
        }
        
        if(kontrolnaZnamenkaRacun!=Integer.parseInt(String.valueOf(kontrolnaZnamenkaUnos))){
            return false;
        }
        return true;

    }

    private static long slucajniBroj(int brojznamenki) {
        long min = (long) Math.pow(10, brojznamenki - 1);
        return ThreadLocalRandom.current().nextLong(min, min * 10);
    }

}
