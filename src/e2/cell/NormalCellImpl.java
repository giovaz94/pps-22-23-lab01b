package e2.cell;

import e2.Pair;
import e2.cell.type.CellType;

public class NormalCellImpl extends CellImpl implements NormalCell{

    public NormalCellImpl(Pair<Integer, Integer> position) {
        super(position, CellType.NORMAL_CELL_TYPE);
    }
}
