package e1.actor;

public class PawnActorImpl extends ActorImpl {
    public PawnActorImpl(int x, int y) {
        super(x, y, (currentPosition, nextPosition) -> false);
    }
}
