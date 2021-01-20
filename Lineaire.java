/**
 * Calcule les arguments pour obtenir une fonction lineaire  :
 * y = ax + b
 */
public class Lineaire  extends Fonction{

    public Lineaire(double position, double h, double y1, double y) {
        super(position, h, y1, y);
    }

    @Override
    protected double calculerA() {
        return calculerDelta0() /getH() ;
    }

    @Override
    protected double calculerB() {
        return getY() - calculerA()*getPosition() ;
    }
    @Override
    double calculerY (double x ){
        return calculerA()*x + calculerB() ;
    }

}

