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
        this.wheels = new ArrayList<Wheel>();
        
        this.background = new Rectangle(250, 400, "blue", 30, 35);
        this.base = new Rectangle(30, 300, "black", 80, 285);
        this.lever = new Rectangle(120, 10, "black", 430, 85);
        this.lastOperation = true;
    }
    
    /**
     * Constructor for objects of class SlotMachine with n wheels.
     * Initializes the machine's body, base, and lever with default sizes and colors.
     */

    public SlotMachine(int n) {
        if (n < 3) {
            n = 3;
        }
        if (n > 50) {
            n = 50;
        }
        xPos = 0;
        yPos = 0;
        isVisible = false;
        lastOperation = true; 
        wheels = new ArrayList<Wheel>();
        background = new Rectangle(250, 400, "blue", 30, 35);
        base = new Rectangle(30, 300, "black", 80, 285);
        lever = new Rectangle(120, 10, "black", 430, 85);

        String[] colores = {
            "red", "blue", "yellow", "green", "magenta", "black", "white",
            "lightgray", "gray", "darkgray", "pink", "orange", "cyan",
            "brown", "purple", "violet", "indigo", "navy", "skyblue", "lightblue",
            "royalblue", "turquoise", "teal", "aquamarine", "limegreen", "darkgreen",
            "forestgreen", "olive", "lightgreen", "seagreen", "gold", "khaki", "beige",
            "ivory", "tan", "chocolate", "sienna", "maroon", "crimson", "darkred",
            "salmon", "coral", "tomato", "orangered", "darkorange", "peach", "hotpink",
            "deeppink", "lavender", "plum"
        };  

        for (int i = 1; i <= n; i++) {
            addWheel("normal", i); 
            
            for (int j = 0; j < n; j++) {
                addSymbol("normal", i, colores[j]); 
            }

        }
        
        Random rand = new Random();
        boolean estadoInvalido = true;

        while (estadoInvalido == true) {
            
            for (int i = 1; i <= n; i++) {
                spin(i, rand.nextInt(n)); 
            }
            
            if (distinctSymbols() > 1) {
                estadoInvalido = false; 
            }
        }
        
        makeInvisible();
        lastOperation = true;
    }

    /**
     * Updates the wheels that depend on the wheel located to their left.
     * This is mainly used for LeftyWheel.
     */
    private void updateLeftyWheels() {
        for (int i = 0; i < wheels.size(); i++) {
            Wheel currentWheel = wheels.get(i);
            if (currentWheel instanceof LeftyWheel) {
                LeftyWheel leftyWheel = (LeftyWheel) currentWheel;
                if (i > 0) {
                    leftyWheel.setLeftWheel(wheels.get(i - 1));
                } 
                else {
                    leftyWheel.setLeftWheel(null);
                }
            }
        }
    }
    /**
     * Returns the wheel located at the given position.
     *
     * @param pos The position of the wheel (1-based index).
     * @return The wheel located at that position.
     * @throws SlotMachineException if the wheel does not exist.
     */
    private Wheel getWheel(int pos) throws SlotMachineException {
        if (pos < 1 || pos > wheels.size()) {
            throw new SlotMachineException(SlotMachineException.WHEEL_NOT_FOUND);
        }
        return wheels.get(pos - 1);
    }
    
    
        /**
     * Registers a failed operation and, if the simulator is visible,
     * shows the error message to the user.
     *
     * @param message The message describing the error.
     */
    private void showError(String message) {
        lastOperation = false;
        if (isVisible) {
            JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
        }
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
     * Adds a normal wheel.
     *
     * This method is kept for compatibility with previous versions.
     *
     * @param pos position where the wheel will be added.
     */
    public void addWheel(int pos) {
        addWheel("normal", pos);
    }

    /**
     * Adds a wheel of the specified type, "normal", "lefty", "rebel"
     * @param pos position where the wheel will be added.
     * @param type type of wheel.
     */
    public void addWheel(String type, int pos) {
        try {
            if (type == null || type.equals("")) {
                throw new SlotMachineException(SlotMachineException.WHEEL_TYPE_INVALID);
            }

            int index = pos - 1;

            if (index < 0) {
                index = 0;
            }

            if (index > wheels.size()) {
                index = wheels.size();
            }

            if (index < wheels.size()) {
                showError("La posición indicada es inválida o excede las posiciones existentes.");
                return;
            }

            Wheel newWheel;

            try {
                String formattedType = type.substring(0, 1).toUpperCase()
                                     + type.substring(1).toLowerCase();

                Class<?> clazz = Class.forName(formattedType + "Wheel");

                java.lang.reflect.Constructor<?> constructor =
                    clazz.getConstructor(int.class);

                newWheel = (Wheel) constructor.newInstance(pos);
            } catch (ReflectiveOperationException | ClassCastException e) {
                throw new SlotMachineException(SlotMachineException.WHEEL_TYPE_INVALID);
            }

            wheels.add(index, newWheel);

            updateWheelsPositions();
            updateLeftyWheels();

            if (isVisible) {
                makeInvisible();
                makeVisible();
            }

            lastOperation = true;
        } catch (SlotMachineException e) {
            showError(e.getMessage());
        }
    }

    
    /**
     * Deletes a wheel from the machine at the specified position.
     * 
     * @param pos The position number of the wheel to be deleted (1-based index).
     */
    public void delWheel(int pos) {
        try {
            if (pos < 1) {
                pos = 1;
            }

            Wheel deleWheel = getWheel(pos);

            if (deleWheel instanceof RebelWheel) {
                throw new SlotMachineException(SlotMachineException.REBEL_WHEEL_CANNOT_BE_DELETED);
            }

            deleWheel.makeInvisible();
            this.wheels.remove(pos - 1);

            updateWheelsPositions();
            updateLeftyWheels();
            if (this.isVisible) {
                makeInvisible();
                makeVisible();
            }
            this.lastOperation = true;
        } catch (SlotMachineException e) {
            showError(e.getMessage());
        }
    }
    
    /**
     * Adds a normal symbol.
     *
     * Kept for compatibility with previous versions.
     *
     * @param pos position of the wheel.
     * @param color color of the symbol.
     */
    public void addSymbol(int pos, String color) {
        addSymbol("normal", pos, color);
    }

    /**
     * Adds a symbol of the specified type to a wheel,"normal","ephemeral","shy"
     * @param pos position of the wheel.
     * @param color color of the symbol.
     * @param type type of symbol.
     */
    
    public void addSymbol(String type, int pos, String color) {
        try {
            Wheel targetWheel = getWheel(pos);

            if (type == null || type.equals("")) {
                throw new SlotMachineException(SlotMachineException.SYMBOL_TYPE_INVALID);
            }

            Symbol newSymbol;

            try {
                String formattedType = type.substring(0, 1).toUpperCase()
                                     + type.substring(1).toLowerCase();

                Class<?> clazz = Class.forName(formattedType + "Symbol");

                java.lang.reflect.Constructor<?> constructor =
                    clazz.getConstructor(String.class);

                newSymbol = (Symbol) constructor.newInstance(color);
            } catch (ReflectiveOperationException | ClassCastException e) {
                throw new SlotMachineException(SlotMachineException.SYMBOL_TYPE_INVALID);
            }

            if (!targetWheel.addSymbol(newSymbol)) {
                throw new SlotMachineException(SlotMachineException.SYMBOL_ALREADY_EXISTS);
            }

            updateWheelsPositions();

            if (isVisible) {
                makeInvisible();
                makeVisible();
            }

            lastOperation = true;
        } catch (SlotMachineException e) {
            showError(e.getMessage());
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
    private void addSymbolToAll(String color) {
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
     * @param wheel The position number of the wheel (1-based index).
     * @param symbol The color of the symbol to display.
     */
    public void placeSymbol(int wheel, String symbol) {
        try {
            Wheel targetWheel = getWheel(wheel);

            if (!targetWheel.setSymbolAsCurrent(symbol)) {
                throw new SlotMachineException(SlotMachineException.SYMBOL_NOT_FOUND);
            }

            this.lastOperation = true;
        } catch (SlotMachineException e) {
            showError(e.getMessage());
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
        try {
            if (wheels.isEmpty()) {
                throw new SlotMachineException(SlotMachineException.WHEELS_NOT_FOUND);
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
        } catch (SlotMachineException e) {
            showError(e.getMessage());
        }
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
        
        this.lastOperation = true;
        return uniqueColors.toArray(new String[0]);
    }
    
    /**
     * Gets the total number of distinct symbols across all wheels.
     * 
     * @return The number of distinct symbols.
     */
    public int distinctSymbols() {
        String[] configuracionVisible = configuration(); 
        ArrayList<String> unicos = new ArrayList<>();
        for (int i = 0; i < configuracionVisible.length; i++) {
            String colorActual = configuracionVisible[i];
            if (colorActual != null && !unicos.contains(colorActual) && !colorActual.equals("")) {
                unicos.add(colorActual);
            }
        }
        this.lastOperation = true;
        return unicos.size();
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
        System.exit(0);
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
        try {
            Wheel w1 = getWheel(wheel1);
            Wheel w2 = getWheel(wheel2);

            if (w1 instanceof RebelWheel || w2 instanceof RebelWheel) {
                throw new SlotMachineException(SlotMachineException.REBEL_WHEEL_CANNOT_BE_SWAPPED);
            }

            if (w1.isLocked() || w2.isLocked()) {
                throw new SlotMachineException(SlotMachineException.WHEEL_LOCKED);
            }

            wheels.set(wheel1 - 1, w2);
            wheels.set(wheel2 - 1, w1);

            updateWheelsPositions();
            updateLeftyWheels();
            if (this.isVisible) {
                makeInvisible();
                makeVisible();
            }
            this.lastOperation = true;
        } catch (SlotMachineException e) {
            showError(e.getMessage());
        }
    }
    
    /**
     * Locks a specific wheel so it cannot be spun (Requirement 10).
     * 
     * @param wheel Position of the wheel to lock (1-based index).
     */
        public void lock(int wheel) {
        try {
            Wheel targetWheel = getWheel(wheel);

            if (targetWheel instanceof RebelWheel) {
                throw new SlotMachineException(SlotMachineException.REBEL_WHEEL_CANNOT_BE_LOCKED);
            }

            targetWheel.lock();
            lastOperation = true;
        } catch (SlotMachineException e) {
            showError(e.getMessage());
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
        try {
            Wheel targetWheel = getWheel(wheel);

            if (targetWheel.isLocked()) {
                throw new SlotMachineException(SlotMachineException.WHEEL_LOCKED);
            }

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
        } catch (SlotMachineException e) {
            showError(e.getMessage());
        }
    }
    
    /**
     * Sets the machine to a specific configuration given an array of symbols (Requirement 12).
     * 
     * @param setSymbols Array of colors representing the desired configuration from left to right.
     */
    public void spin(String[] setSymbols) {
        try {
            if (setSymbols == null || setSymbols.length != wheels.size()) {
                throw new SlotMachineException(SlotMachineException.CONFIGURATION_SIZE_MISMATCH);
            }

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
        } catch (SlotMachineException e) {
            showError(e.getMessage());
        }
    }
}