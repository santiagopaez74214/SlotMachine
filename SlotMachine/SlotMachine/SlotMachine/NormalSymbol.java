
/**
 * Write a description of class NormalSymbol here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NormalSymbol extends Symbol{

    /**
     * Constructor for objects of class NormalSymbol
     */
    public NormalSymbol(){
        super();
    }

    public NormalSymbol(String color){
        super(color);
    }    
    
    /**
     * A normal symbol does not change when selected.
     */
    @Override
    public void selected() {
    }
}
