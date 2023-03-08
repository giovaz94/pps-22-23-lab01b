package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

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

    @RepeatedTest(20)
    public void testRandomlyGeneratedPositionAreInGrid() {
        assertTrue(this.isInGrid(this.gameLogic.getKnight().getX(), this.gameLogic.getKnight().getY()));
        assertTrue(this.isInGrid(this.gameLogic.getPawn().getX(), this.gameLogic.getPawn().getY()));
    }

    @Test
    public void testHit() {
        final Pair<Integer,Integer> pawnPosition = this.generatePosition(1,3);
        final Pair<Integer,Integer> knightPosition = this.generatePosition(3,4);
        final Pair<Integer,Integer> emptyPosition = this.generatePosition(2,2);
        this.gameLogic = new LogicsImpl(GAME_GRID_SIZE, pawnPosition, knightPosition);

        assertTrue(this.gameLogic.hit(pawnPosition.getX(), pawnPosition.getY()));
    }

    private Pair<Integer, Integer> generatePosition(int x, int y) {
        return new Pair<>(x,y);
    }

    private boolean isInGrid(int x, int y) {
        return !(x<0 || y<0 || x >= GAME_GRID_SIZE || y >= GAME_GRID_SIZE);
    }
}