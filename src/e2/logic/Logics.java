package e2.logic;


import e2.Pair;
import e2.logic.state.StateEnum;

import java.util.List;

public interface Logics {
    void click(int x, int y);

    StateEnum getStatus();

    List<Pair<Integer,Integer>> getMines();

    boolean isClicked(Pair<Integer, Integer> position);

    boolean placeFlag(Pair<Integer, Integer> position);

    int numberOfAdjacentMines(Pair<Integer, Integer> position);
}
