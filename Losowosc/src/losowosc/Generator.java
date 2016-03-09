package losowosc;

import java.math.BigDecimal;

public class Generator {

    private static long mod;
    private static long value;
    private int a, b, n;

    public Generator(int a, int b, int n, long mod) {
        this.mod = mod;
        this.a = a;
        this.b = b;
        this.n = n;
        value = (long) (Math.pow(System.currentTimeMillis(), 2) % mod);
        System.out.println("Inicjalizacja generatora : " + value);
    }

    public long[] getCoordinates() {
        long[] res = new long[2];
        res[0] = countValue();
        res[1] = countValue();
        return res;
    }

    private long countValue() {
        double tmp = a * value + b;
        System.out.println("Mam  tmp : " + tmp);
        value = (long) tmp % mod;
        System.out.println("Wylosowalem: " + value);
        if (value > 0) {
            return value;
        } else {
            return -value;
        }
    }
}
