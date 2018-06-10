
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
			this.Ycoordinate -= DEFAULT_PACE;
			if(this.Xcoordinate == this.ideal_up[0] && this.Ycoordinate == this.ideal_up[1]) {	
				game.getKeyManager().up = false;
				this.setIdealLocation();
				game.getKeyManager().finish = true;
			}
		} else if(game.getKeyManager().down && this.down_movable) {
			game.getKeyManager().finish = false;
			this.Ycoordinate += DEFAULT_PACE;
			if(this.Xcoordinate == this.ideal_down[0] && this.Ycoordinate == this.ideal_down[1]) {
				game.getKeyManager().down = false;
				this.setIdealLocation();
				game.getKeyManager().finish = true;
			}
		} else if(game.getKeyManager().left && this.left_movable) {
			game.getKeyManager().finish = false;
			this.Xcoordinate -= DEFAULT_PACE;
			if(this.Xcoordinate == this.ideal_left[0] && this.Ycoordinate == this.ideal_left[1]) {
				game.getKeyManager().finish = true;
				game.getKeyManager().left = false;
				this.setIdealLocation();
			}
		} else if(game.getKeyManager().right && this.right_movable) {
			game.getKeyManager().finish = false;
			this.Xcoordinate += DEFAULT_PACE;
			System.out.println(this.Xcoordinate + " " + this.Ycoordinate);
			if(this.Xcoordinate == this.ideal_right[0] && this.Ycoordinate == this.ideal_right[1]) {
				game.getKeyManager().finish = true;
				game.getKeyManager().right = false;
				this.setIdealLocation();

			}
		}
	
	}
	


	

}
