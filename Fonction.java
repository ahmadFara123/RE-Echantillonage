/**
 * Responsable de generer le code necessaire pour
 * trouver les arguments d'une fonction
 */
abstract class Fonction {

    protected double position ;
    protected double h  ;
    protected double y  ;
    protected double y1 ;
    protected double y2 ;
    protected double y3 ;



    /**
     * Constructeur pour une fonction du premier degre
     * @param position la valeur de x0
     * @param h  la distance entre chaque x
     * @param y1 l'image de la fonction a x0 + h
     * @param y  l'image de la fonction a x0
     */
    public Fonction(double position, double h, double y1, double y ) {
        this.position = position;
        this.h = h;
        this.y = y;
        this.y1 = y1;
    }

    /**
     * Constructeur pour une fonction du second degre
     * @param position la valeur de x0
     * @param h la distance entre chaque x
     * @param y2 l'image de la fonction a x0 + 2h
     * @param y1 l'image de la fonction a x0 + h
     * @param y l'image de la fonction a x0
     */
    public Fonction(double position, double h, double y2, double y1, double y) {
        this.position = position;
        this.h = h;
        this.y = y;
        this.y1 = y1;
        this.y2 = y2;
    }

    /**
     * Constructeur pour une fonction du troisieme degre
     * @param position la valeur de x0
     * @param h la distance entre chaque x
     * @param y3 l'image de la fonction a x0 + 3h
     * @param y2 l'image de la fonction a x0 + 2h
     * @param y1 l'image de la fonction a x0 + h
     * @param y l'image de la fonction a x0
     */
    public Fonction(double position, double h, double y3, double y2, double y1, double y) {
        this.position = position;
        this.h = h;
        this.y = y;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
    }
    public double getY2() {
        return y2;
    }

    protected  double getY3() {
        return y3;
    }

    protected  double getPosition() {
        return position;
    }

    protected double getH() {
        return h;
    }

    protected double getY() {
        return y;
    }

    protected  double getY1() {
        return y1;
    }

    /**
     *Calcule la difference entre deux images a t = x0
     * @return valeur de delta
     */
    protected double  calculerDelta0(){ return getY1()- getY() ; }

    /**
     *Calcule la difference entre deux images a t = x0 + h
     * @return valeur de delta
     */
    protected double  calculerDelta1(){ return getY2()- getY1(); }
    /**
     *Calcule la difference entre deux images  a t = x0 + 2h
     * @return valeur de delta
     */
    protected double  calculerDelta2(){ return getY3()- getY2(); }
    /**
     *Calcule la difference entre delta  a t = x0
     * @return valeur de omega
     */
    protected double omega1 () { return calculerDelta1() - calculerDelta0(); }
    /**
     *Calcule la difference entre deux delta  a t = x0 + h
     * @return valeur de omega
     */
    protected double omega2 () { return calculerDelta2() - calculerDelta1(); }
    /**
     *Calcule la difference de deux omega a different temps
     * @return valeur de omega total
     */

    protected double omega3 () { return omega2() - omega1() ;}

    /**
     * calcule de l'argument A selon chaque degre
     * @return la valeur de A
     */
    abstract double calculerA() ;
    /**
     * calcule de l'argument A selon chaque degre
     * @return la valeur de A
     */
    abstract double calculerB() ;
    /**
     * Aide a trouver l'image a un temps x
     * @return l'image de la fonction a un moment donner
     */
    abstract double calculerY(double x ) ;



}
