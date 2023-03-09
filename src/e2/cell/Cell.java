package e2.cell;

import e1.Pair;
import e2.cell.type.CellType;

import java.util.List;

public interface Cell {

    List<Pair<Integer,Integer>> getAdjacentPositions();

    Pair<Integer, Integer> getPosition();

    CellType getType();
}
