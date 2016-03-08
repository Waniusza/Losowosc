package losowosc;

public class Generator {

    private static long mod;
    private static long value;
    private int a, b, n;
    
    public Generator(int a, int b, int n, long mod) {
        this.mod = mod;
        this.a = a;
        this.b = b;
        this.n = n;
        value = System.currentTimeMillis() * System.currentTimeMillis();
    }

    public long[] getCoordinates() {
        long[] res = new long[2];
        res[0] = countValue();
        res[1] = countValue();
        return res;
    }

    private long countValue() {
        value = (long)(((((double) a) * value + b + 346675) * n) % mod);
        if (value > 0) {
            return value;
        } else {
            return -value;
        }
    }
}
