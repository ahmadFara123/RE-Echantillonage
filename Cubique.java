/**
 * Calcule les arguments de la fonction cubique :
 * y = ax^3 + bx^2 + cx + d
 */
public class Cubique extends Fonction {


    public Cubique(double position, double h, double y3, double y2, double y1, double y) {
        super(position, h, y3, y2, y1, y);
    }

    @Override
    double calculerA() {
        return omega3() / (6 * (getH() * getH() * getH()));
    }

    @Override
    double calculerB() {
        double x1 = getPosition();
        double x2 = getPosition() + getH();
        double x3 = getPosition() + getH() + getH();
        return (omega1() / (2 * (getH() * getH()))) - (calculerA() * (x1 + x2 + x3));
    }

    private double calculerC() {
        double x1 = getPosition();
        double x2 = getPosition() + getH();
        return (calculerDelta0() / getH()) - calculerB()
                * (x1 + x2) - calculerA()
                * ((x1 * x1) + (x1 * x2) + (x2 * x2));
    }

    @Override
    double calculerY(double x) {
        return (calculerA() * (x * x * x))
                + (calculerB() * (x * x))
                + (calculerC() * x) + calculerD();
    }

    private double calculerD() {
        return getY() - (calculerC() * getPosition())
                - (calculerB() * (getPosition() * getPosition()))
                - (calculerA() * (getPosition() * getPosition() * getPosition()));
    }
}


