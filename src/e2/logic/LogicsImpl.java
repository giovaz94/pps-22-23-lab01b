package e2.logic;

import e2.logic.state.StateEnum;
import static e2.logic.state.StateEnum.*;

public class LogicsImpl implements Logics {

    private StateEnum gameStatus;

    public LogicsImpl(int size, int minesNumber) {
        this.gameStatus = IN_GAME;
    }

    @Override
    public void click(int x, int y) {
        this.gameStatus = GAME_OVER;
    }

    @Override
    public StateEnum getStatus() {
        return this.gameStatus;
    }
}
