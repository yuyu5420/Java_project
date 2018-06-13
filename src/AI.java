
import java.awt.Graphics;

public abstract class AI extends Character {

	public AI(Game game, int Xcoordinate, int Ycoordinate, int i) {
		super(game, Xcoordinate, Ycoordinate, i);

	}


	public abstract void render(Graphics g) ;

	@Override
	public void tick() {
		

	}



}
