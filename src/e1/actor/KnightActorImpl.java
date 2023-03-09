package e1.actor;

public class KnightActorImpl extends ActorImpl {

    public KnightActorImpl(int x, int y) {
        super(x, y, (currentPosition, nextPosition) -> {
            int calcX = nextPosition.getX() - currentPosition.getX();
            int calcY = nextPosition.getY() - currentPosition.getY();
            return calcX!=0 && calcY!=0 && Math.abs(calcX)+Math.abs(calcY)==3;
        });
    }



}
