/**
 * Represents a single wheel in the slot machine.
 * It manages a collection of symbols and handles its own visual representation and spinning logic.
 * 
 * @author David Páez and Joseph
 * @version August 2026
 */
import java.util.*;

public class Wheel {
    private int pos;
    public ArrayList<Symbol> symbols;
    private boolean isVisible;
    private int xPos;
    private int yPos;
    private Rectangle wheelShape;
    private int currentSymbol;

    /**
     * Default constructor for objects of class Wheel.
     * Initializes an empty wheel with default visual settings and positions.
     */
    public Wheel() {
        this.pos = 0;
        this.symbols = new ArrayList<Symbol>();
        this.isVisible = true;
        this.currentSymbol = 0;
        
        this.wheelShape = new Rectangle();
    }
    
    /**
     * Creates a new Wheel with a specific identifier/position and sets its visual dimensions.
     * 
     * @param pos The initial position or identifier for this wheel.
     */
    public Wheel(int pos) {
        this.pos = pos;
        this.symbols = new ArrayList<Symbol>();
        this.isVisible = true;
        this.currentSymbol = 0;
        
        this.wheelShape = new Rectangle();
        this.wheelShape.changeSize(140, 60);
        this.wheelShape.changeColor("white");
    }
    
    /**
     * Defines the visual position of the wheel on the canvas and centers its symbols.
     * 
     * @param x The X coordinate for the wheel's position.
     * @param y The Y coordinate for the wheel's position.
     */
    public void setPosition(int x, int y) {
        this.xPos = x;
        this.yPos = y;
        this.wheelShape.changePosition(x, y);
        int symbolX = x + 30;
        int symbolY = y + 55;
        
        for (int i = 0; i < symbols.size(); i++) {
            symbols.get(i).setPosition(symbolX, symbolY);
        }
    }
    
    /**
     * Adds a new symbol to the wheel and aligns it correctly.
     * Ensures that no duplicate colors exist within the same wheel.
     * 
     * @param color The color of the new symbol (using CSS standard colors).
     * @return true if the symbol was successfully added, false if a symbol with that color already exists.
     */
    public boolean addSymbol(String color) {
        for (int i = 0; i < symbols.size(); i++) {
            Symbol symbol = symbols.get(i);
            if (symbol.getColor().equals(color)) {
                return false;
            }
        }
    
        Symbol newSymbol = new Symbol(color);
        
       
        int symbolX = this.xPos + 30;
        int symbolY = this.yPos + 55;
        newSymbol.setPosition(symbolX, symbolY);
        
        this.symbols.add(newSymbol);
    
        if (symbols.size() - 1 != currentSymbol) {
            newSymbol.makeInvisible();
        } 
        else if (isVisible) {
            newSymbol.makeVisible();
        }
        return true;
    }
    
    /**
     * Sets a specific symbol as the currently visible one on the wheel.
     * 
     * @param color The color of the symbol to be displayed.
     * @return true if the symbol was found and set as current, false otherwise.
     */
    public boolean setSymbolAsCurrent(String color) {
        for (int i = 0; i < symbols.size(); i++) {
            if (symbols.get(i).getColor().equals(color)) {
                if (isVisible && !symbols.isEmpty()) {
                    symbols.get(currentSymbol).makeInvisible();
                }
                currentSymbol = i;
                if (isVisible) {
                    symbols.get(currentSymbol).makeVisible();
                }
                return true;
            }
        }
        return false;
    }
    
    /**
     * Makes the wheel and its currently active symbol visible on the canvas.
     */
    public void makeVisible() {
        this.isVisible = true;
        this.wheelShape.makeVisible();
        if (!symbols.isEmpty()) {
            symbols.get(currentSymbol).makeVisible();
        }
    }
    
    /**
     * Makes the wheel and its currently active symbol invisible on the canvas.
     */
    public void makeInvisible() {
        this.isVisible = false;
        this.wheelShape.makeInvisible();   
        if (!symbols.isEmpty()) {
            symbols.get(currentSymbol).makeInvisible();
        }
    }
 
    /**
     * Deletes the symbol that matches the specified color from the wheel.
     * 
     * @param color The color of the symbol to be deleted.
     * @return true if the symbol was successfully deleted, false if the symbol was not found.
     */
    public boolean delSymbol(String color) {
    
        for (int i = 0; i < symbols.size(); i++) {
    
            Symbol symbol = symbols.get(i);
            String symbolColor = symbol.getColor();
    
            if (symbolColor.equals(color)) {
    
                symbol.makeInvisible();
                symbols.remove(i);
    
                if (currentSymbol >= symbols.size() && !symbols.isEmpty()) {
                    currentSymbol = 0;
                }
    
                return true;
            }
        }
        return false;
    }

    /**
     * Spins the wheel forward by exactly one position.
     */
    public void spin() {
        spin(1);
    }

    /**
     * Spins the wheel by a specified number of positions.
     * Supports negative numbers to spin backwards.
     * 
     * @param times The number of positions to spin the wheel.
     */
    public void spin(int times) {
        if (symbols.isEmpty()) {
            return;
        }

        if (isVisible) {
            symbols.get(currentSymbol).makeInvisible();
        }
        if (times > 0) {
            for (int i = 0; i < times; i++) {
                currentSymbol = currentSymbol + 1;
               
                if (currentSymbol >= symbols.size()) {
                    currentSymbol = 0;
                }
            }
        } else if (times < 0) {
            int positiveTimes = times * -1; 
            for (int i = 0; i < positiveTimes; i++) {
                currentSymbol = currentSymbol - 1;
                if (currentSymbol < 0) {
                    currentSymbol = symbols.size() - 1;
                }
            }
        }

        if (isVisible) {
            symbols.get(currentSymbol).makeVisible();
        }
    }

    /**
     * Retrieves the color of the symbol that is currently visible on the wheel.
     * 
     * @return A String representing the color of the visible symbol, or an empty string if the wheel has no symbols.
     */
    public String getVisibleSymbol() {
        if (symbols.isEmpty()) {
            return "";
        }
        return symbols.get(currentSymbol).getColor();
    }

    /**
     * Retrieves an array containing the colors of all symbols present in the wheel.
     * 
     * @return An array of Strings containing the colors of all symbols.
     */
    public String[] getSymbols() {
        String[] colors = new String[symbols.size()];
        for (int i = 0; i < symbols.size(); i++) {
            colors[i] = symbols.get(i).getColor();
        }
        return colors;
    }
}