package e1.actor;

import e1.config.WorldConfig;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
abstract class AbstractActorTest {

    abstract public Actor getActor();

    @Test
    public void testInitialState() {
        assertNotNull(this.getActor().getMovementStrategy());
        assertNotNull(this.getActor().getPosition());
    }

}