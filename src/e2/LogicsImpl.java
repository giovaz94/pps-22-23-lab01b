package e2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class LogicsImpl implements Logics {

    private final List<Pair<Integer, Integer>> minesList;

    public LogicsImpl(int size, int minesNumber) {
        this.minesList = new ArrayList<>();
        for(int i = 0; i < minesNumber; i++) {
            this.minesList.add(new Pair<>(i, i));
        }
    }

    @Override
    public List<Pair<Integer, Integer>> getMines() {
        return this.minesList.stream().toList();
    }
}
