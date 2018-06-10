
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Player extends User {
	
	private int index;
	
	public Player(Game game, int Xcoordinate, int Ycoordinate) {
		super(game, Xcoordinate, Ycoordinate);
	}

	@Override
	public void render(Graphics g) {		//draw
		if(this.pace_cnt==2) {
			g.drawImage(Assets.cowboys[2], this.Xcoordinate, this.Ycoordinate, DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
		} else {
			g.drawImage(Assets.cowboys[this.pace_cnt%2], this.Xcoordinate, this.Ycoordinate, DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
		}

		
	}





	

}
