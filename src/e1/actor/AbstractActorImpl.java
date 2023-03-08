package e1.actor;

import e1.Pair;
import e1.config.WorldConfig;

import java.lang.reflect.Parameter;

public class AbstractActorImpl implements Actor {

    private Pair<Integer, Integer> position;

    private final MovementStrategy strategy;

    private final WorldConfig currentWorld;


    public AbstractActorImpl(int x, int y, MovementStrategy movementStrategy, WorldConfig worldConfig) {
        this.strategy = movementStrategy;
        this.position = new Pair<>(x,y);
        this.currentWorld = worldConfig;
    }

    @Override
    public Pair<Integer, Integer> getPosition() {
        return new Pair<>(this.position.getX(), this.position.getY());
    }

    @Override
    public void setPosition(Pair<Integer, Integer> newPosition) {
        if(!this.currentWorld.isIn(newPosition)) {
            throw new IllegalArgumentException();
        }
        this.position = newPosition;
    }

    @Override
    public MovementStrategy getMovementStrategy() {
        return this.strategy;
    }
}
