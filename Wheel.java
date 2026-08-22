
/**
 * Write a description of class Wheel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;

public class Wheel {
    // instance variables - replace the example below with your own
    private int pos;
    public ArrayList<Symbol> symbols;
    private boolean isVisible;
    private int xPos;
    private int yPos;
    private Rectangle wheelShape;
    private int currentSymbol;

    /**
     * Constructor for objects of class Wheel
     */
    public Wheel() {

        this.pos = 0;
        this.symbols = new ArrayList<Symbol>();
        this.isVisible = true;
        this.xPos = 0;
        this.yPos = 0;
        this.currentSymbol = 0;
        
        this.wheelShape = new Rectangle();
    }
    
    public Wheel(int pos) {
        this.pos = pos;
        this.symbols = new ArrayList<Symbol>();
        this.isVisible = true;
        this.xPos = 0;
        this.yPos = 0;
        this.currentSymbol = 0;
        
        this.wheelShape = new Rectangle();
    }
    
    public void makeVisible() {
        this.isVisible = true;
        this.wheelShape.makeVisible();
    }
    
    public void makeInvisible() {
        this.isVisible = false;
        this.wheelShape.makeInvisible();   
    }
    
    public boolean addSymbol(String color) {
        for (int i = 0; i < symbols.size(); i++) {
    
            Symbol symbol = symbols.get(i);
    
            if (symbol.getColor().equals(color)) {
                return false;
            }
        }
    
        Symbol newSymbol = new Symbol(color);
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
     * Elimina el símbolo de la rueda que coincida con el color especificado.
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
     * Gira la rueda una posición.
     */
    public void spin() {
        spin(1);
    }

    /**
     * Gira la rueda N posiciones.
     */
    public void spin(int times) {
        if (symbols.isEmpty()) {
            return;
        }

        if (isVisible) {
            symbols.get(currentSymbol).makeInvisible();
        }

        currentSymbol = (currentSymbol + times) % symbols.size();

        if (isVisible) {
            symbols.get(currentSymbol).makeVisible();
        }
    }

    /**
     * Retorna el color del símbolo que está visible en la posición actual.
     */
    public String getVisibleSymbol() {
        if (symbols.isEmpty()) {
            return "";
        }
        return symbols.get(currentSymbol).getColor();
    }

    /**
     * Retorna un arreglo con todos los colores presentes en la rueda.
     */
    public String[] getSymbols() {
        String[] colors = new String[symbols.size()];
        for (int i = 0; i < symbols.size(); i++) {
            colors[i] = symbols.get(i).getColor();
        }
        return colors;
    }
}
