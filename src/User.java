
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

	private void check(int state_now) {
		
		if(ideal_X==this.Xcoordinate && ideal_Y==this.Ycoordinate) {
			game.getKeyManager().state_now = game.getKeyManager().state_next;
			if(game.getKeyManager().state_now!=0) {
				game.getKeyManager().state = game.getKeyManager().state_now;
			}
			return;
		} else {
			if(state_now == KeyEvent.VK_UP || state_now == KeyEvent.VK_DOWN) {
				if(Math.abs((ideal_Y-this.Ycoordinate))==this.pace) {
					if(state_now == KeyEvent.VK_UP) {
						this.Ycoordinate -= this.pace;
					} else {
						this.Ycoordinate += this.pace;
					}
					this.pace_cnt++;
					game.getKeyManager().state_now = game.getKeyManager().state_next;
					if(game.getKeyManager().state_now!=0) {
						game.getKeyManager().state = game.getKeyManager().state_now;
					}
				} else {
					if(state_now == KeyEvent.VK_UP) {
						this.Ycoordinate -= this.pace;
					} else {
						this.Ycoordinate += this.pace;
					}
					this.pace_cnt++;
				}
			} else {
				if(Math.abs((ideal_X-this.Xcoordinate))==this.pace) {
					if(state_now == KeyEvent.VK_LEFT) {
						this.Xcoordinate -= this.pace;
					} else {
						this.Xcoordinate += this.pace;
					}
					this.pace_cnt++;
					game.getKeyManager().state_now = game.getKeyManager().state_next;
					if(game.getKeyManager().state_now!=0) {
						game.getKeyManager().state = game.getKeyManager().state_now;
					}
				} else {
					if(state_now == KeyEvent.VK_LEFT) {
						this.Xcoordinate -= this.pace;
					} else {
						this.Xcoordinate += this.pace;
					}
					this.pace_cnt++;
				}
			}
		}
		

	}
	
	
}
