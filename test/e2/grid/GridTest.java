package e2.grid;

import e2.Pair;
import e2.cell.Cell;
import e2.cell.NormalCell;
import e2.cell.type.CellType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

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
        Pair<Integer, Integer> noMinePosition = this.getRandomFreePosition();
        this.grid.click(noMinePosition);
        assertTrue(this.grid.isClicked(noMinePosition));
    }

    private Pair<Integer, Integer> getRandomFreePosition() {
        return this.getRandomCellByPredicate(cell -> cell.getType().equals(CellType.NORMAL_CELL_TYPE)).getPosition();
    }

    @Test
    public void testDifferentMinesPositon() {
        for (Pair<Integer,Integer> mine: this.grid.getMines()) {
            final List<Pair<Integer, Integer>> minesCopy =  new ArrayList<>(this.grid.getMines());
            assertTrue(minesCopy.remove(mine));
            assertTrue(minesCopy.stream().noneMatch(p -> p.equals(mine)));
        }
    }

    @RepeatedTest(10)
    public void testFlagPlacement() {
        Cell cell = this.getRandomCellByPredicate(c-> !c.isClicked());
        assertTrue(this.grid.placeFlag(cell.getPosition()));
        assertEquals(this.grid.getCell(cell.getPosition()).getType(), CellType.FLAG_CELL_TYPE);
        assertFalse(this.grid.placeFlag(cell.getPosition()));
    }

    private Cell getRandomCellByPredicate(Predicate<Cell> predicate) {
        Random random = new Random();
        Cell outputCell;
        do {
            int x = random.nextInt(DEFAULT_GRID_SIZE);
            int y = random.nextInt(DEFAULT_GRID_SIZE);
            outputCell = this.grid.getCell(new Pair<> (x,y));
        } while (!predicate.test(outputCell));
        return outputCell;
    }

}