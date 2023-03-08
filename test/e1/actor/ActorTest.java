package e1.actor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
abstract class ActorTest {

    abstract Actor getActor();

    @Test
    public void getPosition() {
        assertNotNull(this.getActor().getPosition());
    }

}