/**
 * Rueda que gira en sentido contrario al indicado (Elemento propuesto Requisito 19).
 * 
 * @author David Páez y Joseph Cañon
 * @version Octubre 2026
 */
public class ReverseWheel extends Wheel {

    /**
     * Constructor for objects of class ReverseWheel
     */
    public ReverseWheel() {
        super();
        this.wheelShape.changeColor("orange");
    }
    
    public ReverseWheel(int pos) {
        super(pos);
        this.wheelShape.changeColor("orange");
    }
    
    /**
     * Sobrescribe el método spin para invertir la dirección del giro.
     * Si se le pide girar N pasos adelante, gira N pasos hacia atrás y viceversa.
     */
    @Override
    public void spin(int times) {
        super.spin(-times);
    }
}