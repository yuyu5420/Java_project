import java.awt.Graphics;

public class Player extends User {

	public Player(int Xcoordinate, int Ycoordinate) {
		super(Xcoordinate, Ycoordinate);
		
	}

	@Override
	public void render(Graphics g) {		//draw
		g.drawImage(Assets.player1, super.getXcoordinate(), super.getYcoordinate(), null);
	}

	@Override
	public void tick() {		//update variable
		
		
	}

}
