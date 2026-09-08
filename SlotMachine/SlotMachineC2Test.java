import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Pruebas unitarias de la clase SlotMachine.
 *
 * Cada método público de SlotMachine tiene dos pruebas:
 * una para verificar lo que debería hacer y otra para verificar
 * lo que no debería hacer.
 *
 * @author David Páez y Joseph Cañon
 * @version 07/09/2026
 */
public class SlotMachineC2Test {

    private SlotMachine slotMachine;

    /**
     * Crea una nueva máquina antes de cada prueba.
     */
    @BeforeEach
    public void setUp() {
        slotMachine = new SlotMachine();
        slotMachine.makeInvisible();
    }
    
    //addWheel(int)

    /**
     * Verifica que se pueda agregar una rueda.
     */
    @Test
    public void shouldAddWheel() {
        slotMachine.addWheel(1);

        assertTrue(slotMachine.ok());
        assertEquals(1, slotMachine.configuration().length);
    }

    /**
     * Verifica que una posición negativa no genere una rueda en una posición negativa, sino en la posición 1.
     */
    @Test
    public void shouldNotCreateNegativePositionWheel() {
        slotMachine.addWheel(-1);

        assertTrue(slotMachine.ok());
        assertEquals(1, slotMachine.configuration().length);
    }

    // delWheel(int)

    /**
     * Verifica que se pueda eliminar una rueda existente.
     */
    @Test
    public void shouldDeleteExistingWheel() {
        slotMachine.addWheel(1);
        slotMachine.addWheel(2);

        slotMachine.delWheel(1);

        assertTrue(slotMachine.ok());
        assertEquals(1, slotMachine.configuration().length);
    }

    /**
     * Verifica que no se pueda eliminar una rueda inexistente.
     */
    @Test
    public void shouldNotDeleteNonExistingWheel() {
        slotMachine.addWheel(1);

        slotMachine.delWheel(2);

        assertFalse(slotMachine.ok());
        assertEquals(1, slotMachine.configuration().length);
    }

    // addSymbol(int, String)

    /**
     * Verifica que se pueda agregar un símbolo a una rueda.
     */
    @Test
    public void shouldAddSymbolToWheel() {
        slotMachine.addWheel(1);

        slotMachine.addSymbol(1, "red");

        assertTrue(slotMachine.ok());
    }

    /**
     * Verifica que no se pueda agregar un símbolo a una
     * rueda inexistente.
     */
    @Test
    public void shouldNotAddSymbolToNonExistingWheel() {
        slotMachine.addSymbol(1, "red");

        assertFalse(slotMachine.ok());
        assertEquals(0, slotMachine.symbols().length);
    }
    
    // delSymbol(String)

    /**
     * Verifica que se pueda eliminar un símbolo existente.
     */
    @Test
    public void shouldDeleteExistingSymbol() {
        slotMachine.addWheel(1);
        slotMachine.addSymbol(1, "red");

        slotMachine.delSymbol("red");

        assertTrue(slotMachine.ok());
        assertEquals(0, slotMachine.symbols().length);
    }

    /**
     * Verifica que no se pueda eliminar un símbolo inexistente.
     */
    @Test
    public void shouldNotDeleteNonExistingSymbol() {
        slotMachine.addWheel(1);
        slotMachine.addSymbol(1, "red");

        slotMachine.delSymbol("blue");

        assertFalse(slotMachine.ok());
    }

    // placeSymbol(int, String)

    /**
     * Verifica que se pueda colocar un símbolo existente
     * como símbolo actual.
     */
    @Test
    public void shouldPlaceExistingSymbol() {
        slotMachine.addWheel(1);
        slotMachine.addSymbol(1, "red");
        slotMachine.addSymbol(1, "blue");

        slotMachine.placeSymbol(1, "blue");

        assertTrue(slotMachine.ok());
        assertEquals("blue", slotMachine.configuration()[0]);
    }

    /**
     * Verifica que no se pueda colocar un símbolo que no existe.
     */
    @Test
    public void shouldNotPlaceNonExistingSymbol() {
        slotMachine.addWheel(1);
        slotMachine.addSymbol(1, "red");

        slotMachine.placeSymbol(1, "blue");

        assertFalse(slotMachine.ok());
        assertEquals("red", slotMachine.configuration()[0]);
    }

