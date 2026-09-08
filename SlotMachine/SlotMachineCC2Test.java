

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class SlotMachineCC2Test.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SlotMachineCC2Test
{
    private SlotMachine slotMachine;
    /**
     * Default constructor for test class SlotMachineCC2Test
     */
    public SlotMachineCC2Test()
    {
        slotMachine = new SlotMachine();
        slotMachine.makeInvisible();
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }
    
    //Grupo: MoralesS-RojasH
    /**
     * Verifica que, al intercambiar dos ruedas válidas con símbolos
     * distintos mediante swap(int, int), cada una termine mostrando el
     * símbolo que antes tenía la otra.
     */
    @Test
    public void accordingMsRhShouldSwapSymbolsBetweenTwoValidWheels() {
        slotMachine.addSymbol(1, "red");
        slotMachine.addSymbol(2, "blue");
        slotMachine.addWheel(1);
        slotMachine.addWheel(2);
        slotMachine.placeSymbol(1, "red");
        slotMachine.placeSymbol(2, "blue");
        slotMachine.swap(1, 2);
        assertEquals("blue", slotMachine.configuration()[0]);
        assertEquals("red", slotMachine.configuration()[1]);
    }
    /**
     * Verifica que una rueda bloqueada con lock(int) no cambie su
     * símbolo visible al intentar girarla con spin(int).
     */
    @Test
    public void accordingMsRhShouldNotChangeLockedWheelWhenSpinning() {
        slotMachine.addSymbol(1, "red");
        slotMachine.addSymbol(2, "blue");
        slotMachine.addWheel(1);
        slotMachine.placeSymbol(1, "red");
        slotMachine.lock(1);
        slotMachine.spin(1);
        assertEquals("red", slotMachine.configuration()[0]);
    }
    /**
     * Verifica colectivamente que, al forzar una configuración donde todas las ruedas
     * quedan con el mismo símbolo mediante spin(String[]), el sistema cambie su
     * estado y detecte exitosamente el jackpot.
     */
    @Test
    public void accordingMsRhShouldDetectJackpotAfterForcedSpin() {
        slotMachine.addWheel(1);
        slotMachine.addWheel(2);
        slotMachine.addSymbol(1, "red");
        slotMachine.addSymbol(2, "blue");
        slotMachine.spin(new String[]{"red", "red"});
        assertTrue(slotMachine.isJackpot());
    }
    /**
     * Verifica que delWheel(int pos) elimine la última rueda
     * cuando la posición indicada es mayor que el número de ruedas.
     */
    @Test
    public void accordingMsRhShouldDeleteLastWheelWhenPositionGreaterThanSize() {
        slotMachine.addWheel(1);
        slotMachine.addWheel(2);
        slotMachine.delWheel(10);
        assertEquals(1, slotMachine.configuration().length);
    }
    
    //Grupo: Ibarra y Poveda
    
    //Casos de Prueba de Unidad:
    
    /**
     * Verifies that attempting to swap two wheels fails when one of
     * them is locked, setting the machine status to not ok.
     */
    @Test
    public void shouldNotSwap() {
        // Add some symbols
        slotMachine.addSymbol(1, "red");
        slotMachine.addSymbol(1, "blue");
       
        // Add some wheels
        slotMachine.addWheel(1);
        slotMachine.addWheel(2);
        slotMachine.addWheel(3);
       
        // Lock the first one
        slotMachine.lock(1);
       
        // Try to swap the 1st and the 3rd
        slotMachine.swap(1, 3);
       
        // Check that the action wasn't succesful due to the wheel to spin is locked
        assertFalse(slotMachine.ok());
    }    
     
    //G01 : BarraganA-GuerreroB
    /** Prueba que una rueda existente pueda ser bloqueada correctamente.
        * La maquina debe permitir bloquear una rueda que existe.
        * La operacion debe realizarse correctamente y ok() debe retornar true.
    */
            
        @Test
        public void accordingBaGqShouldLockWheel() {
            SlotMachine maquinaTraga = new SlotMachine();
            maquinaTraga.addWheel(1);
            maquinaTraga.lock(1);
            assertTrue(maquinaTraga.ok());
        }

    //Grupo-02 ForeroJ-SalinasS
    
    //Unit Test:
    
    /**
     * Tests that configuration() reports each wheel's current color
     */
    @Test
    
    public void accordingFmSnShouldShowCorrectConfiguration(){
    
        slotMachine.addWheel(1);
        slotMachine.addWheel(2);
        slotMachine.addWheel(3);
        slotMachine.addSymbol(1, "black");
        slotMachine.addSymbol(1, "red");  // Add a new symbol [black,red] - With black being the default. 
        slotMachine.addSymbol(1, "green"); // Add another symbol [black,green,red].
        slotMachine.placeSymbol(1, "red"); // Change the first wheel's symbol to red.
        slotMachine.placeSymbol(2, "green"); // Change the second wheel's symbol to green.
        slotMachine.placeSymbol(3, "black"); // Change the third wheel's symbol to black.
    
        
        String[] config = slotMachine.configuration(); // Create config with the machine's current configuration.
        
        assertEquals("red", config[0]); // Verify that positions match.
        assertEquals("green", config[1]); //
        assertEquals("black", config[2]); //
    }

    
    //G06: CañonA - PaezP
    
    //Prueba #1
    
    /**
     * Verifica el intercambio entre ruedas bloqueadas y desbloqueadas,
     * y la rotación de una rueda por pasos.
     */
    @Test
    public void accordingCaPpShouldNotSwapWhenWheelIsLockedAndWorkWhenUnlocked(){
        slotMachine.addWheel(1);
        slotMachine.addWheel(2);
        slotMachine.addWheel(3);
    
        slotMachine.addSymbol(1, "red");
        slotMachine.addSymbol(1, "blue");
    
        slotMachine.addSymbol(2, "green");
        slotMachine.addSymbol(2, "yellow");
    
        slotMachine.addSymbol(3, "magenta");
        slotMachine.addSymbol(3, "black");
    
        slotMachine.spin(new String[]{"blue", "yellow", "magenta"});
        assertEquals("blue", slotMachine.configuration()[0]);
    
        slotMachine.lock(2);
        slotMachine.swap(1, 2);
        
        assertFalse(slotMachine.ok());
        assertEquals("yellow", slotMachine.configuration()[1]);
    
        slotMachine.unlock(2);
        slotMachine.swap(1, 2);
        
        assertTrue(slotMachine.ok());
        assertEquals("yellow", slotMachine.configuration()[0]);
        assertEquals("blue", slotMachine.configuration()[1]);
    
        slotMachine.spin(3, 1);
        assertTrue(slotMachine.ok());
        assertNotNull(slotMachine.configuration());
        assertEquals(3, slotMachine.configuration().length);
    }
    
    //Prueba #2
    
    /**
     * Verifica la rotación por pasos y la detección de un jackpot.
     */
    @Test
    public void accordingCaPpShouldSpinByStepsAndDetectJackpotCorrectly(){
        slotMachine.addWheel(1);
        slotMachine.addWheel(2);
    
        slotMachine.addSymbol(1, "red");
        slotMachine.addSymbol(1, "blue");
        
        slotMachine.addSymbol(2, "red");
        slotMachine.addSymbol(2, "green");
    
        slotMachine.spin(new String[]{"red", "green"});
        assertTrue(slotMachine.ok());
        
        assertEquals(3, slotMachine.distinctSymbols());
        assertFalse(slotMachine.isJackpot());
    
    
        slotMachine.spin(2, 1);
        assertTrue(slotMachine.ok());
    
        String[] currentConfiguration = slotMachine.configuration();
        assertEquals("red", currentConfiguration[0]);
        assertEquals("red", currentConfiguration[1]);
        
        assertTrue(slotMachine.isJackpot());
    }
    
    //G07: GarcíaJ-QuezadaK
    
    /**
     * spin(wheel, 0) no debería mover la rueda — girar cero pasos es una
     * operación válida que no cambia nada, no un error.
     */
    @Test
    public void accordingGjQkShouldSucceedWithoutChangingConfigurationWhenSpinningZeroSteps() {
        SlotMachine m = new SlotMachine();
        m.addWheel(1);
        m.addSymbol(1, "red");
        m.addSymbol(2, "blue");
        String before = m.configuration()[0];
        m.spin(1, 0);
        assertTrue(m.ok());
        assertEquals(before, m.configuration()[0]);
    }
    
    /**
     * Fijar una rueda que ya estaba fija no debería fallar — lock() es
     * idempotente, no un error repetir la operación.
     */
    @Test
    public void accordingGjQkShouldSucceedWhenLockingAnAlreadyLockedWheel() {
        SlotMachine m = new SlotMachine();
        m.addWheel(1);
        m.lock(1);
        m.lock(1);
        assertTrue(m.ok());
    }
    
    //G02: GarzonR- MendivelsoS:
    
    /**
     * If a symbol doesn't exists, wheels should change their symbols except 
     * that one with the strange symbol.
     */
    @Test
    public void accordingGrMsShouldNotSetSymbolsThatDoesNotExists(){
        SlotMachine slotMachine = new SlotMachine();
        slotMachine.addSymbol(1,"red");
        slotMachine.addSymbol(2,"blue");
        slotMachine.addSymbol(3,"green");
        while(slotMachine.configuration().length < 3){
             slotMachine.addWheel(1);   
        }
    
        
        String[] begin = {"red", "blue", "green"};
        slotMachine.spin(begin);
        
        String[] strangeSymbols = {"red", "null", "blue"};
        slotMachine.spin(strangeSymbols);
        
        String[] waited = {"red", "blue", "blue"};
        String[] afterSpin = slotMachine.configuration();
        
        assertEquals(waited, afterSpin);
    }
    /**
     * If a symbol doesn't exists it shouldn't be added and 
     * you shouldn't win if you try to set the machine with that symbol.
     */
    @Test
    public void accordingGrMsShouldNotAddStrangeSymbolsAndWinWithThatSymbol(){
        SlotMachine slotMachine = new SlotMachine();
        slotMachine.addSymbol(1,"red");
        slotMachine.addSymbol(2,"blue");
        slotMachine.addSymbol(3,"green");
        while(slotMachine.configuration().length < 3){
             slotMachine.addWheel(1);   
        }
    
        slotMachine.addSymbol(4, "strange");
        
        String[] strangeCombination = {"strange", "strange", "strange"};
        
        assertFalse(slotMachine.isJackpot());
    }
    
    //G02: Carvajal- Largo:
    
    /**
     * Verifies that spinning a wheel advances it to the next symbol
     * in the machine's symbol list.
     */
    @Test
    public void accordingCxLxShouldAdvanceToNextSymbol() {
        SlotMachine machine = new SlotMachine();
        machine.addSymbol(1, "red");
        machine.addSymbol(2, "blue");
        machine.addWheel(1);
        machine.placeSymbol(1, "red");
        machine.spin(1);
        assertEquals("blue", machine.configuration()[0]);  
        assertTrue(machine.ok());
    }
    
    /**
     * Verifies that deleting a symbol that is not in the machine fails
     * and leaves the symbol list unchanged.
     */
    @Test
    public void accordingCxLxShouldNotDeleteMissingSymbol() {
        SlotMachine machine = new SlotMachine();
        machine.addSymbol(1, "red");
        machine.delSymbol("blue");
        assertFalse(machine.ok());                          
        assertEquals(1, machine.symbols().length);           
    }
    
    //G02: MeloR-SanabriaE
    
    /**
     * Debería: una rueda fijada no debe moverse ante un intento de
     * giro, y debe volver a poder girar después de un unlock.
     */
    @Test
    public void accordingMrSeShouldKeepLockedWheelFixedAndAllowSpinAfterUnlock() {
        SlotMachine machine = new SlotMachine();
        machine.addWheel(1);
        machine.addSymbol(1, "red");
        machine.addSymbol(1, "blue");
        machine.placeSymbol(1, "red"); // estado conocido
    
        machine.lock(1);
        machine.spin(1, 2); // intenta girar la rueda fija
    
        assertFalse(machine.ok());
        assertEquals("red", machine.configuration()[0]); // no debió moverse
    
        machine.unlock(1);
        machine.spin(1, 1); // ahora sí debe poder girar
    
        assertTrue(machine.ok());
    }
    
    /**
     * No debería: aplicar ningún cambio si uno de los colores pedidos
     * no existe en su rueda correspondiente
     */
    @Test
    public void accordingMrSeShouldRejectSpinSetSymbolsWhenColorMissing() {
        SlotMachine machine = new SlotMachine();
        machine.addWheel(1);
        machine.addWheel(2);
        machine.addSymbol(1, "red");
        machine.addSymbol(2, "green");
    
        String[] before = machine.configuration();
        machine.spin(new String[]{"red", "purple"}); // "purple" no existe
    
        assertFalse(machine.ok());
        assertArrayEquals(before, machine.configuration()); // nada se movió
    }
    
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
}