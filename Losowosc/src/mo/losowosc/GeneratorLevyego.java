package mo.losowosc;

public class GeneratorLevyego extends Generator {

    public GeneratorLevyego(int a, int b, int n, long mod) {
        super(a, b, n, mod);
    }

    protected double countGauseValue() {

        // generuj X o rozkładzie równomiernym U(-1,1)
        double X = countValue() * 2 - 1;

        // generuj X o rozkładzie równomiernym U(0,1)
        double U = countValue();

        if ((U + 0.27324) * (1 + X * X) > 1.27324) {
            X = countValue() * 2 - 1;
        }

        // uzupelnienie rozkładu o "ramiona"
        if (countValue() > 0.5) {
            return X;
        } else {
            if (X != 0) {
                return (1 / X);
            } else {
                return Double.MAX_VALUE;
            }
        }
    }
}