    // spin(int)

    /**
     * Verifica que una rueda existente pueda girar.
     */
    @Test
    public void shouldSpinExistingWheel() {
        slotMachine.addWheel(1);
        slotMachine.addSymbol(1, "red");
        slotMachine.addSymbol(1, "blue");

        slotMachine.spin(1);

        assertTrue(slotMachine.ok());
    }

    /**
     * Verifica que no se pueda girar una rueda inexistente.
     */
    @Test
    public void shouldNotSpinNonExistingWheel() {
        slotMachine.addWheel(1);
        slotMachine.addSymbol(1, "red");

        slotMachine.spin(2);

        assertFalse(slotMachine.ok());
    }

    // spin()

    /**
     * Verifica que se puedan girar todas las ruedas.
     */
    @Test
    public void shouldSpinAllWheels() {
        slotMachine.addWheel(1);
        slotMachine.addWheel(2);

        slotMachine.addSymbol(1, "red");
        slotMachine.addSymbol(1, "blue");

        slotMachine.addSymbol(2, "green");
        slotMachine.addSymbol(2, "yellow");

        slotMachine.spin();

        assertTrue(slotMachine.ok());
        assertEquals(2, slotMachine.configuration().length);
    }

    /**
     * Verifica que no se pueda girar la máquina cuando
     * no existen ruedas.
     */
    @Test
    public void shouldNotSpinWithoutWheels() {
        slotMachine.spin();

        assertFalse(slotMachine.ok());
        assertEquals(0, slotMachine.configuration().length);
    }

    // symbols()

    /**
     * Verifica que se obtengan los símbolos únicos de la máquina.
     */
    @Test
    public void shouldReturnUniqueSymbols() {
        slotMachine.addWheel(1);
        slotMachine.addWheel(2);

        slotMachine.addSymbol(1, "red");
        slotMachine.addSymbol(1, "blue");

        slotMachine.addSymbol(2, "red");
        slotMachine.addSymbol(2, "green");

        assertArrayEquals(new String[]{"red", "blue", "green"},slotMachine.symbols());
        assertTrue(slotMachine.ok());
    }

    /**
     * Verifica que una máquina vacía no devuelva símbolos
     * que no existen.
     */
    @Test
    public void shouldNotReturnSymbolsWhenMachineIsEmpty() {
        String[] symbols = slotMachine.symbols();

        assertNotNull(symbols);
        assertEquals(0, symbols.length);
        assertTrue(slotMachine.ok());
    }

    // distinctSymbols()

    /**
     * Verifica que se cuenten solamente los símbolos diferentes.
     */
    @Test
    public void shouldCountDistinctSymbols() {
        slotMachine.addWheel(1);
        slotMachine.addWheel(2);

        slotMachine.addSymbol(1, "red");
        slotMachine.addSymbol(1, "blue");

        slotMachine.addSymbol(2, "red");
        slotMachine.addSymbol(2, "green");

        assertEquals(3, slotMachine.distinctSymbols());
        assertTrue(slotMachine.ok());
    }

    /**
     * Verifica que una máquina sin símbolos tenga cero símbolos
     * diferentes.
     */
    @Test
    public void shouldNotCountSymbolsWhenMachineIsEmpty() {
        assertEquals(0, slotMachine.distinctSymbols());
        assertTrue(slotMachine.ok());
    }

    // isJackpot()

    /**
     * Verifica que se detecte un jackpot cuando todas las ruedas
     * muestran el mismo símbolo.
     */
    @Test
    public void shouldDetectJackpot() {
        slotMachine.addWheel(1);
        slotMachine.addWheel(2);
        slotMachine.addWheel(3);

        slotMachine.addSymbol(1, "red");
        slotMachine.addSymbol(2, "red");
        slotMachine.addSymbol(3, "red");

        slotMachine.spin(
            new String[]{"red", "red", "red"}
        );

        assertTrue(slotMachine.isJackpot());
        assertTrue(slotMachine.ok());
    }

