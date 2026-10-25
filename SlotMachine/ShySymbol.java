/**
 * Write a description of class ShySymbol here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShySymbol extends Symbol{
    private boolean shyVisible;

    
    /**
     * Constructor for objects of class ShySymbol
     */
    public ShySymbol(){
        super();
        this.symbolShape.changeSize(-30, 40);
        this.shyVisible = true;
    }
        
    public ShySymbol(String color){
        super(color);
        this.symbolShape.changeSize(-30, 40);
        this.shyVisible = true;
    }

    /**
     * Alternates the visibility of the symbol every time it is selected.
     */
    @Override
    public void action() {
        if (shyVisible) {
            shyVisible = false;
            makeInvisible();
        } else {
            shyVisible = true;
            makeVisible();
        }
    }
    
    /**
     * Returns the current shy state.
     *
     * @return true if the symbol should be visible.
     */
    public boolean isShyVisible() {
        return shyVisible;
    }
}