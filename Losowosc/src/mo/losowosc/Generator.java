/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mo.losowosc;

/**
 *
 * @author Janusz Sokołow, Student of Gdańsk University of Technology
 */
public class Generator {

    static float mod = Float.MAX_VALUE;
    protected static float value;
    long a, b, n;

    public Generator(long a, long b, long n, long mod) {
        this.a = a;
        this.b = b;
        this.n = n;
        value = 0.123215f;
    }

    public float[] getCoordinates() {
        float[] res = new float[2];
        res[0] = countValue();
        res[1] = countValue();
        return res;
    }

    protected float countValue() {
        System.out.println("Generuję na podstawie " + value);
        double tmp = value * mod;
        if (tmp > Float.MAX_VALUE) {
            tmp %= Float.MAX_VALUE;
        }
        tmp = tmp * a + b;

        System.out.println("Mam  tmp : " + tmp + " i dziele przez " + mod);
        value = (float) ((tmp % mod) / mod);
        System.out.println("Wylosowalem: " + value);
        if (value > 0) {
            return value;
        } else {
            return -value;
        }
    }
}
