package e1.config;

import e1.Pair;

public interface WorldConfig {

    int getSize();

    boolean isIn(Pair<Integer, Integer> position);
}
