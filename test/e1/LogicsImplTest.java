package e1;

import org.junit.jupiter.api.BeforeEach;
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
        assertTrue(checkInBoard(p -> this.gameLogic.hasPawn(p.getX(), p.getY())));
        assertTrue(checkInBoard(p -> this.gameLogic.hasKnight(p.getX(), p.getY())));
    }

    @Test
    public void testInvalidMove() {
        final Pair<Integer,Integer> position = new Pair<>(GAME_GRID_SIZE, GAME_GRID_SIZE);
        assertThrowsExactly(IndexOutOfBoundsException.class, () -> this.gameLogic.hit(position.getX(), position.getY()));
    }

    @Test
    public void testHit() {
        final Pair<Integer,Integer> pawnPosition = this.generatePosition(1,3);
        final Pair<Integer,Integer> knightPosition = this.generatePosition(3,4);
        final Pair<Integer,Integer> emptyPosition = this.generatePosition(2,2);
        this.gameLogic = new LogicsImpl(GAME_GRID_SIZE, pawnPosition, knightPosition);
        assertTrue(this.gameLogic.hit(pawnPosition.getX(), pawnPosition.getY()));
        assertFalse(this.gameLogic.hit(emptyPosition.getX(), emptyPosition.getY()));
    }




    private boolean checkInBoard(final Predicate<Pair<Integer, Integer>> predicate) {
        for (int i = 0; i < GAME_GRID_SIZE; i++) {
            for (int j = 0; j < GAME_GRID_SIZE; j++) {
                if( predicate.test(new Pair<>(i, j))) {
                    return true;
                }
            }
        }
        return  false;
    }

    private Pair<Integer, Integer> generatePosition(int x, int y) {
        return new Pair<>(x,y);
    }
}