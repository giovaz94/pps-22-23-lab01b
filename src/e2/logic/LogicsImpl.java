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
        final Pair<Integer,Integer> clickedPosition = new Pair<>(x,y);
        this.grid.click(clickedPosition);
        if (this.grid.hasMine(clickedPosition)) {
            this.gameStatus = GAME_OVER;
        }
    }

    @Override
    public StateEnum getStatus() {
        return this.gameStatus;
    }

    @Override
    public List<Pair<Integer, Integer>> getMines() {
        return this.grid.getMines();
    }

    @Override
    public boolean isClicked(Pair<Integer, Integer> position) {
        return this.grid.isClicked(position);
    }

    @Override
    public boolean placeFlag(Pair<Integer, Integer> position) {
        return this.grid.placeFlag(position);
    }

    @Override
    public int numberOfAdjacentMines(Pair<Integer, Integer> position) {
        return this.grid.numberOfAdjacentMines(position);
    }
}
