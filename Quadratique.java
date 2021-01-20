/**
 * Calcule les arguments pour obtenir une fonction :
 * y = ax^2 + bx + c
 */
public class Quadratique extends Fonction {

    public Quadratique(double position, double h, double y2, double y1, double y) {
        super(position, h, y2, y1, y);
    }

    @Override
    double calculerA() {
        return omega1() / 2*(getH()*getH());
    }

    @Override
    double calculerB() {
        return (calculerDelta0() / getH()) -
                calculerA()*(getPosition() + (getPosition()+getH()));
    }
    protected double calculerC(){
        return getY()  - calculerB()*getPosition() - calculerA()*(getPosition()*getPosition());
    }

    @Override
    double calculerY(double x) {
        return calculerA() * (x*x)
                + calculerB()*x
                +calculerC();
    }


}

