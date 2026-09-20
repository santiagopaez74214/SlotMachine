

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class SlotMachineContestCTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SlotMachineContestCTest
{

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    //Grupo: GomezB-CarreroC   
    /**
     * Verifies that solve returns
     * the expected number of movements.
     */
    @Test
    public void accordingCcGbShouldtestSolveNumberOfMovements()
    {
        SlotMachineContest contest = new SlotMachineContest();

        int[][] solution = contest.solve(5);

        assertEquals(5, solution.length);
    }



    /**
     * Verifies that all wheels share the same
     * symbol order according to the contest problem.
     */
    @Test
    public void accordingCcGbShouldtestAllWheelsHaveSameSymbolOrder()
    {
        SlotMachine machine = new SlotMachine(3);

        String[] configuration = machine.configuration();

        assertEquals("red", configuration[0]);
        assertEquals("red", configuration[1]);
        assertEquals("red", configuration[2]);
    }

    //Grupo: CortazarJ-MartinezC
    
    /**
     * Verifica que SlotMachine(n) crea exactamente n ruedas, cada una
     * con n símbolos montados, tal como exige el requisito 13.
     */
    @Test
    public void accordingCjMcShouldCreateEqualWheelsAndSymbolsPerWheel() {
        SlotMachine sm = new SlotMachine(5);    
        assertEquals(5, sm.configuration().length);
        assertEquals(5, sm.symbols().length);
    }
    
    
    /**
     * Verifica que solve(n) nunca propone más acciones que ruedas existen
     * en la máquina, y que cada acción referencia una rueda dentro de un
     * rango válido (1 a n).
     */
    
    @Test
    public void accordingCjMcShouldProposeAtMostOneActionPerValidWheel() {
        SlotMachineContest SlotMachineContest = new SlotMachineContest();
        int n = 4;
        int[][] actions = SlotMachineContest.solve(n);
    
        assertTrue(actions.length <= n);
        for (int[] action : actions) {
            int wheel = action[0];
            assertTrue(wheel >= 1 && wheel <= n);
        }
    }
    
    // GRUPO 6: CañonA-PaezP
    
    //Test #1
    /**
     * Verifies that the solve method returns a non-null move matrix where
     * each individual move contains exactly two elements: the wheel index and the rotation step.
     */
    @Test
    public void accordingCaPpshouldReturnValidMovesStructure() {
        SlotMachineContest contest = new SlotMachineContest();
        int n = 3;
        int[][] moves = contest.solve(n);

        assertNotNull(moves);
        for (int[] move : moves) {
            assertEquals(2, move.length);
        }
    }

    //Test #2
    /**
     * Verifies that the simulation workflow executes from start to finish without throwing any runtime exceptions or falling into infinite loops.
     */
    @Test
    public void accordingCaPpshouldRunSimulationWithoutErrors() {
        int n = 3;
        SlotMachineContest contest = new SlotMachineContest();
        contest.simulate(n);
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
