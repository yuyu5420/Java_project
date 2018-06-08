import java.awt.Graphics;
import javax.swing.JComponent;

public abstract class Character implements GameStateDefault{

	private Game game;
	protected int Xcoordinate;
	protected int Ycoordinate;
	protected int moveSpeed;
	protected int bombTotal;	/* total bomb number can put */
	protected int bombNum;	
	protected int score;
	protected boolean left_movable=true, right_movable=true, up_movable=true, down_movable=true;
	
	public Character(Game game, int Xcoordinate, int Ycoordinate) {
		this.Xcoordinate = Xcoordinate;
		this.Ycoordinate = Ycoordinate;
		moveSpeed = DEFAULT_MOVESPEED;
		bombTotal = DEFAULT_BOMBTOTAL;
		bombNum = DEFAULT_BOMBTOTAL;
		score = DEFAULT_SCORE;
		this.game = game;
	}

	public abstract void move(int Xcoordinate, int Ycoordinate);
	
	public abstract void render(Graphics g) ;
	public abstract void tick() ;

	public abstract void putBomb();
	
	public void movable() {
		if(game.getKeyManager().up) {
			if(this.Ycoordinate <= DEFAULT_MIN_Y){
				this.up_movable = false;
				this.down_movable = true;
				this.left_movable = true;
				this.right_movable = true;
			}
		} else if(game.getKeyManager().down) {
			if(this.Ycoordinate >= DEFAULT_MAX_Y) {
				this.down_movable = false;
				this.up_movable = true;
				this.left_movable = true;
				this.right_movable = true;
			}
		} else if(game.getKeyManager().left) {
			if(this.Xcoordinate <= DEFAULT_MIN_X) {
				this.left_movable = false;
				this.up_movable = true;
				this.down_movable = true;
				this.right_movable = true;
			}
		} else if(game.getKeyManager().right) {
			if(this.Xcoordinate >= DEFAULT_MAX_X) {
				this.right_movable = false;
				this.up_movable = true;
				this.down_movable = true;
				this.left_movable = true;
			}
		}
	}
	
	public void setXcoordinate(int xcoordinate) {
		Xcoordinate = xcoordinate;
	}

	public void setYcoordinate(int ycoordinate) {
		Ycoordinate = ycoordinate;
	}

	public int getYcoordinate() {
		return Ycoordinate;
	}

	public int getXcoordinate() {
		return Xcoordinate;
	}



}
