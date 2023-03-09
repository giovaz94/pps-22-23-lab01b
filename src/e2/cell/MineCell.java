package e2.cell;

import e1.Pair;
import e2.cell.type.CellType;

public class MineCell extends CellImpl {

    public MineCell(Pair<Integer, Integer> position) {
        super(position, CellType.MINE_CELL_TYPE);
    }
}
