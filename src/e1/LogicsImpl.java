package e1;

import e1.config.WorldConfig;
import e1.config.WorldConfigImpl;

import java.util.*;

public class LogicsImpl implements Logics {
	
	private final Pair<Integer,Integer> pawn;
	private Pair<Integer,Integer> knight;
	private final Random random = new Random();
	private final int size;
	private final WorldConfig worldConfig;

    public LogicsImpl(int size){
    	this.size = size;
        this.pawn = this.randomEmptyPosition();
        this.knight = this.randomEmptyPosition();
		this.worldConfig = new WorldConfigImpl(size);
    }

	public LogicsImpl(int size, Pair<Integer,Integer> pawn, Pair<Integer, Integer> knight) {
		this.size = size;
		this.pawn = pawn;
		this.knight = knight;
		this.worldConfig = new WorldConfigImpl(size);
	}
    
	private final Pair<Integer,Integer> randomEmptyPosition(){
    	Pair<Integer,Integer> pos = new Pair<>(this.random.nextInt(size),this.random.nextInt(size));
    	// the recursive call below prevents clash with an existing pawn
    	return this.pawn!=null && this.pawn.equals(pos) ? randomEmptyPosition() : pos;
    }
    
	@Override
	public boolean hit(int row, int col) {
		if (!this.worldConfig.isIn(new Pair<>(row, col))) {
			throw new IndexOutOfBoundsException();
		}
		// Below a compact way to express allowed moves for the knight
		int x = row-this.knight.getX();
		int y = col-this.knight.getY();
		if (x!=0 && y!=0 && Math.abs(x)+Math.abs(y)==3) {
			this.knight = new Pair<>(row,col);
			return this.pawn.equals(this.knight);
		}
		return false;
	}

	@Override
	public boolean hasKnight(int row, int col) {
		return this.knight.equals(new Pair<>(row,col));
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.pawn.equals(new Pair<>(row,col));
	}

	@Override
	public Pair<Integer, Integer> getPawn() {
		return new Pair<>(this.pawn.getX(), this.pawn.getY());
	}

	@Override
	public Pair<Integer, Integer> getKnight() {
		return new Pair<>(this.knight.getX(), this.knight.getY());
	}
}
