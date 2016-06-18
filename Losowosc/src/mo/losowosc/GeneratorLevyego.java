package mo.losowosc;

public class GeneratorLevyego extends Generator {

    public GeneratorLevyego(long a, long b, long n, long mod) {
        super(a, b, n, mod);
    }

    @Override
    public float countValue() {

        // generuj X o rozkładzie równomiernym U(-1,1)
        double X = super.countValue() * 2 - 1;

        // generuj X o rozkładzie równomiernym U(0,1)
        double U = super.countValue();

        if ((U + 0.27324) * (1 + X * X) > 1.27324) {
            X = super.countValue() * 2 - 1;
        }

        System.out.println("Levy otrzymał : " + X + " i dzieli przez " + mod);

        // uzupelnienie rozkładu o "ramiona"
        return Math.abs((float) X);
    }
}
