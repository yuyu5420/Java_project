
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Player extends User {
	private Game game;
	
	public Player(Game game, int Xcoordinate, int Ycoordinate) {
		super(game, Xcoordinate, Ycoordinate);
		this.game = game;
	}

	@Override
	public void render(Graphics g) { // draw
		
		if (this.pace_cnt == 0) {
			g.drawImage(Assets.blue_down[0], this.Xcoordinate, this.Ycoordinate, DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
		} else {
			if (game.getKeyManager().state == KeyEvent.VK_UP) {
				g.drawImage(Assets.blue_up[pace_cnt % 2], this.Xcoordinate, this.Ycoordinate, DEFAULT_WIDTH,
						DEFAULT_HEIGHT, null);
			} else if (game.getKeyManager().state == KeyEvent.VK_DOWN) {
				g.drawImage(Assets.blue_down[pace_cnt % 2], this.Xcoordinate, this.Ycoordinate, DEFAULT_WIDTH,
						DEFAULT_HEIGHT, null);
			} else if (game.getKeyManager().state == KeyEvent.VK_LEFT) {
				g.drawImage(Assets.blue_left[pace_cnt % 2], this.Xcoordinate, this.Ycoordinate, DEFAULT_WIDTH,
						DEFAULT_HEIGHT, null);
			} else if (game.getKeyManager().state == KeyEvent.VK_RIGHT) {
				g.drawImage(Assets.blue_right[pace_cnt % 2], this.Xcoordinate, this.Ycoordinate, DEFAULT_WIDTH,
						DEFAULT_HEIGHT, null);
			}
		}

	}

}
