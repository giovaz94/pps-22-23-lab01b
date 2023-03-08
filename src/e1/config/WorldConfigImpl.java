package e1.config;

import e1.Pair;
import e1.actor.Actor;
import e1.actor.KnightActorImpl;
import e1.actor.PawnActorImpl;
import e1.config.spawn.SpawnStrategy;

import java.util.Objects;
import java.util.Random;

public class WorldConfigImpl implements WorldConfig {

    private final int size;

    private final Actor pawn;

    private final Actor knight;

    private SpawnStrategy spawnStrategy;

    public WorldConfigImpl(final int size) {
        if(size <= 1) {
            throw new IllegalArgumentException();
        }
        this.size = size;
        this.spawnStrategy = () -> {
            final Random random = new Random();
            Pair<Integer,Integer> pos = new Pair<>(random.nextInt(this.size),random.nextInt(this.size));
            if(Objects.nonNull(this.getPawn()) && this.getPawn().getPosition().equals(pos)) {
                return this.spawnStrategy.spawnElement();
            }
            return pos;
        };

        final Pair<Integer, Integer> pawnPosition = this.spawnStrategy.spawnElement();
        this.pawn = new PawnActorImpl(pawnPosition.getX(), pawnPosition.getY());

        final Pair<Integer, Integer> knightPosition = this.spawnStrategy.spawnElement();
        this.knight = new KnightActorImpl(knightPosition.getX(), knightPosition.getY());
    }

    public WorldConfigImpl(int size, SpawnStrategy spawnStrategy) {
        this.size = size;
        this.spawnStrategy = spawnStrategy;

        final Pair<Integer, Integer> pawnPosition = this.spawnStrategy.spawnElement();
        this.pawn = new PawnActorImpl(pawnPosition.getX(), pawnPosition.getY());
        final Pair<Integer, Integer> knightPosition = this.spawnStrategy.spawnElement();
        this.knight = new KnightActorImpl(knightPosition.getX(), knightPosition.getY());
    }

    public WorldConfigImpl(int size, Pair<Integer, Integer> pawnPosition, Pair<Integer, Integer> knightPosition ) {
        this.size = size;
        this.pawn = new PawnActorImpl(pawnPosition.getX(), pawnPosition.getY());
        this.knight = new KnightActorImpl(knightPosition.getX(), knightPosition.getY());
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isIn(final Pair<Integer, Integer> position) {
        final int x = position.getX();
        final int y = position.getY();
        return !(x < 0 || y < 0 || x >= this.getSize() || y >= this.getSize());
    }

    @Override
    public Actor getPawn() {
        return this.pawn;
    }

    @Override
    public Actor getKnight() {
        return this.knight;
    }

    @Override
    public boolean hasPawn(int row, int col) {
        return this.getPawn().getPosition().equals(new Pair<>(row,col));
    }

    @Override
    public boolean hasKnight(int row, int col) {
        return this.getKnight().getPosition().equals(new Pair<>(row,col));
    }
}
