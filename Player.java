import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Player extends User {

	
	public Player(int Xcoordinate, int Ycoordinate) {
		super(Xcoordinate, Ycoordinate);

	}

	@Override
	public void render(Graphics g) {		//draw
		g.drawImage(Assets.player1, super.getXcoordinate(), super.getYcoordinate(), DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
	}

	@Override
	public void tick() {		//update variable
		
		
	}
	
}
