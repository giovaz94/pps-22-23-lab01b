package e2;

import e2.logic.Logics;
import e2.logic.LogicsImpl;
import org.junit.jupiter.api.BeforeEach;

class LogicsTest {

    public static final int GRID_SIZE = 10;
    public static final int DEFAULT_MINES = 5;

    private Logics logicImpl;

    @BeforeEach
    public void setup() {
        this.logicImpl = new LogicsImpl(GRID_SIZE, DEFAULT_MINES);
    }

}