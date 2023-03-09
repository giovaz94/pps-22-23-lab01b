package e2.grid;

import e2.Pair;

import java.util.List;

public interface Grid {
    void click(Pair<Integer, Integer> position);

    List<Pair<Integer, Integer>> getMines();

    boolean hasMine(Pair<Integer, Integer> position);

    boolean isClicked(Pair<Integer, Integer> position);

    int numberOfAdjacentMines(Pair<Integer, Integer> position);
}
