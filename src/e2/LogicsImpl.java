package e2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LogicsImpl implements Logics {

    private final List<Pair<Integer, Integer>> minesList;

    private final Random random;

    private final int gridSize;

    public LogicsImpl(int size, int minesNumber) {
        this.gridSize = size;
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

    private Pair<Integer,Integer> generateRandomPositon() {
        int x = this.random.nextInt(this.gridSize);
        int y = this.random.nextInt(this.gridSize);
        Pair<Integer, Integer> position = new Pair<>(x, y);
        return this.minesList.contains(position) ? this.generateRandomPositon() : position;
    }
}
