
import java.awt.Graphics;


public abstract class User extends Character {

	protected Game game;
	private double time = 100; // 100 milli second

	public User(Game game, int Xcoordinate, int Ycoordinate) {
		super(game, Xcoordinate, Ycoordinate);
		this.game = game;
	}

	@Override
	public abstract void render(Graphics g);

	@Override
	public void tick() {
		this.setIdealLocation();
		if(game.getKeyManager().up && !this.up_movable)game.getKeyManager().finish = true;
		if(game.getKeyManager().down && !this.down_movable)game.getKeyManager().finish = true;
		if(game.getKeyManager().right && !this.right_movable)game.getKeyManager().finish = true;
		if(game.getKeyManager().left && !this.left_movable)game.getKeyManager().finish = true;
		if(game.getKeyManager().finish && game.getKeyManager().up && this.up_movable) 	Character.Ycoordinate -= DEFAULT_PACE;
		else if (game.getKeyManager().up && this.up_movable) {
			if (!game.getKeyManager().finish ) {
				if( Character.Ycoordinate % 100 == 5 )	game.getKeyManager().finish = true;
				else	Character.Ycoordinate -= DEFAULT_PACE;
				System.out.println("ufinish:"+game.getKeyManager().finish );
			}
			
			
			
		
		} else if(game.getKeyManager().finish && game.getKeyManager().down && this.down_movable)	Character.Ycoordinate += DEFAULT_PACE;
			else if (game.getKeyManager().down && this.down_movable) {
			 if (!game.getKeyManager().finish ) {
				if( Character.Ycoordinate % 100 == 5)
				game.getKeyManager().finish = true;
				else	Character.Ycoordinate += DEFAULT_PACE;
				System.out.println("dfinish:"+game.getKeyManager().finish );
			}
			}
	
			
		 else if (game.getKeyManager().finish && game.getKeyManager().left && this.left_movable) Character.Xcoordinate -= DEFAULT_PACE;
		 else if( game.getKeyManager().left && this.left_movable)	{
			 if (!game.getKeyManager().finish ) {
				if( Character.Xcoordinate % 100 == 45)game.getKeyManager().finish = true;
				else	Character.Xcoordinate -= DEFAULT_PACE;
				System.out.println("lfinish:"+game.getKeyManager().finish );
			}
				
	
				// game.getKeyManager().left = false;
				
			
		} else if (game.getKeyManager().finish && game.getKeyManager().right && this.right_movable) Character.Xcoordinate += DEFAULT_PACE;
		else if( game.getKeyManager().right && this.right_movable)	{
			 if (!game.getKeyManager().finish) {
				if( Character.Xcoordinate % 100 == 45)game.getKeyManager().finish = true;
				// game.getKeyManager().right = false;
				
				else	Character.Xcoordinate += DEFAULT_PACE;
				System.out.println("rfinish:"+game.getKeyManager().finish );
			}
		
			//System.out.println(this.Xcoordinate + " " + this.Ycoordinate);
			
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
