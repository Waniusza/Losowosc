package losowosc;

public class GeneratorGausowski extends Generator {

    public GeneratorGausowski(int a, int b, int n, long mod) {
        super(a, b, n, mod);
    }


    protected double countGauseValue() {
        boolean ok = false;
        double limit = Math.sqrt(2/2.718281828);
        double X;

        do {
            // generuj U o rozkładzie równomiernym U(0,1) 
            double U = countValue();

        // generuj V o rozkładzie równomiernym
            // U(-sqrt(2/e),sqrt(2/e))
            double V = 2 * limit * countValue() - limit;
            X = V / U;

            if (X * X <= 2 * (3 - U * (4 + U))) {

                ok = true;

            } else if (X * X <= 2 / U - 2 * U) {

                if (X * X <= -4 * Math.log(U)) {
                    ok = true;
                }

            }
        } while (!ok);

        return X;
    }
}
