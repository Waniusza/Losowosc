package losowosc;

public class GeneratorGausowski extends Generator{

    public GeneratorGausowski(int a, int b, int n, long mod) {
        super(a,b,n,mod);
    }

    @Override
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
