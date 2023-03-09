package e2;

import e2.logic.Logics;
import e2.logic.LogicsImpl;
import e2.logic.state.StateEnum;
import static e2.logic.state.StateEnum.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LogicsTest {

    public static final int GRID_SIZE = 10;
    public static final int DEFAULT_MINES = 5;

    private Logics logicImpl;

    @BeforeEach
    public void setup() {
        this.logicImpl = new LogicsImpl(GRID_SIZE, DEFAULT_MINES);
    }

    @Test
    public void testInitialState() {
        assertEquals(IN_GAME, this.logicImpl.getStatus());
    }

    @Test
    public void testClick() {
        Random random = new Random();
        Pair<Integer,Integer> noMinePosition;
        Pair<Integer,Integer> minePosition = this.logicImpl.getMines().get(0);
        do {
            noMinePosition = new Pair<>(random.nextInt(GRID_SIZE), random.nextInt(GRID_SIZE));
        } while(this.logicImpl.getMines().contains(noMinePosition));

        this.logicImpl.click(noMinePosition.getX(),noMinePosition.getY());
        assertEquals(IN_GAME, this.logicImpl.getStatus());
        this.logicImpl.click(minePosition.getX(), minePosition.getY());
        assertEquals(GAME_OVER, this.logicImpl.getStatus());
    }
}