package e2.cell;

import e2.Pair;
import e2.cell.type.CellType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlagCellTest extends AbstractCellTest{

    public static final Pair<Integer, Integer> DEFAULT_CELL_POSITION = new Pair<>(1, 1);

    private Cell cell;

    @BeforeEach
    public void setup() {
        this.cell = new FlagCell(DEFAULT_CELL_POSITION);
    }

    @Test
    public void testType() {
        assertEquals(this.getCell().getType(), CellType.FLAG_CELL_TYPE);
    }

    @Override
    public Cell getCell() {
        return this.cell;
    }
}