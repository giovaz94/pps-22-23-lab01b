package e2.cell;

import e2.Pair;
import e2.cell.type.CellType;

public class NormalCell extends CellImpl{

    public NormalCell(Pair<Integer, Integer> position) {
        super(position, CellType.NORMAL_CELL_TYPE);
    }
}
