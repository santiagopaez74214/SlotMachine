/**
 * Represents the main slot machine simulator.
 * Manages the visual interface, the wheels, the spinning mechanics, and verifies the jackpot state.
 * 
 * @author David Páez and Joseph Cañon
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
     * Constructor for objects of class SlotMachine.
     * Initializes the machine's body, base, and lever with default sizes and colors.
     */
    public SlotMachine() {
        this.xPos = 0;
        this.yPos = 0;
        this.isVisible = false;
        this.lastOperation = true;
        this.wheels = new ArrayList<Wheel>();
        
        this.background = new Rectangle(250, 400, "blue", 30, 35);
        this.base = new Rectangle(30, 300, "black", 80, 285);
        this.lever = new Rectangle(120, 10, "black", 430, 85);
    }
    
    /**
     * Automatically recalculates the positions of all wheels to center them.
     * Dynamically adjusts the width of the machine's background and base to fit all wheels.
     */
    private void updateWheelsPositions() {
        int wheelWidth = 60;
        int spacing = 15; 
        int numWheels = wheels.size();
        if (numWheels == 0) {
            numWheels = 1;
        }
        int totalWheelsWidth = (numWheels * wheelWidth) + ((numWheels - 1) * spacing);
        int newBackgroundWidth = totalWheelsWidth + 40; 
        if (newBackgroundWidth < 250) {
            newBackgroundWidth = 250;
        }
        this.background.changeSize(220, newBackgroundWidth);
        this.base.changeSize(30, newBackgroundWidth - 60);
        int machineStartX = 100;
        int machineStartY = 50;
        this.background.changePosition(machineStartX, machineStartY);
        this.base.changePosition(machineStartX + 30, machineStartY + 220); 
        this.lever.changePosition(machineStartX + newBackgroundWidth, machineStartY + 85);
        int currentX = machineStartX + (newBackgroundWidth - totalWheelsWidth) / 2; 
        int wheelY = machineStartY + 40; 
        
        for (int i = 0; i < wheels.size(); i++) {
            wheels.get(i).setPosition(currentX, wheelY);
            currentX = currentX + wheelWidth + spacing; 
        }
    }
    
    /**
     * Adds a new wheel to the machine at the specified position.
     * 
     * @param pos The position number where the wheel will be added (1-based index).
     */
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
        
        updateWheelsPositions();

        if (this.isVisible) {
            makeInvisible(); 
            makeVisible();   
        }
        
        this.lastOperation = true;
    }
    
    /**
     * Deletes a wheel from the machine at the specified position.
     * 
     * @param pos The position number of the wheel to be deleted (1-based index).
     */
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
            
            updateWheelsPositions();
            if (this.isVisible) {
                makeInvisible(); 
                makeVisible();   
            }
            this.lastOperation = true;
        } 
        else {
            this.lastOperation = false;
        }
    }
    
    /**
     * Adds a symbol with the given color to a specific wheel.
     * 
     * @param pos The position number of the wheel (1-based index).
     * @param color The color of the symbol to add.
     */
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
    
       
    /**
     * Deletes a specific symbol from all wheels based on its color.
     * 
     * @param symbol The color of the symbol to delete.
     */
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

    /**
     * Automated Helper Method: Adds the same symbol to ALL current wheels.
     * Ideal for quickly setting up the machine before spinning.
     * 
     * @param color The color of the symbol to add to all wheels.
     */
    public void addSymbolToAll(String color) {
        if (wheels.isEmpty()) {
            this.lastOperation = false;
            return;
        }
        
        int count = 0;
        for (int i = 0; i < wheels.size(); i++) {
            if (wheels.get(i).addSymbol(color)) {
                count++;
            }
        }
        
        
        this.lastOperation = (count > 0);
    }
    
    /**
     * Sets a specific symbol as the currently visible one on a given wheel.
     * 
     * @param wheel The position number of the wheel (1-based index).
     * @param symbol The color of the symbol to display.
     */
    public void placeSymbol(int wheel, String symbol) {
        int i = wheel - 1;
        
        if (i >= 0 && i < wheels.size()) {
            this.lastOperation = this.wheels.get(i).setSymbolAsCurrent(symbol);
        } else {
            this.lastOperation = false;
        }
    }
    
    /**
     * Spins a specific wheel a random number of times for a realistic animation.
     * 
     * @param wheel The position number of the wheel to spin (1-based index).
     */
    public void spin(int wheel) {
        int i = wheel - 1;
        
        if (i >= 0 && i < wheels.size()) {
            Wheel wheelSpin = this.wheels.get(i);
            
            Random rand = new Random();
            int randomSpins = rand.nextInt(20) + 10; 
            for (int t = 0; t < randomSpins; t++) {
                wheelSpin.spin(1);
            }
            
            checkWinState(); 
            this.lastOperation = true;
        } 
        else {
            this.lastOperation = false;
            if (this.isVisible) {
                JOptionPane.showMessageDialog(null, "La rueda indicada no existe.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    /**
     * Spins all wheels a random number of times. 
     * Each wheel stops at a different time to simulate a real slot machine.
     */
    public void spin() {
        if (wheels.isEmpty()) {
            this.lastOperation = false;
            if (this.isVisible) {
                JOptionPane.showMessageDialog(null, "No hay ruedas para girar.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            return;
        }
        Random rand = new Random();
        int[] targets = new int[wheels.size()];
        int maxSpins = 0;
        for (int i = 0; i < wheels.size(); i++) {
            targets[i] = rand.nextInt(20) + 10;
            if (targets[i] > maxSpins) {
                maxSpins = targets[i];
            }
        }
        for (int t = 0; t < maxSpins; t++) {
            for (int i = 0; i < wheels.size(); i++) {
                if (t < targets[i]) {
                    wheels.get(i).spin(1);
                }
            }
        }
        checkWinState(); 
        this.lastOperation = true;
    }
    
    /**
     * Retrieves all unique symbols (colors) currently present in any of the machine's wheels.
     * 
     * @return An array of Strings containing the unique colors.
     */
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
        
        
        String[] result = new String[uniqueColors.size()];
        for (int i = 0; i < uniqueColors.size(); i++) {
            result[i] = uniqueColors.get(i);
        }
        
        this.lastOperation = true;
        return result;
    }
    
    /**
     * Gets the total number of distinct symbols across all wheels.
     * 
     * @return The number of distinct symbols.
     */
    public int distinctSymbols() {
        String[] uniqueSymbols = symbols();
        this.lastOperation = true;
        return uniqueSymbols.length;
    }
    
    /**
     * Checks if the machine has hit a jackpot (all wheels show the exact same symbol).
     * 
     * @return true if it's a jackpot, false otherwise.
     */
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
    
    /**
     * Verifies the state of the machine and changes its background color to yellow if it's a jackpot.
     */
    private void checkWinState() {
        if (isJackpot() && !wheels.isEmpty()) {
            this.background.changeColor("yellow"); 
        } else {
            this.background.changeColor("blue");   
        }
        
        
        if (this.isVisible) {
            this.base.makeVisible();
            this.lever.makeVisible();
            for (int i = 0; i < wheels.size(); i++) {
                wheels.get(i).makeVisible();
            }
        }
    }
    
    /**
     * Retrieves the colors of the symbols currently visible on all wheels, from left to right.
     * 
     * @return An array of Strings representing the visible configuration.
     */
    public String[] configuration() {
        String[] visibleSymbols = new String[wheels.size()];
    
        for (int i = 0; i < wheels.size(); i++) {
            visibleSymbols[i] = wheels.get(i).getVisibleSymbol();
        }
    
        this.lastOperation = true;
        return visibleSymbols;      
    }
    
    /**
     * Makes the entire slot machine simulator visible on the canvas.
     */
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
    
    /**
     * Hides the entire slot machine simulator from the canvas.
     */
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
    
    /**
     * Exits the simulator, hides it, and displays a goodbye message.
     */
    public void exit() {
        makeInvisible();
        JOptionPane.showMessageDialog(null, "Juego finalizado.", "Salir", JOptionPane.INFORMATION_MESSAGE);
        this.lastOperation = true;
    }
    
    /**
     * Checks if the last requested operation was successfully completed.
     * 
     * @return true if successful, false otherwise.
     */
    public boolean ok() {
        return this.lastOperation;
    }
    
    
    /**
     * Swaps the positions of two wheels in the machine.
     * 
     * @param wheel1 Position of the first wheel.
     * @param wheel2 Position of the second wheel.
     */
    public void swap(int wheel1, int wheel2) {
        int idx1 = wheel1 - 1;
        int idx2 = wheel2 - 1;
    
        if (idx1 >= 0 && idx1 < wheels.size() && idx2 >= 0 && idx2 < wheels.size()) {
            Wheel w1 = wheels.get(idx1);
            Wheel w2 = wheels.get(idx2);
    
            if (w1.isLocked() || w2.isLocked()) {
                this.lastOperation = false;
                return;
            }
    
            wheels.set(idx1, w2);
            wheels.set(idx2, w1);
    
            updateWheelsPositions();
            if (this.isVisible) {
                makeInvisible();
                makeVisible();
            }
            this.lastOperation = true;
        } else {
            this.lastOperation = false;
        }
    }
    
    /**
     * Locks a specific wheel so it cannot be spun (Requirement 10).
     * 
     * @param wheel Position of the wheel to lock (1-based index).
     */
    public void lock(int wheel) {
        int index = wheel - 1;
        
        if (index >= 0 && index < wheels.size()) {
            Wheel wheeltolock = wheels.get(index);
            wheeltolock.lock();
            this.lastOperation = true;
        } else {
            this.lastOperation = false;
        }
    }
    
    /**
     * Unlocks a specific wheel so it can be spun again (Requirement 10).
     * 
     * @param wheel Position of the wheel to unlock (1-based index).
     */
    public void unlock(int wheel) {
        int index = wheel - 1;
      
        if (index >= 0 && index < wheels.size()) {
            Wheel wheeltounlock = wheels.get(index);
            wheeltounlock.unlock();
            this.lastOperation = true;
        } else {
            this.lastOperation = false;
        }
    }
    
    
    /**
     * Rotates a specific wheel by a given number of steps.
     * 
     * @param wheel Position of the wheel (1-based index).
     * @param steps Number of steps to rotate (positive or negative).
     */
    public void spin(int wheel, int steps) {
        int index = wheel - 1;
        if (index >= 0 && index < wheels.size()) {
            Wheel targetWheel = wheels.get(index);
            
            if (!targetWheel.isLocked()) {
                if (this.isVisible) {
                    int direction = 1;
                    if (steps < 0) {
                        direction = -1;
                    }
                    int totalSteps = Math.abs(steps);
                    
                    for (int i = 0; i < totalSteps; i++) {
                        targetWheel.spin(direction);
                    }
                } else {
                    targetWheel.spin(steps);
                }
                
                checkWinState();
                this.lastOperation = true;
            } else {
                this.lastOperation = false;
            }
        } else {
            this.lastOperation = false; 
        }
    }
    
    /**
     * Sets the machine to a specific configuration given an array of symbols (Requirement 12).
     * 
     * @param setSymbols Array of colors representing the desired configuration from left to right.
     */
    public void spin(String[] setSymbols) {
        if (setSymbols != null && setSymbols.length == wheels.size()) {
            boolean check = true;
            
            for (int i = 0; i < wheels.size(); i++) {
                Wheel currentWheel = wheels.get(i);
                String setColor = setSymbols[i];
                
                boolean changed = currentWheel.setSymbolAsCurrent(setColor);
                if (!changed) {
                    check = false;
                }
            }
            
            checkWinState();
            this.lastOperation = check;
        } 
        else {
            this.lastOperation = false;
        }
    }
}