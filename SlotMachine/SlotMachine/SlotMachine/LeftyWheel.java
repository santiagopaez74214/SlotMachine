import java.util.ArrayList;

/**
 * Write a description of class LeftyWheel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LeftyWheel extends Wheel{
    private Wheel leftWheel;

    /**
     * Constructor for objects of class LeftyWheel
     */
    public LeftyWheel(){
        super();
        this.leftWheel = null;
        this.wheelShape.changeColor("lightblue");    
    }

    public LeftyWheel(int pos){
        super(pos);
        this.leftWheel = null;
        this.wheelShape.changeColor("lightblue");
    }
    
     /**
     * Defines the wheel located to the left.
     * @param leftWheel the wheel to the left.
     */
    public void setLeftWheel(Wheel leftWheel) {
        this.leftWheel = leftWheel;
    }

    /**
     * Returns the wheel located to the left.
     * @return the left wheel.
     */
    public Wheel getLeftWheel() {
        return this.leftWheel;
    }

    /**
     * Spins the lefty wheel.
     * If there is a wheel to the left, it copies its current symbol.
     * Otherwise it behaves like a normal wheel.
     * @param times number of positions.
     */
    @Override
    public void spin(int times) {
        if (leftWheel != null) {
            copyStateFrom(leftWheel);
        } 
        else {
            super.spin(times);
        }
    }

    /**
     * Spins one position.
     */
    @Override
    public void spin() {
        spin(1);
    }
}
