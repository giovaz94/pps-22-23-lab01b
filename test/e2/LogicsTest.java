package e2;

import e2.logic.Logics;
import e2.logic.LogicsImpl;
import static e2.logic.state.StateEnum.*;

import e2.logic.state.StateEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
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

    @Test
    public void testVictory() {
        List<Pair<Integer, Integer>> minesPosition = this.logicImpl.getMines();
        for(int i = 0; i < GRID_SIZE; i++){
            for (int j = 0; j < GRID_SIZE; j++) {
                Pair<Integer, Integer> position = new Pair<>(i, j);
                if(!minesPosition.contains(position)) {
                    this.logicImpl.click(position.getX(), position.getY());
                }
            }
        }
        assertEquals(WIN, this.logicImpl.getStatus());
    }

    @Test
    public void testVictoryByFlagPlacing() {
        this.logicImpl.getMines().forEach(p -> this.logicImpl.placeFlag(p));
        assertEquals(WIN, this.logicImpl.getStatus());
    }
}