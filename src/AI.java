
import java.awt.Graphics;

public abstract class AI extends Character {

	public AI(Game game, int Xcoordinate, int Ycoordinate) {
		super(game, Xcoordinate, Ycoordinate);

	}

	@Override
	public abstract void render(Graphics g) ;

	@Override
	public void tick() {
		

	}


}
