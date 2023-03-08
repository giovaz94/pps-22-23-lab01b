package e1.actor;

import e1.Pair;
import e1.config.WorldConfig;
import e1.config.WorldConfigImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PawnActorImplTest extends AbstractActorTest {

    public static final int WORLD_SIZE = 5;
    private Actor actor;

    private WorldConfig worldConfig;

    @BeforeEach
    public void setup() {
        this.worldConfig = new WorldConfigImpl(WORLD_SIZE);
        this.actor = new PawnActorImpl(WORLD_SIZE / 2 , WORLD_SIZE / 2, this.worldConfig);
    }

    @Test
    public void testMovement() {
        final Pair<Integer, Integer> movement = new Pair<>(0,3);
        this.getActor().move(movement);
        assertNotEquals(movement, this.getActor().getPosition());
    }


    @Override
    public Actor getActor() {
        return this.actor;
    }

    @Override
    public WorldConfig getWorldConfig() {
        return this.worldConfig;
    }
}