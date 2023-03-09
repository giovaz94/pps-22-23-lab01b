package e1.actor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
abstract class ActorTest {

    abstract public Actor getActor();

    @Test
    public void testInitialState() {
        assertNotNull(this.getActor().getMovementStrategy());
        assertNotNull(this.getActor().getPosition());
    }

}