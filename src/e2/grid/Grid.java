package e2.grid;

import e2.Pair;
import e2.cell.Cell;
import e2.cell.NormalCell;

import java.util.List;

public interface Grid {
    void click(Pair<Integer, Integer> position);

    Cell getCell(Pair<Integer, Integer> position);

    List<Pair<Integer, Integer>> getMines();

    boolean hasMine(Pair<Integer, Integer> position);

    boolean isClicked(Pair<Integer, Integer> position);

    int numberOfAdjacentMines(Pair<Integer, Integer> position);

    boolean placeFlag(Pair<Integer, Integer> position);
}
