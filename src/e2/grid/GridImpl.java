package e2.grid;

import e2.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GridImpl implements Grid {

    private final List<Pair<Integer, Integer>> minesList;
    private final Random random;
    private final int gridSize;


    public GridImpl(final int gridSize, final int minesNumber) {
        this.gridSize = gridSize;
        this.random = new Random();
        this.minesList = new ArrayList<>();
        for(int i = 0; i < minesNumber; i++) {
            this.minesList.add(this.generateRandomPositon());
        }
    }

    @Override
    public List<Pair<Integer, Integer>> getMines() {
        return this.minesList.stream().toList();
    }

    @Override
    public boolean hasMine(Pair<Integer, Integer> position) {
        return this.getMines().contains(position);
    }

    private Pair<Integer,Integer> generateRandomPositon() {
        int x = this.random.nextInt(this.gridSize);
        int y = this.random.nextInt(this.gridSize);
        Pair<Integer, Integer> position = new Pair<>(x, y);
        return this.minesList.contains(position) ? this.generateRandomPositon() : position;
    }
}
