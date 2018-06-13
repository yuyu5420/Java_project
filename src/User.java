
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public abstract class User extends Character {

	private Game game;
	
	public User(Game game, int Xcoordinate, int Ycoordinate) {
		super(game, Xcoordinate, Ycoordinate);
		this.game = game;	
	}

	@Override
	public abstract void render(Graphics g);

	@Override

	public void tick() {	
		
		testIdealLocation(game.getKeyManager().state_now);
		if(game.getKeyManager().state_now==KeyEvent.VK_UP && up_movable) {
			if(game.getKeyManager().up) {
				this.Ycoordinate -= pace;
				this.pace_cnt++;
				return;
			} else {		//button release
				check(game.getKeyManager().state_now);
				return;
			}
		} else if(game.getKeyManager().state_now==KeyEvent.VK_DOWN && down_movable) {
			if(game.getKeyManager().down) {
				this.Ycoordinate += pace;
				this.pace_cnt++;
				return;
			} else {
				check(game.getKeyManager().state_now);
				return;
			}
		} else if(game.getKeyManager().state_now==KeyEvent.VK_LEFT && left_movable) {
			if(game.getKeyManager().left) {
				this.Xcoordinate -= pace;
				this.pace_cnt++;
				return;
			} else  {
				check(game.getKeyManager().state_now);
				return;
			}
		} else if(game.getKeyManager().state_now==KeyEvent.VK_RIGHT && right_movable) {
			if(game.getKeyManager().right) {
				this.Xcoordinate += pace;
				this.pace_cnt++;
				return;
			} else {
				check(game.getKeyManager().state_now);
				return;
			}
		} 

			
		}
		this.checkfinish(game.getKeyManager().finish);
	}



	protected void checkfinish(boolean finish) {
		if (finish) {
			this.game.getKeyManager().up = false;
			this.game.getKeyManager().down = false;
			this.game.getKeyManager().left = false;
			this.game.getKeyManager().right = false;
		}
	}

}
