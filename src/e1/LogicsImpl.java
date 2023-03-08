package e1;

import e1.actor.Actor;
import e1.actor.KnightActorImpl;
import e1.actor.PawnActorImpl;
import e1.config.WorldConfig;
import e1.config.WorldConfigImpl;

import java.util.*;

public class LogicsImpl implements Logics {

	private final WorldConfig worldConfig;

    public LogicsImpl(int size){
		this.worldConfig = new WorldConfigImpl(size);
    }

	public LogicsImpl(int size, Pair<Integer, Integer> pawnPosition, Pair<Integer, Integer> knightPosition) {
		this.worldConfig = new WorldConfigImpl(size, pawnPosition, knightPosition);
	}

	@Override
	public boolean hit(int row, int col) {
		if (!this.worldConfig.isIn(new Pair<>(row, col))) {
			throw new IndexOutOfBoundsException();
		}
		this.worldConfig.getKnight().move(new Pair<>(row, col));
		return this.worldConfig.getPawn().getPosition().equals(this.worldConfig.getKnight().getPosition());
	}

	@Override
	public boolean hasKnight(int row, int col) {
		return this.worldConfig.hasKnight(row, col);
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.worldConfig.hasPawn(row, col);
	}

	@Override
	public Pair<Integer, Integer> getPawn() {
		return this.worldConfig.getPawn().getPosition();
	}

	@Override
	public Pair<Integer, Integer> getKnight() {
		return this.worldConfig.getKnight().getPosition();
	}
}
