
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
			this.Ycoordinate -= DEFAULT_PACE;
			if(this.Xcoordinate == this.ideal_up[0] && this.Ycoordinate == this.ideal_up[1]) {
				game.getKeyManager().up = false;
				this.setIdealLocation();
			}
		} else if(game.getKeyManager().down && this.down_movable) {
			this.Ycoordinate += DEFAULT_PACE;
			if(this.Xcoordinate == this.ideal_down[0] && this.Ycoordinate == this.ideal_down[1]) {
				game.getKeyManager().down = false;
				this.setIdealLocation();
			}
		} else if(game.getKeyManager().left && this.left_movable) {
			this.Xcoordinate -= DEFAULT_PACE;
			if(this.Xcoordinate == this.ideal_left[0] && this.Ycoordinate == this.ideal_left[1]) {
				game.getKeyManager().left = false;
				this.setIdealLocation();
			}
		} else if(game.getKeyManager().right && this.right_movable) {
			this.Xcoordinate += DEFAULT_PACE;
			System.out.println(this.Xcoordinate + " " + this.Ycoordinate);
			if(this.Xcoordinate == this.ideal_right[0] && this.Ycoordinate == this.ideal_right[1]) {
				game.getKeyManager().right = false;
				this.setIdealLocation();
//				System.out.println(this.ideal_left[0] + " " + this.ideal_left[1]);
//				System.out.println(this.left_movable);
			}
		}
	
	}
	


	

}
