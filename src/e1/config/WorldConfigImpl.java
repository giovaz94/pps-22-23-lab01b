package e1.config;

import e1.Pair;

public class WorldConfigImpl implements WorldConfig {

    private final int size;

    public WorldConfigImpl(final int size) {
        if(size <= 1) {
            throw new IllegalArgumentException();
        }
        this.size = size;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isIn(final Pair<Integer, Integer> position) {
        return !(position.getX() < 0 || position.getY() < 0 || position.getX() >= this.getSize() || position.getY() >= this.getSize());
    }


}
