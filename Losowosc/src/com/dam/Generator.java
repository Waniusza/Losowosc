package com.dam;

/**
 *
 * @author waniusza
 */
public class Generator {

    private static long mod;
    private static long value;
    private static long increase = 214531366;

    public Generator(long mod) {
        this.mod = mod;
        value = System.currentTimeMillis();
    }

    public static long[] getCoordinates() {
        long[] res = new long[2];
        res[0] = countValue();
        res[1] = countValue();
        return res;
    }

    private static long countValue() {
        value = ((18L * value + increase) * 3) % mod;
        if (value > 0) {
            return value;
        } else {
            return -value;
        }
    }
}
