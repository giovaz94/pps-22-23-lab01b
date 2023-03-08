package e1.config;

import e1.Pair;
import e1.actor.Actor;
import e1.actor.KnightActorImpl;
import e1.actor.PawnActorImpl;
import e1.config.spawn.SpawnStrategy;

import java.util.Objects;
import java.util.Random;

public class WorldConfigImpl implements WorldConfig {

    public static final int SIZE_LIMIT = 1;
    private int size;

    private Actor pawn;

    private Actor knight;

    private SpawnStrategy spawnStrategy;

    public WorldConfigImpl(int size, Pair<Integer, Integer> pawnPosition, Pair<Integer, Integer> knightPosition ) {
        this.setSize(size);
        this.setPawn(pawnPosition);
        this.setKnight(knightPosition);
    }

    public WorldConfigImpl(int size, SpawnStrategy spawnStrategy) {
        this.setSize(size);
        this.spawnStrategy = spawnStrategy;
        this.setPawn(this.spawnStrategy.spawnElement());
        this.setKnight(this.spawnStrategy.spawnElement());
    }


    public WorldConfigImpl(final int size) {
        this.setSize(size);
        this.spawnStrategy = () -> {
            final Random random = new Random();
            Pair<Integer,Integer> pos = new Pair<>(random.nextInt(this.size),random.nextInt(this.size));
            if(Objects.nonNull(this.getPawn()) && this.getPawn().getPosition().equals(pos)) {
                return this.spawnStrategy.spawnElement();
            }
            return pos;
        };
        this.setPawn(this.spawnStrategy.spawnElement());
        this.setKnight(this.spawnStrategy.spawnElement());
    }


    private void setSize(int size) {
        if(size <= SIZE_LIMIT) {
            throw new IllegalArgumentException();
        }
        this.size = size;
    }

    private void setPawn(Pair<Integer, Integer> pawnPosition) {
        if(!this.isIn(pawnPosition)) {
            throw new IllegalArgumentException();
        }
        this.pawn = new PawnActorImpl(pawnPosition.getX(), pawnPosition.getY());
    }

    private void setKnight(Pair<Integer, Integer> knightPosition) {
        if(!this.isIn(knightPosition)) {
            throw new IllegalArgumentException();
        }
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
