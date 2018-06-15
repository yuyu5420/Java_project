
import java.awt.Graphics;


public class Player extends User {
	
	private Game game;
	
	public Player(Game game, int Xcoordinate, int Ycoordinate) {
		super(Xcoordinate, Ycoordinate);
		this.game = game;
	}

	@Override
	public void render(Graphics g) { // draw
	
		if (this.pace_cnt == 0) {
			if(ID==1)
				g.drawImage(Assets.blue_down[0], this.Xcoordinate, this.Ycoordinate, DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
			else if(ID==2)
				g.drawImage(Assets.black_down[0], this.Xcoordinate, this.Ycoordinate, DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
		} else {
			if (state == up_key) {
				if(ID==1) 
					g.drawImage(Assets.blue_up[pace_cnt % 2], this.Xcoordinate, this.Ycoordinate, DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
				else if(ID==2)
					g.drawImage(Assets.black_up[pace_cnt % 2], this.Xcoordinate, this.Ycoordinate, DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
			} else if (state == down_key) {
				if(ID==1) 
					g.drawImage(Assets.blue_down[pace_cnt % 2], this.Xcoordinate, this.Ycoordinate, DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
				else if(ID==2)
					g.drawImage(Assets.black_down[pace_cnt % 2], this.Xcoordinate, this.Ycoordinate, DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
			} else if (state == left_key) {
				if(ID==1) 
					g.drawImage(Assets.blue_left[pace_cnt % 2], this.Xcoordinate, this.Ycoordinate, DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
				else if(ID==2)
					g.drawImage(Assets.black_left[pace_cnt % 2], this.Xcoordinate, this.Ycoordinate, DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
			} else if (state == right_key) {
				if(ID==1) 
					g.drawImage(Assets.blue_right[pace_cnt % 2], this.Xcoordinate, this.Ycoordinate, DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
				else if(ID==2)
					g.drawImage(Assets.black_right[pace_cnt % 2], this.Xcoordinate, this.Ycoordinate, DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
			}
		}

	}

}
