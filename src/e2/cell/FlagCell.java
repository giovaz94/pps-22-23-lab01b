package e2.cell;

import e2.Pair;
import e2.cell.type.CellType;

public class FlagCell extends CellImpl{
    public FlagCell(Pair<Integer, Integer> position) {
        super(position, CellType.FLAG_CELL_TYPE);
    }
}
