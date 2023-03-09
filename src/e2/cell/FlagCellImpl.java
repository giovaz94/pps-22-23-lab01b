package e2.cell;

import e2.Pair;
import e2.cell.type.CellType;

public class FlagCellImpl extends CellImpl{
    public FlagCellImpl(Pair<Integer, Integer> position) {
        super(position, CellType.FLAG_CELL_TYPE);
    }
}
