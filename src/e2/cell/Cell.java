package e2.cell;

import e2.Pair;
import e2.cell.type.CellType;

import java.util.List;

public interface Cell {

    void click();

    void flag();

    List<Pair<Integer,Integer>> getAdjacentPositions();

    Pair<Integer, Integer> getPosition();

    CellType getType();

    boolean isClicked();

    boolean isFlagged();
}
