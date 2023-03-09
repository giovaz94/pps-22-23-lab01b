package e2;

import e2.logic.Logics;
import e2.logic.LogicsImpl;
import e2.logic.state.StateEnum;
import static e2.logic.state.StateEnum.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        this.logicImpl.click(1,1);
        assertEquals(GAME_OVER, this.logicImpl.getStatus());
    }

}