package e2.grid;

import e2.Pair;
import e2.cell.Cell;
import e2.cell.MineCell;
import e2.cell.NormalCell;
import e2.cell.type.CellType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class GridImpl implements Grid {

    private final HashMap<Pair<Integer, Integer>, Cell> grid= new HashMap<>();
    private final Random random;
    private final int gridSize;


    public GridImpl(final int gridSize, final int minesNumber) {
        this.gridSize = gridSize;
        this.random = new Random();
        this.initGrid();
        for(int i = 0; i < minesNumber; i++) {
            Pair<Integer, Integer> position = this.generateRandomPositon();
            this.grid.replace(position, new MineCell(position));
        }
    }

    private void initGrid() {
        for (int i = 0; i < this.gridSize; i++) {
            for (int j = 0; j < this.gridSize; j++) {
                final Cell cell = new NormalCell(new Pair<Integer, Integer>(i,j));
                this.grid.put(cell.getPosition(), cell);
            }
        }
    }

    @Override
    public void click(Pair<Integer, Integer> position) {
        this.grid.get(position).click();
    }

    @Override
    public List<Pair<Integer, Integer>> getMines() {
        return this.grid.values().stream()
                .filter(cell -> cell.getType().equals(CellType.MINE_CELL_TYPE))
                .map(Cell::getPosition)
                .toList();
    }

    @Override
    public boolean hasMine(Pair<Integer, Integer> position) {
        return this.getMines().contains(position);
    }

    @Override
    public boolean isClicked(Pair<Integer, Integer> position) {
        return this.grid.get(position).isClicked();
    }

    private Pair<Integer,Integer> generateRandomPositon() {
        int x = this.random.nextInt(this.gridSize);
        int y = this.random.nextInt(this.gridSize);
        Pair<Integer, Integer> position = new Pair<>(x, y);
        return this.getMines().contains(position) ? this.generateRandomPositon() : position;
    }
}
