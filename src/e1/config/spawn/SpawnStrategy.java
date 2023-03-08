package e1.config.spawn;

import e1.Pair;
import e1.config.WorldConfig;

@FunctionalInterface
public interface SpawnStrategy {
    Pair<Integer,Integer> spawnElement();
}
