package e2.grid;

import e2.Pair;

import java.util.List;

public interface Grid {
    List<Pair<Integer, Integer>> getMines();

    boolean hasMine(Pair<Integer, Integer> position);
}
