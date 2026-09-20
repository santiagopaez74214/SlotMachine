import java.util.*;
import javax.swing.JOptionPane;

/**
 * Write a description of class SlotMachineContest here.
 * 
 * @author David Páez y Joseph Cañon 
 * @version 18/09/2026
 */
public class SlotMachineContest {
 
    /** 
    * Creates a slot machine and finds the moves needed to solve it.
    * @param n number of wheels and symbols  
    * @return the list of moves used to solve the slot machine 
    */
    public int[][] solve(int n) {
        if (n < 3 || n > 50){
            JOptionPane.showMessageDialog(null, "El número n debe estar entre 3 y 50", "Error", JOptionPane.ERROR_MESSAGE);
            return new int[0][0];
        }
        SlotMachine slotMachine = new SlotMachine(n);
        return solve(slotMachine, n);

    }
 
    /** 
    * Creates a visible slot machine and runs the solution on it.
    * @param n number of wheels and symbols 
    */
    public void simulate(int n) {
        if (n < 3 || n > 50){
            JOptionPane.showMessageDialog(null, "El número n debe estar entre 3 y 50", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        SlotMachine slotMachine = new SlotMachine(n);
        slotMachine.makeVisible();
        solve(slotMachine, n);

    }
 
    /** 
    * Finds the moves needed to solve the slot machine.
    * @param slotMachine slot machine to solve 
    * @param n number of wheels and symbols 
    * @return the list of moves used to solve the slot machine 
    */
    private int[][] solve(SlotMachine slotMachine, int n) { 
     
        ArrayList<int[]> moves = new ArrayList<>(); 
      
        if (slotMachine.distinctSymbols() < n){ 
            moves.addAll(increaseDistinctSymbols(slotMachine, n)); 
        } 
         
        int[] ganadores = new int[n + 1]; 
      
        for (int rueda = 2; rueda <= n && slotMachine.distinctSymbols() > 1; rueda++) { 
            int giros = 0; 
            while (true) { 
                slotMachine.spin(rueda, 1); 
                moves.add(new int[]{rueda, 1}); 
                giros++; 
                
                if (slotMachine.distinctSymbols() == n - 1) { 
                    boolean rueda1 = false; 
                    
                    for (int i = 0; i < n; i++) { 
                        slotMachine.spin(1, 1); 
                        moves.add(new int[]{1, 1}); 
                        
                        if (slotMachine.distinctSymbols() == n){ 
                            rueda1 = true; 
                        } 
                    } 
      
                    if (rueda1) { 
                        ganadores[rueda] = giros; 
                        slotMachine.spin(rueda, -giros); 
                        moves.add(new int[]{rueda, -giros}); 
                        break; 
                    } 
                } 
            } 
        } 
         
        for (int rueda = 2; rueda <= n; rueda++) { 
            slotMachine.spin(rueda, ganadores[rueda]); 
            moves.add(new int[]{rueda, ganadores[rueda]}); 
        } 
        
        return moves.toArray(new int[moves.size()][2]); 
    } 
    
    /**  
     * Changes the wheels until there are enough different symbols to continue the solution. 
     * @param slotMachine slot machine to change  
     * @param n number of wheels and symbols  
     * @return the moves used to increase the number of distinct symbols   
     */ 
    private ArrayList<int[]> increaseDistinctSymbols(SlotMachine slotMachine, int n) { 
        ArrayList<int[]> moves = new ArrayList<>(); 
        
        while (slotMachine.distinctSymbols() < n) { 
            for (int rueda = 1; rueda <= n && slotMachine.distinctSymbols() < n; rueda++) { 
                int inicial = slotMachine.distinctSymbols(); 
                
                for (int i = 0; i < n; i++) { 
                    slotMachine.spin(rueda, 1); 
                    moves.add(new int[]{rueda, 1}); 
                    
                    if (slotMachine.distinctSymbols() > inicial) {
                        break; 
                    }
                } 
            } 
        } 
        
        return moves; 
    }
}
 