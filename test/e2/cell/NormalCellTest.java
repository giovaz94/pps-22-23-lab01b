package e2.cell;

import e2.Pair;
import e2.cell.type.CellType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NormalCellTest extends AbstractCellTest{

    public static final Pair<Integer, Integer> DEFAULT_CELL_POSITION = new Pair<>(1, 1);

    private Cell cell;

    @BeforeEach
    public void setup() {
        this.cell = new NormalCellImpl(DEFAULT_CELL_POSITION);
    }

    @Test
    public void testType() {
        assertEquals(this.getCell().getType(), CellType.NORMAL_CELL_TYPE);
    }

    @Test
    public void testAdjacentMines() {
        final List<Pair<Integer, Integer>> minesList = List.of(new Pair<>(4,4), new Pair<>(5,6));
        NormalCell cell = new NormalCellImpl(new Pair<>(5,5));
        assertEquals(minesList, cell.getAdjacentMines(minesList));
        assertEquals(2, cell.numberOfAdjacentMines(minesList));
    }

    @Test
    public void testClick() {
        this.getCell().click();
        assertTrue(this.getCell().isClicked());
    }

    @Override
    public Cell getCell() {
        return this.cell;
    }
}