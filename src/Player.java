
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Player extends User {
	

	public Player(int Xcoordinate, int Ycoordinate) {
		super(Xcoordinate, Ycoordinate);

	}

	@Override
	public void render(Graphics g) { // draw
	
		if (this.pace_cnt == 0) {
			if(ID==1) {	// blue
				g.drawImage(Assets.blue_down[0], (int)this.Xcoordinate, (int)this.Ycoordinate, DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
			} else if(ID==2)	{	// green
				g.drawImage(Assets.green_down[0], (int)this.Xcoordinate, (int)this.Ycoordinate, DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
			} else if(ID==3) {	// purple
				g.drawImage(Assets.purple_down[0], (int)this.Xcoordinate, (int)this.Ycoordinate, DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
			} else if(ID==4)	{	// black
				g.drawImage(Assets.black_down[0], (int)this.Xcoordinate, (int)this.Ycoordinate, DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
			}
		} else {
			if(ID==1) {
				if(state == up_key) {
					g.drawImage(Assets.blue_up[(pace_cnt%8) / 4], (int)this.Xcoordinate, (int)this.Ycoordinate, DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
				} else if(state == down_key) {
					g.drawImage(Assets.blue_down[(pace_cnt%8) / 4], (int)this.Xcoordinate, (int)this.Ycoordinate, DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
				} else if(state == left_key) {
					g.drawImage(Assets.blue_left[(pace_cnt%8) / 4], (int)this.Xcoordinate, (int)this.Ycoordinate, DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
				} else if(state == right_key) {
					g.drawImage(Assets.blue_right[(pace_cnt%8) / 4], (int)this.Xcoordinate, (int)this.Ycoordinate, DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
				}
				return;
			} else if(ID==2) {	// green
				if(state == up_key) {
					g.drawImage(Assets.green_up[(pace_cnt%8) / 4], (int)this.Xcoordinate, (int)this.Ycoordinate, DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
				} else if(state == down_key) {
					g.drawImage(Assets.green_down[(pace_cnt%8) / 4], (int)this.Xcoordinate, (int)this.Ycoordinate, DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
				} else if(state == left_key) {
					g.drawImage(Assets.green_left[(pace_cnt%8) / 4], (int)this.Xcoordinate, (int)this.Ycoordinate, DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
				} else if(state == right_key) {
					g.drawImage(Assets.green_right[(pace_cnt%8) / 4], (int)this.Xcoordinate, (int)this.Ycoordinate, DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
				}
				return;
			} else if(ID==3) {	// purple
				if(state == up_key) {
					g.drawImage(Assets.purple_up[(pace_cnt%8) / 4], (int)this.Xcoordinate, (int)this.Ycoordinate, DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
				} else if(state == down_key) {
					g.drawImage(Assets.purple_down[(pace_cnt%8) / 4], (int)this.Xcoordinate, (int)this.Ycoordinate, DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
				} else if(state == left_key) {
					g.drawImage(Assets.purple_left[(pace_cnt%8) / 4], (int)this.Xcoordinate, (int)this.Ycoordinate, DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
				} else if(state == right_key) {
					g.drawImage(Assets.purple_right[(pace_cnt%8) / 4], (int)this.Xcoordinate, (int)this.Ycoordinate, DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
				}
				return;
			} else if(ID==4) {	// black
				if(state == up_key) {
					g.drawImage(Assets.black_up[(pace_cnt%8) / 4], (int)this.Xcoordinate, (int)this.Ycoordinate, DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
				} else if(state == down_key) {
					g.drawImage(Assets.black_down[(pace_cnt%8) / 4], (int)this.Xcoordinate, (int)this.Ycoordinate, DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
				} else if(state == left_key) {
					g.drawImage(Assets.black_left[(pace_cnt%8) / 4], (int)this.Xcoordinate, (int)this.Ycoordinate, DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
				} else if(state == right_key) {
					g.drawImage(Assets.black_right[(pace_cnt%8) / 4], (int)this.Xcoordinate, (int)this.Ycoordinate, DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
				}
				return;
			}
			
			
			
		}

	}

}
