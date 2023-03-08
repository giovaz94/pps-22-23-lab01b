package e1;

import e1.actor.Actor;
import e1.actor.KnightActorImpl;
import e1.actor.PawnActorImpl;
import e1.config.WorldConfig;
import e1.config.WorldConfigImpl;

import java.util.*;

public class LogicsImpl implements Logics {
	
	private final Actor pawn;
	private Actor knight;
	private final Random random = new Random();
	private final int size;
	private final WorldConfig worldConfig;

    public LogicsImpl(int size){
    	this.size = size;
		this.worldConfig = new WorldConfigImpl(size);
		final Pair<Integer, Integer> pawnPosition = this.randomEmptyPosition();
		final Pair<Integer, Integer> knightPosition = this.randomEmptyPosition();

        this.pawn = new PawnActorImpl(pawnPosition.getX(), pawnPosition.getY());
        this.knight = new KnightActorImpl(knightPosition.getX(), knightPosition.getY());
    }

	public LogicsImpl(int size, Pair<Integer, Integer> pawnPosition, Pair<Integer, Integer> knightPosition) {
		this.size = size;
		this.worldConfig = new WorldConfigImpl(size);
		this.pawn = new PawnActorImpl(pawnPosition.getX(), pawnPosition.getY());
		this.knight = new KnightActorImpl(knightPosition.getX(), knightPosition.getY());

	}
    
	private final Pair<Integer,Integer> randomEmptyPosition(){
    	Pair<Integer,Integer> pos = new Pair<>(this.random.nextInt(size),this.random.nextInt(size));
    	// the recursive call below prevents clash with an existing pawn
    	return this.pawn!=null && this.pawn.getPosition().equals(pos) ? randomEmptyPosition() : pos;
    }
    
	@Override
	public boolean hit(int row, int col) {
		if (!this.worldConfig.isIn(new Pair<>(row, col))) {
			throw new IndexOutOfBoundsException();
		}

		this.knight.move(new Pair<>(row, col));
		return this.pawn.getPosition().equals(this.knight.getPosition());
	}

	@Override
	public boolean hasKnight(int row, int col) {
		return this.knight.getPosition().equals(new Pair<>(row,col));
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.pawn.getPosition().equals(new Pair<>(row,col));
	}

	@Override
	public Pair<Integer, Integer> getPawn() {
		return this.pawn.getPosition();
	}

	@Override
	public Pair<Integer, Integer> getKnight() {
		return this.knight.getPosition();
	}
}
