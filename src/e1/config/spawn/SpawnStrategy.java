package e1.config.spawn;

import e1.Pair;

@FunctionalInterface
public interface SpawnStrategy {
    Pair<Integer,Integer> spawnElement();
}
