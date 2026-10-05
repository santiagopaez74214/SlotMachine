
/**
 * Write a description of class RebelWheel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RebelWheel extends Wheel{

    /**
     * Constructor for objects of class RebelWheel
     */
    public RebelWheel(){
        super();
        this.wheelShape.changeColor("red");
    }
    
    public RebelWheel(int pos){
        super(pos);
        this.wheelShape.changeColor("red");
    }
    
    @Override
    public void lock() {
    }
}