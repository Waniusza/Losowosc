package losowosc;

public class GeneratorRownomierny extends Generator{


    public GeneratorRownomierny(int a, int b, int n, long mod) {
        super(a,b,n,mod);
    }

    @Override
    protected long countValue() {
        return 0;
    }
}
