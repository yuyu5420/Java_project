
import java.awt.Graphics;
import java.awt.event.KeyAdapter;



public abstract class User extends Character {

	private Game game;
	private double time = 100;		// 100 milli second 
	
	public User(Game game, int Xcoordinate, int Ycoordinate) {
		super(game, Xcoordinate, Ycoordinate);
		this.game = game;	
	}

	@Override
	public abstract void render(Graphics g);

	@Override
	public void tick() {	
		
		if(game.getKeyManager().up && this.up_movable) {
			game.getKeyManager().finish = false;
			this.Ycoordinate -= this.pace;
			this.pace_cnt++;
			if(this.Xcoordinate == this.ideal_up[0] && this.Ycoordinate == this.ideal_up[1]) {	
				game.getKeyManager().finish = true;
				this.setIdealLocation();	
			}
		} else if(game.getKeyManager().down && this.down_movable) {
			game.getKeyManager().finish = false;
			this.Ycoordinate += this.pace;
			this.pace_cnt++;
			if(this.Xcoordinate == this.ideal_down[0] && this.Ycoordinate == this.ideal_down[1]) {
				game.getKeyManager().finish = true;
				this.setIdealLocation();
			}
		} else if(game.getKeyManager().left && this.left_movable) {
			game.getKeyManager().finish = false;
			this.Xcoordinate -= this.pace;
			this.pace_cnt++;
			if(this.Xcoordinate == this.ideal_left[0] && this.Ycoordinate == this.ideal_left[1]) {
				game.getKeyManager().finish = true;
				this.setIdealLocation();
			}
		} else if(game.getKeyManager().right && this.right_movable) {
			game.getKeyManager().finish = false;
			this.Xcoordinate += this.pace;
			this.pace_cnt++;
			if(this.Xcoordinate == this.ideal_right[0] && this.Ycoordinate == this.ideal_right[1]) {
				game.getKeyManager().finish = true;
				this.setIdealLocation();

			}
		}
		this.checkfinish(game.getKeyManager().finish);
	}
	
	protected void checkfinish(boolean finish) {
		if(finish) {
			this.game.getKeyManager().up = false;
			this.game.getKeyManager().down = false;
			this.game.getKeyManager().left = false;
			this.game.getKeyManager().right = false;
		}
	}
	


	

}
