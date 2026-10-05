

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class SlotMachineContestTest.
 *
 * @author  David Páez y Joseph Cañon
 * @version 18/09/2026
 */
public class SlotMachineContestTest{

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /** 
    * Checks that the solve method returns a result. 
    */
    @Test
    public void shouldReturnMoves() {
        SlotMachineContest contest = new SlotMachineContest();
        int[][] moves = contest.solve(3);
        assertNotNull(moves);
    }
    
    /**
     * Verifies that the solve method returns a non-null move matrix where
     * each individual move contains exactly two elements: the wheel index and the rotation step.
     */
    @Test
    public void shouldReturnValidMovesStructure() {
        SlotMachineContest contest = new SlotMachineContest();
        int n = 3;
        int[][] moves = contest.solve(n);

        assertNotNull(moves);
        for (int[] move : moves) {
            assertEquals(2, move.length);
        }
    }
    
    /** 
    * Checks that every move uses a valid wheel number. 
    */
    @Test
    public void shouldUseValidWheels() {
        SlotMachineContest contest = new SlotMachineContest();
        int n = 3;
        int[][] moves = contest.solve(n);
        for (int[] move : moves) {
            assertTrue(move[0] >= 1 && move[0] <= n);
        }
    }
    
    /**
     * Verifies that the simulation workflow executes from start to finish without throwing any runtime exceptions or falling into infinite loops.
     */
    @Test
    public void shouldRunSimulationWithoutErrors() {
        SlotMachineContest contest = new SlotMachineContest();
        contest.simulate(3);
    }
    
    /** 
    * Checks that no move uses wheel zero. 
    */
    @Test
    public void shouldNotUseWheelZero() {
        SlotMachineContest contest = new SlotMachineContest();
        int[][] moves = contest.solve(3);
        for (int[] move : moves) {
            assertNotEquals(0, move[0]);
        }
    }
    
    /** 
    * Checks that no move is empty. 
    */
    @Test
    public void shouldNotUseEmptyMove() {
        SlotMachineContest contest = new SlotMachineContest();
        int[][] moves = contest.solve(3);
        for (int[] move : moves) {
            assertFalse(move.length == 0);
        }
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
