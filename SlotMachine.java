
/**
 * Write a description of class SlotMachine here.
 * 
 * @author David Páez y Joseph
 * @version 21 de agosto de 2026
 */
import java.util.*;
import javax.swing.JOptionPane;

public class SlotMachine {
    private int xPos;
    private int yPos;
    private boolean isVisible;
    private boolean lastOperation;
    private ArrayList<Wheel> wheels;
    private Rectangle base;
    private Rectangle background;
    private Rectangle lever;
    
    /**
     * Constructor for objects of class SlotMachine
     */
    public SlotMachine() {
        this.xPos = 0;
        this.yPos = 0;
        this.isVisible = false;
        this.lastOperation = true;
        this.wheels = new ArrayList<Wheel>();
        
        this.background = new Rectangle();
        this.base = new Rectangle();
        this.lever = new Rectangle();
    }
    
    public void addWheel(int pos) {
        int i = pos - 1;
        
        if (i < 0) {
            i = 0;    
        }
        if (i > wheels.size()) {
            i = wheels.size();   
        }
        Wheel newWheel = new Wheel(i + 1);
        this.wheels.add(i, newWheel);

        if (this.isVisible) {
            newWheel.makeVisible();
        }
        
        this.lastOperation = true;
    }
    
    public void delWheel(int pos) {
        int i = pos - 1;

        if (i < 0) {
            i = 0;    
        }
        if (i > wheels.size()) {
            i = wheels.size();   
        }
        
        if (i >= 0 && i < wheels.size()) {
            Wheel deleWheel = this.wheels.get(i);
            deleWheel.makeInvisible();
            this.wheels.remove(i);
            this.lastOperation = true;
        } 
        else {
            this.lastOperation = false;
        }
    }
    
    
    public void addSymbol(int pos, String color) {
        int i = pos - 1;
    
        if (i >= 0 && i < wheels.size()) {
            Wheel selectedWheel = this.wheels.get(i);
            this.lastOperation = selectedWheel.addSymbol(color); 
        } 
        else {
            this.lastOperation = false;
        }
    }
    
    public void delSymbol(String symbol) {
        int count = 0;
        
        for (int i = 0; i < wheels.size(); i++) {
            Wheel currentWheel = wheels.get(i);
            if (currentWheel.delSymbol(symbol)) {
                count++;
            }
        }
        
        this.lastOperation = (count > 0);
    }
    
    public void placeSymbol(int wheel, String symbol) {
        
    }
    
    public void spin(int wheel) {
        int i = wheel - 1;
        
        if (i >= 0 && i < wheels.size()) {
            Wheel wheelSpin = this.wheels.get(i);
            wheelSpin.spin();  
        this.lastOperation = true;
        } 
        else {
            this.lastOperation = false;
        }
    }
    
    public void spin() {
        if (wheels.isEmpty()) {
            this.lastOperation = false;
            return;
        }

        for (int i = 0; i < wheels.size(); i++) {
            Wheel currentWheel = wheels.get(i);
            currentWheel.spin();
        }

        this.lastOperation = true;
    }
    
    public String[] symbols() {
        ArrayList<String> uniqueColors = new ArrayList<String>();
        
        for (int i = 0; i < wheels.size(); i++) {
            String[] wheelColors = wheels.get(i).getSymbols();
            for (int j = 0; j < wheelColors.length; j++) {
                String color = wheelColors[j];
                if (!uniqueColors.contains(color)) {
                    uniqueColors.add(color);
                }
            }
        }
        
        this.lastOperation = true;
        return uniqueColors.toArray(new String[0]);
    }
    
    public int distinctSymbols() {
        String[] uniqueSymbols = symbols();
        this.lastOperation = true;
        return uniqueSymbols.length;
    }
    
    public String[] configuration() {
        String[] visibleSymbols = new String[wheels.size()];
    
        for (int i = 0; i < wheels.size(); i++) {
            visibleSymbols[i] = wheels.get(i).getVisibleSymbol();
        }
    
        this.lastOperation = true;
        return visibleSymbols;      
    }
    
    public boolean isJackpot() {
        if (wheels.isEmpty()) {
            this.lastOperation = false;
            return false;
        }
    
        String firstSymbol = wheels.get(0).getVisibleSymbol();
    
        if (firstSymbol == null || firstSymbol.equals("")) {
            this.lastOperation = false;
            return false;
        }
    
        for (int i = 1; i < wheels.size(); i++) {
            String currentSymbol = wheels.get(i).getVisibleSymbol();
            if (!firstSymbol.equals(currentSymbol)) {
                this.lastOperation = true;
                return false;
            }
        }
    
        this.lastOperation = true;
        return true;
    }
    
    public void makeVisible() {
        this.isVisible = true;
        this.background.makeVisible();
        this.base.makeVisible();
        this.lever.makeVisible();
        
        for (int i = 0; i < wheels.size(); i++) {
            wheels.get(i).makeVisible();
        }
        this.lastOperation = true;
    }
    
    public void makeInvisible() {
        this.isVisible = false;
        this.background.makeInvisible();
        this.base.makeInvisible();
        this.lever.makeInvisible();
        
        for (int i = 0; i < wheels.size(); i++) {
            wheels.get(i).makeInvisible();
        }
        this.lastOperation = true;
    }
    
    public void exit() {
        makeInvisible();
        JOptionPane.showMessageDialog(null, "Juego finalizado.", "Salir", JOptionPane.INFORMATION_MESSAGE);
        this.lastOperation = true;
    }
    
    public boolean ok() {
        return this.lastOperation;
    }
}