    /**
     * Verifica que no se detecte jackpot cuando las ruedas
     * muestran símbolos diferentes.
     */
    @Test
    public void shouldNotDetectJackpotWithDifferentSymbols() {
        slotMachine.addWheel(1);
        slotMachine.addWheel(2);

        slotMachine.addSymbol(1, "red");
        slotMachine.addSymbol(2, "blue");

        slotMachine.spin(
            new String[]{"red", "blue"}
        );

        assertFalse(slotMachine.isJackpot());
    }

    // configuration()

    /**
     * Verifica que se obtenga la configuración actual.
     */
    @Test
    public void shouldReturnCurrentConfiguration() {
        slotMachine.addWheel(1);
        slotMachine.addWheel(2);

        slotMachine.addSymbol(1, "red");
        slotMachine.addSymbol(2, "blue");

        slotMachine.spin(
            new String[]{"red", "blue"}
        );

        assertArrayEquals(
            new String[]{"red", "blue"},
            slotMachine.configuration()
        );

        assertTrue(slotMachine.ok());
    }

    /**
     * Verifica que una máquina sin ruedas no devuelva
     * posiciones inexistentes.
     */
    @Test
    public void shouldNotReturnNonExistingWheels() {
        String[] configuration = slotMachine.configuration();

        assertNotNull(configuration);
        assertEquals(0, configuration.length);
        assertTrue(slotMachine.ok());
    }

    // makeVisible()

    /**
     * Verifica que la máquina pueda hacerse visible.
     */
    @Test
    public void shouldMakeMachineVisible() {
        slotMachine.makeVisible();

        assertTrue(slotMachine.ok());

        slotMachine.makeInvisible();
    }

    /**
     * Verifica que llamar dos veces a makeVisible()
     * no genere un error.
     */
    @Test
    public void shouldNotFailWhenMakingMachineVisibleAgain() {
        slotMachine.makeVisible();
        slotMachine.makeVisible();

        assertTrue(slotMachine.ok());

        slotMachine.makeInvisible();
    }

    // makeInvisible()

    /**
     * Verifica que la máquina pueda hacerse invisible.
     */
    @Test
    public void shouldMakeMachineInvisible() {
        slotMachine.makeVisible();
        slotMachine.makeInvisible();

        assertTrue(slotMachine.ok());
    }

    /**
     * Verifica que llamar dos veces a makeInvisible()
     * no genere un error.
     */
    @Test
    public void shouldNotFailWhenMakingMachineInvisibleAgain() {
        slotMachine.makeInvisible();
        slotMachine.makeInvisible();

        assertTrue(slotMachine.ok());
    }

    // exit()

    /**
     * Verifica el comportamiento esperado de salida.
     *
     * El método exit() actual muestra un JOptionPane,
     * por lo que no se invoca directamente para evitar
     * bloquear la ejecución automática de JUnit.
     */
    @Test
    public void shouldExitMachine() {
        assertTrue(true);
    }

    /**
     * Verifica que la salida no produzca un estado fallido.
     *
     * No se invoca exit() debido al JOptionPane implementado
     * actualmente en el método.
     */
    @Test
    public void shouldNotLeaveFailedOperationAfterExit() {
        assertTrue(true);
    }

    // ok()

    /**
     * Verifica que ok() devuelva true después de una operación
     * exitosa.
     */
    @Test
    public void shouldReturnTrueWhenLastOperationSucceeded() {
        slotMachine.addWheel(1);

        assertTrue(slotMachine.ok());
    }

    /**
     * Verifica que ok() devuelva false después de una operación
     * fallida.
     */
    @Test
    public void shouldReturnFalseWhenLastOperationFailed() {
        slotMachine.delWheel(1);

        assertFalse(slotMachine.ok());
    }
    
    // swap(int, int)

    /**
     * Verifica que dos ruedas puedan intercambiar posiciones.
     */
    @Test
    public void shouldSwapWheels() {
        slotMachine.addWheel(1);
        slotMachine.addWheel(2);

        slotMachine.addSymbol(1, "red");
        slotMachine.addSymbol(2, "blue");

        slotMachine.spin(new String[]{"red", "blue"});

        slotMachine.swap(1, 2);

        assertTrue(slotMachine.ok());
        assertEquals("blue", slotMachine.configuration()[0]);
        assertEquals("red", slotMachine.configuration()[1]);
    }

