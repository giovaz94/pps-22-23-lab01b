package e2.cell;

import e2.Pair;

import java.util.List;

public interface NormalCell extends Cell{

    default List<Pair<Integer,Integer>> getAdjacentMines(List<Pair<Integer, Integer>> mines) {
        return this.getAdjacentPositions()
                .stream()
                .filter(mines::contains)
                .toList();
    }

    default int numberOfAdjacentMines(List<Pair<Integer, Integer>> mines) {
        return this.getAdjacentMines(mines).size();
    }
}
