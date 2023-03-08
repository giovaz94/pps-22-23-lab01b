package e1.actor;

import e1.config.WorldConfig;

public class PawnActorImpl extends AbstractActorImpl{
    public PawnActorImpl(int x, int y, WorldConfig worldConfig) {
        super(x, y, (currentPosition, nextPosition) -> false, worldConfig);
    }
}
