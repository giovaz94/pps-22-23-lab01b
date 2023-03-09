package e2.logic;

import e2.Pair;
import e2.grid.Grid;
import e2.grid.GridImpl;
import e2.logic.state.StateEnum;

import java.util.List;

import static e2.logic.state.StateEnum.*;

public class LogicsImpl implements Logics {

    private StateEnum gameStatus;

    private Grid grid;

    public LogicsImpl(int size, int minesNumber) {
        this.gameStatus = IN_GAME;
        this.grid = new GridImpl(size, minesNumber);
    }

    @Override
    public void click(int x, int y) {
        this.gameStatus = GAME_OVER;
    }

    @Override
    public StateEnum getStatus() {
        return this.gameStatus;
    }

    @Override
    public List<Pair<Integer, Integer>> getMines() {
        return this.grid.getMines();
    }
}
