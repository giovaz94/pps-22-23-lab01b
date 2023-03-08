package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
class LogicsImplTest {

    public static final int GAME_GRID_SIZE = 5;
    private Logics gameLogic;

    @BeforeEach
    public void setup() {
        this.gameLogic = new LogicsImpl(GAME_GRID_SIZE);
    }

    @Test
    public void testInitialCondition() {
        assertNotNull(this.gameLogic.getPawn());
        assertNotNull(this.gameLogic.getKnight());
    }

    @Test
    public void testInvalidMove() {
        final Pair<Integer,Integer> position = new Pair<>(GAME_GRID_SIZE, GAME_GRID_SIZE);
        assertThrowsExactly(IndexOutOfBoundsException.class, () -> this.gameLogic.hit(position.getX(), position.getY()));
    }
    @Test
    public void testHit() {
        final Pair<Integer,Integer> pawnPosition = new Pair<>(1,3);
        final Pair<Integer,Integer> knightPosition = new Pair<>(3,4);
        this.gameLogic = new LogicsImpl(GAME_GRID_SIZE, pawnPosition, knightPosition);
        assertTrue(this.gameLogic.hit(pawnPosition.getX(), pawnPosition.getY()));
    }
}