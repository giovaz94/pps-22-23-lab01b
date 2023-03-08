package e1.config;

import e1.Pair;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

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
    public void testGetActors() {
        assertNotNull(this.worldConfig.getPawn());
        assertNotNull(this.worldConfig.getKnight());
    }

    @Test
    public void testHasPawn() {
        final Pair<Integer, Integer> pawnPosition = this.worldConfig.getPawn().getPosition();
        assertTrue(this.worldConfig.hasPawn(pawnPosition.getX(), pawnPosition.getY()));
    }

    @Test
    public void testHasKnight() {
        final Pair<Integer, Integer> knightPosition= this.worldConfig.getKnight().getPosition();
        assertTrue(this.worldConfig.hasKnight(knightPosition.getX(), knightPosition.getY()));
    }

    @RepeatedTest(20)
    public void testPositionCollision() {
        assertNotEquals(this.worldConfig.getPawn().getPosition(), this.worldConfig.getKnight().getPosition());
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