import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class SlotMachineC4Test.
 *
 * @author David Páez y Joseph Cañon
 * @version 04/10/2026
 */
public class SlotMachineC4Test{

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    @Test
    public void shouldNotDeleteRebelWheel() {
        SlotMachine machine = new SlotMachine();
    
        machine.addWheel("normal", 1);
        machine.addWheel("rebel", 2);
    
        machine.delWheel(2);
    
        assertFalse(machine.ok());
        assertEquals(2, machine.configuration().length);
    }
    
    @Test
    public void shouldCreateTheCorrectSymbolTypes() {
        SlotMachine machine = new SlotMachine();
    
        machine.addWheel("normal", 1);
        machine.addSymbol("normal", 1, "red");
        machine.addSymbol("ephemeral", 1, "blue");
        machine.addSymbol("shy", 1, "green");
        assertTrue(machine.ok());
    }
    
    @Test
    public void shouldSpinReverseWheelInOppositeDirection() {
        SlotMachine machine = new SlotMachine();
        
        machine.addWheel("reverse", 1);
        machine.addSymbol("normal", 1, "red");
        machine.addSymbol("normal", 1, "blue");
        machine.addSymbol("normal", 1, "green");
        
        // Configuramos para que inicie en "red"
        machine.spin(new String[]{"red"});
        
        // Giramos 1 posición hacia adelante (positivo).
        // Como es ReverseWheel, debería girar hacia atrás. 
        // El símbolo anterior a "red" en [red, blue, green] es "green"
        machine.spin(1, 1);
        
        assertTrue(machine.ok());
        assertEquals("green", machine.configuration()[0]);
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
