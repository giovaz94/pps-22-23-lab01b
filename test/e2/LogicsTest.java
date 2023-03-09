package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class LogicsTest {

    public static final int GRID_SIZE = 10;
    public static final int DEFAULT_MINES = 5;

    private Logics logicImpl;

    @BeforeEach
    public void setup() {
        this.logicImpl = new LogicsImpl(GRID_SIZE, DEFAULT_MINES);
    }

    @Test
    public void testNumberOfMines() {
        assertEquals(DEFAULT_MINES, this.logicImpl.getMines().size());
    }

    @Test
    public void testDifferentMinesPositon() {
        for (Pair<Integer,Integer> mine: this.logicImpl.getMines()) {
           final List<Pair<Integer, Integer>> minesCopy =  new ArrayList<>(this.logicImpl.getMines());
           assertTrue(minesCopy.remove(mine));
           assertTrue(minesCopy.stream().noneMatch(p -> p.equals(mine)));
        }
    }
}