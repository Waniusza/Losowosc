package mo.losowosc;

public class GeneratorGausowski extends Generator {

    public GeneratorGausowski(long a, long b, long n, long mod) {
        super(a, b, n, mod);
    }

    public float countValue() {
        boolean ok = false;
        double limit = Math.sqrt(2 / 2.718281828);
        double X;

        do {
            // generuj U o rozkładzie równomiernym U(0,1) 
            double U = super.countValue();

            // generuj V o rozkładzie równomiernym
            // U(-sqrt(2/e),sqrt(2/e))
            double V = 2 * limit * super.countValue() - limit;
            X = V / U;

            if (X * X <= 2 * (3 - U * (4 + U))) {

                ok = true;

            } else if (X * X <= 2 / U - 2 * U) {

                if (X * X <= -4 * Math.log(U)) {
                    ok = true;
                }

            }
        } while (!ok);

        System.out.println("Gauss otrzymał : " + X + " i dzieli przez " + mod);

        return (float) Math.abs(X / 2);

    }
}
