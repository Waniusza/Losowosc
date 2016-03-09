package losowosc;

/**
 *
 * @author student
 */
public abstract class Generator {

    protected static long mod;
    protected static long value;
    protected int a, b, n;

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
    
    protected abstract long countValue();

}
