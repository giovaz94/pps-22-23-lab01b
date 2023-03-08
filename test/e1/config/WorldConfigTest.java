package e1.config;

import e1.Pair;
import e1.config.spawn.SpawnStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

class WorldConfigTest {


    public static final int WORLD_SIZE = 5;
    public static final int INVALID_WORLD_SIZE = 1;
    private WorldConfig worldConfig;

    @BeforeEach
    public void setup() {
        this.worldConfig = new WorldConfigImpl(WORLD_SIZE);
    }

    @Test
    public void testInvalidWorldSize() {
        assertThrows(IllegalArgumentException.class, () -> new WorldConfigImpl(INVALID_WORLD_SIZE));
    }

    @Test
    public void testGetSize() {
        assertEquals(WORLD_SIZE, this.worldConfig.getSize());
    }

    @Test
    public void testPositions() {
        final Pair<Integer, Integer> outOfBoundPosition = new Pair<>(-1, -1);
        final Pair<Integer, Integer> insideGridPosition = new Pair<>(2, 2);
        assertFalse(this.worldConfig.isIn(outOfBoundPosition));
        assertTrue(this.worldConfig.isIn(insideGridPosition));
    }
}