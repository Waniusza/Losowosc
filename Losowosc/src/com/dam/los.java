package com.dam;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author waniusza && damian
 */
public class los {

    
    private static long MOD = (Long.MAX_VALUE/2);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /*
        * zainicjalizowanie tabeli OXY  s
        */
        Generator generator = new Generator(MOD);
        
        int[] statsX = new int[10];
        int[] statsY = new int[10];
        
        for (int i=0 ; i<1000 ; i++) {
            long[] coordinates = generator.getCoordinates();
                    
            float x = (float) coordinates[0] / MOD;
            float y = (float) coordinates[1] / MOD;
             
            statsX[(int)(x*10)]++;
            statsY[(int)(y*10)]++;
            System.out.println("Wygenerowałem punkt : (" + x + " | " + y + ")");
          /*
          * wypełnienie punktu (x|y) kolorem
           */
        }
        
        
            System.out.println("Statystyka podpowiada: ");
            System.out.println("Równość rozproszenie na osi X : " + Arrays.toString(statsX));
            System.out.println("Równość rozproszenie na osi Y : " + Arrays.toString(statsY));
    }
}
