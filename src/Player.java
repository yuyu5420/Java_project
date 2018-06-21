
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Player extends User {
	

	
	public Player(Game game, double Xcoordinate, double Ycoordinate) {
		super(Xcoordinate, Ycoordinate);

	}

	@Override
	public void render(Graphics g) { // draw
	
		if (this.pace_cnt == 0) {
			if(ID==1)
				g.drawImage(Assets.blue_down[0], (int)this.Xcoordinate, (int)this.Ycoordinate, DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
			else if(ID==2)
				g.drawImage(Assets.black_down[0], (int)this.Xcoordinate, (int)this.Ycoordinate, DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
		} else {
			if (state == up_key) {
				if(ID==1) 
					g.drawImage(Assets.blue_up[pace_cnt % 2], (int)this.Xcoordinate, (int)this.Ycoordinate, DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
				else if(ID==2)
					g.drawImage(Assets.black_up[pace_cnt % 2], (int)this.Xcoordinate, (int)this.Ycoordinate, DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
			} else if (state == down_key) {
				if(ID==1) 
					g.drawImage(Assets.blue_down[pace_cnt % 2], (int)this.Xcoordinate, (int)this.Ycoordinate, DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
				else if(ID==2)
					g.drawImage(Assets.black_down[pace_cnt % 2], (int)this.Xcoordinate, (int)this.Ycoordinate, DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
			} else if (state == left_key) {
				if(ID==1) 
					g.drawImage(Assets.blue_left[pace_cnt % 2], (int)this.Xcoordinate, (int)this.Ycoordinate, DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
				else if(ID==2)
					g.drawImage(Assets.black_left[pace_cnt % 2], (int)this.Xcoordinate, (int)this.Ycoordinate, DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
			} else if (state == right_key) {
				if(ID==1) 
					g.drawImage(Assets.blue_right[pace_cnt % 2], (int)this.Xcoordinate, (int)this.Ycoordinate, DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
				else if(ID==2)
					g.drawImage(Assets.black_right[pace_cnt % 2], (int)this.Xcoordinate, (int)this.Ycoordinate, DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
			}
		}

	}

}
