package e1.actor;

import e1.Pair;

@FunctionalInterface
public interface MovementStrategy {
    boolean canMoveToPosition(Pair<Integer, Integer> currentPosition , Pair<Integer, Integer> nextPosition);
}
