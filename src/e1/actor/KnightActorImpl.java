package e1.actor;

import e1.config.WorldConfig;

public class KnightActorImpl extends AbstractActorImpl{

    public KnightActorImpl(int x, int y, WorldConfig worldConfig) {
        super(x, y, (currentPosition, nextPosition) -> {
            int calcX = nextPosition.getX() - currentPosition.getX();
            int calcY = nextPosition.getY() - currentPosition.getY();
            return calcX!=0 && calcY!=0 && Math.abs(calcX)+Math.abs(calcY)==3;
        }, worldConfig);
    }



}
