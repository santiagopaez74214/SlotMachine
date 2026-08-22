
/**
 * Write a description of class Symbol here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Symbol {
    private String color;
    private Triangle symbolShape;
    private int xPos;
    private int yPos;
    private boolean isVisible;

    /**
     * Constructor for objects of class Symbol
     */
    public Symbol() {
        this.color = "green";
        this.symbolShape = new Triangle();
        this.xPos = 0;
        this.yPos = 0;
        this.isVisible = true;
    }

    /**
     * 
     */
    public Symbol(String color) {
        this.color = color;
        this.symbolShape = new Triangle();
        this.symbolShape.changeColor(color);
        this.xPos = 0;
        this.yPos = 0;
        this.isVisible = true;
    }
    
    /**
     * 
     */
    public String getColor() {
        return this.color;
    }
    
    /**
     * 
     */
    public void makeVisible() {
        this.isVisible = true;
        this.symbolShape.makeVisible();
    }
    
    /**
     * Make this symbol invisible. If it was already invisible, do nothing.
     */
    public void makeInvisible() {
        this.isVisible = false;
        this.symbolShape.makeInvisible();
    }    

}
