/**
 * Represents a symbol inside a slot machine wheel.
 * The symbol is graphically represented by a Triangle shape on the canvas.
 * 
 * @author David Páez and Joseph
 * @version August 2026
 */
public class Symbol {
    private String color;
    private Triangle symbolShape;
    private int xPos;
    private int yPos;
    private boolean isVisible;

    /**
     * Default constructor for objects of class Symbol.
     * Initializes a default green symbol at position (0, 0) and sets it to visible.
     */
    public Symbol() {
        this.color = "green";
        this.symbolShape = new Triangle();
        this.xPos = 0;
        this.yPos = 0;
        this.isVisible = true;
    }

    /**
     * Creates a new symbol with a specific color.
     * 
     * @param color The color to be applied to the symbol (using CSS standard colors).
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
     * Retrieves the current color of the symbol.
     * 
     * @return A String representing the color of the symbol.
     */
    public String getColor() {
        return this.color;
    }
    
    /**
     * Defines the position of the symbol on the graphical canvas.
     * 
     * @param x The X coordinate for the position.
     * @param y The Y coordinate for the position.
     */
    public void setPosition(int x, int y) {
        this.xPos = x;
        this.yPos = y;
        this.symbolShape.changePosition(x, y);
    }
    
    /**
     * Makes this symbol visible on the canvas.
     * If it was already visible, it does nothing.
     */
    public void makeVisible() {
        this.isVisible = true;
        this.symbolShape.makeVisible();
    }
    
    /**
     * Makes this symbol invisible on the canvas. 
     * If it was already invisible, it does nothing.
     */
    public void makeInvisible() {
        this.isVisible = false;
        this.symbolShape.makeInvisible();
    }    

}