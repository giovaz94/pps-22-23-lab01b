package e2.grid;

import e2.Pair;
import e2.cell.NormalCell;
import e2.cell.NormalCellImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
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

    @RepeatedTest(20)
    public void testIsClicked() {
        Random random = new Random();
        NormalCell cell;
        Pair<Integer,Integer> noMinePosition;
        do {
            noMinePosition = new Pair<>(random.nextInt(DEFAULT_GRID_SIZE), random.nextInt(DEFAULT_GRID_SIZE));
            cell = new NormalCellImpl(noMinePosition);
        } while(this.grid.getMines().contains(noMinePosition) || cell.numberOfAdjacentMines(this.grid.getMines()) != 0);


        this.grid.click(noMinePosition);
        assertTrue(this.grid.isClicked(noMinePosition));
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