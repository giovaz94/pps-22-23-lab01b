package e2.grid;

import e2.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class GridTest {

    public static final int DEFAULT_GRID_SIZE = 7;
    public static final int DEFAULT_MINES_NUMBER = 5;
    private Grid grid;

    @BeforeEach
    public void Setup() {
        this.grid = new GridImpl(DEFAULT_GRID_SIZE, DEFAULT_MINES_NUMBER);
    }

    @Test
    public void testNumberOfMines() {
        assertEquals(DEFAULT_MINES_NUMBER, this.grid.getMines().size());
    }

    @Test
    public void testHasMine() {
        Random random = new Random();
        Pair<Integer,Integer> randomMine = this.grid.getMines().get(random.nextInt(this.grid.getMines().size()));
        assertTrue(this.grid.hasMine(randomMine));
    }

    @Test
    public void testIsClicked() {
        this.grid.click(new Pair<>(1,1));
        assertTrue(this.grid.isClicked(new Pair<>(1,1)));
    }

    @Test
    public void testDifferentMinesPositon() {
        for (Pair<Integer,Integer> mine: this.grid.getMines()) {
            final List<Pair<Integer, Integer>> minesCopy =  new ArrayList<>(this.grid.getMines());
            assertTrue(minesCopy.remove(mine));
            assertTrue(minesCopy.stream().noneMatch(p -> p.equals(mine)));
        }
    }
}