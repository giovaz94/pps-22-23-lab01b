package e1.actor;

import e1.Pair;

public interface Actor {
    Pair<Integer, Integer> getPosition();
    void move(Pair<Integer, Integer> x);
}
