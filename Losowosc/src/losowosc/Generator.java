package losowosc;

/**
 *
 * @author student
 */
public class Generator {

    protected static long mod;
    protected static long value;
    protected int a, b, n;

    public Generator(int a, int b, int n, long mod) {
        this.mod = mod;
        this.a = a;
        this.b = b;
        this.n = n;
        value = Integer.MAX_VALUE;
        System.out.println("Inicjalizacja generatora : " + value);
    }

    public long[] getCoordinates() {
        long[] res = new long[2];
        res[0] = countValue();
        res[1] = countValue();
        return res;
    }

    protected long countValue() {
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
