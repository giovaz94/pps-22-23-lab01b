package e1.config;

import e1.Pair;
import e1.actor.Actor;
import e1.config.spawn.SpawnStrategy;

public interface WorldConfig {

    int getSize();

    boolean isIn(Pair<Integer, Integer> position);

    Actor getPawn();

    Actor getKnight();
}