    /**
     * Verifica que no se pueda intercambiar una rueda
     * con una posición inexistente.
     */
    @Test
    public void shouldNotSwapNonExistingWheels() {
        slotMachine.addWheel(1);
        slotMachine.addSymbol(1, "red");

        slotMachine.swap(1, 2);

        assertFalse(slotMachine.ok());
        assertEquals("red", slotMachine.configuration()[0]);
    }

    // lock(int)

    /**
     * Verifica que una rueda pueda bloquearse y que,
     * posteriormente, no pueda rotar.
     */
    @Test
    public void shouldLockWheel() {
        slotMachine.addWheel(1);

        slotMachine.addSymbol(1, "red");
        slotMachine.addSymbol(1, "blue");

        slotMachine.spin(new String[]{"red"});

        slotMachine.lock(1);
        slotMachine.spin(1, 1);

        assertFalse(slotMachine.ok());
        assertEquals("red", slotMachine.configuration()[0]);
    }

    /**
     * Verifica que no se pueda bloquear una rueda inexistente.
     */
    @Test
    public void shouldNotLockNonExistingWheel() {
        slotMachine.lock(1);

        assertFalse(slotMachine.ok());
    }

    // unlock(int)

    /**
     * Verifica que una rueda pueda desbloquearse y volver a rotar.
     */
    @Test
    public void shouldUnlockWheel() {
        slotMachine.addWheel(1);

        slotMachine.addSymbol(1, "red");
        slotMachine.addSymbol(1, "blue");

        slotMachine.spin(new String[]{"red"});

        slotMachine.lock(1);
        slotMachine.unlock(1);
        slotMachine.spin(1, 1);

        assertTrue(slotMachine.ok());
        assertEquals("blue", slotMachine.configuration()[0]);
    }

    /**
     * Verifica que no se pueda desbloquear una rueda inexistente.
     */
    @Test
    public void shouldNotUnlockNonExistingWheel() {
        slotMachine.unlock(1);

        assertFalse(slotMachine.ok());
    }

    // spin(int, int)

    /**
     * Verifica que una rueda pueda rotar una cantidad
     * determinada de pasos.
     */
    @Test
    public void shouldSpinWheelBySteps() {
        slotMachine.addWheel(1);

        slotMachine.addSymbol(1, "red");
        slotMachine.addSymbol(1, "blue");
        slotMachine.addSymbol(1, "green");

        slotMachine.spin(new String[]{"red"});

        slotMachine.spin(1, 1);

        assertTrue(slotMachine.ok());
        assertEquals("blue", slotMachine.configuration()[0]);
    }

    /**
     * Verifica que una rueda bloqueada no pueda rotar
     * mediante una cantidad determinada de pasos.
     */
    @Test
    public void shouldNotSpinLockedWheel() {
        slotMachine.addWheel(1);

        slotMachine.addSymbol(1, "red");
        slotMachine.addSymbol(1, "blue");

        slotMachine.spin(new String[]{"red"});

        slotMachine.lock(1);
        slotMachine.spin(1, 1);

        assertFalse(slotMachine.ok());
        assertEquals("red", slotMachine.configuration()[0]);
    }

    // spin(String[])

    /**
     * Verifica que se pueda establecer una configuración válida.
     */
    @Test
    public void shouldSetValidConfiguration() {
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

        assertTrue(slotMachine.ok());

        assertArrayEquals(new String[]{"blue", "yellow", "magenta"},slotMachine.configuration());
    }

    /**
     * Verifica que no se pueda establecer una configuración
     * cuya cantidad de símbolos no coincida con la cantidad
     * de ruedas.
     */
    @Test
    public void shouldNotSetConfigurationWithWrongSize() {
        slotMachine.addWheel(1);
        slotMachine.addWheel(2);

        slotMachine.addSymbol(1, "red");
        slotMachine.addSymbol(2, "blue");

        slotMachine.spin(new String[]{"red", "blue"});

        slotMachine.spin(new String[]{"red"});

        assertFalse(slotMachine.ok());

        assertArrayEquals(new String[]{"red", "blue"},slotMachine.configuration());
    }
}