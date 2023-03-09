package e1.actor;

import e1.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KnightActorImplTest extends ActorTest {


    public static final int WORLD_SIZE = 5;
    private Actor actor;

    @BeforeEach
    public void setup() {
        this.actor = new KnightActorImpl(WORLD_SIZE / 2 , WORLD_SIZE / 2);
    }

    @Test
    public void testMovement() {
        final Pair<Integer, Integer> allowedMovement = new Pair<>(0,3);
        final Pair<Integer, Integer> invalidMovement = new Pair<>(0, 2);
        this.getActor().move(allowedMovement);
        this.getActor().move(invalidMovement);
        assertEquals(allowedMovement, this.getActor().getPosition());
    }

    @Override
    public Actor getActor() {
        return this.actor;
    }
}