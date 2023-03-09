package e2.cell;

import e2.Pair;
import e2.cell.type.CellType;

import java.util.List;
import java.util.stream.Stream;

public class CellImpl implements Cell {

    final Pair<Integer, Integer> position;

    final CellType cellType;

    public CellImpl(Pair<Integer, Integer> position, CellType type) {
        this.position = position;
        this.cellType = type;
    }

    @Override
    public List<Pair<Integer, Integer>> getAdjacentPositions() {
        return Stream.of(new Pair<>(-1, -1),
                new Pair<>(-1, 0),
                new Pair<>(-1, 1),
                new Pair<>(0, -1),
                new Pair<>(0, 0),
                new Pair<>(0, 1),
                new Pair<>(1, -1),
                new Pair<>(1, 0),
                new Pair<>(1, 1))
        .map(p -> new Pair<>(this.getPosition().getX() + p.getX(), this.getPosition().getY() + p.getY()))
        .toList();
    }

    @Override
    public Pair<Integer, Integer> getPosition() {
        return new Pair<>(this.position.getX(), this.position.getY());
    }

    @Override
    public CellType getType() {
        return this.cellType;
    }
}
