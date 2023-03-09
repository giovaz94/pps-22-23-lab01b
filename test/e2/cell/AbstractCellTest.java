package e2.cell;

import e1.Pair;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
abstract class AbstractCellTest {

    private Cell cell;

    @Test
    public void testAdjacentCell() {
        final Pair<Integer,Integer> cellPosition = this.getCell().getPosition();
        final List<Pair<Integer,Integer>> adjacentPositions = Stream.of(new Pair<>(-1, -1),
                new Pair<>(-1, 0),
                new Pair<>(-1, 1),
                new Pair<>(0, -1),
                new Pair<>(0, 0),
                new Pair<>(0, 1),
                new Pair<>(1, -1),
                new Pair<>(1, 0),
                new Pair<>(1, 1))
                .map(p -> new Pair<>(cellPosition.getX() + p.getX(), cellPosition.getY() + p.getY()))
                .toList();

        assertEquals(this.getCell().getAdjacentPositions(), adjacentPositions);
    }

    abstract public Cell getCell();
}