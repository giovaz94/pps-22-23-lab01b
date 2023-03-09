package e2.cell;

import e2.Pair;
import e2.cell.type.CellType;

public class MineCellImpl extends CellImpl {

    public MineCellImpl(Pair<Integer, Integer> position) {
        super(position, CellType.MINE_CELL_TYPE);
    }

    @Override
    public boolean isClicked() {
        return false;
    }
}
