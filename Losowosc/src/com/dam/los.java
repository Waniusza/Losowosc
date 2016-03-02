package com.dam;

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
        
        for (int i=0 ; i<1000 ; i++) {
            long[] coordinates = generator.getCoordinates();
                    
            float x = (float) coordinates[0] / MOD;
            float y = (float) coordinates[1] / MOD;
             
            System.out.println("Wygenerowałem punkt : (" + x + " | " + y + ")");
          /*
          * wypełnienie punktu (x|y) kolorem
           */
        }
    }
}
