package e1.config;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class WorldConfigTest {


    private WorldConfig worldConfig;

    @BeforeEach
    public void setup() {
        this.worldConfig = new WorldConfigImpl(5);
    }


}