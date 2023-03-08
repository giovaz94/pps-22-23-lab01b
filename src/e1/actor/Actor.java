package e1.actor;

import e1.Pair;

public interface Actor {
    Pair<Integer, Integer> getPosition();

    void setPosition(Pair<Integer, Integer> newPosition);

    MovementStrategy getMovementStrategy();

    default void move(Pair<Integer, Integer> newPosition) {
        if (this.getMovementStrategy().canMoveToPosition(this.getPosition(), newPosition)) {
            this.setPosition(newPosition);
        }
    }
}
