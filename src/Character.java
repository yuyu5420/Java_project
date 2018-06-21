
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public abstract class Character implements GameStateDefault {

	protected double Xcoordinate, Ycoordinate;
	private int bombNum;
	private int power, powerNum;
	protected Game game;
	protected double pace;
	protected int pace_cnt;
	protected int paceLV=0;
	protected int bombPut = 0;
	protected double[] pace_arr= {5,6.25,10,12.5,20,25};
	protected boolean [][] bombPlace = new boolean [11][9];
	protected int bombTotal=1;
	protected int fire = 1;
	
	public static int X,Y;
	
	public static int getX() {
		return X;
	}

	public static void setX(double x) {
		Character.X = (int)x;
	}

	public static int getY() {
		return Y;
	}

	public static void setY(double y) {
		Character.Y = (int)y;
	}

	protected boolean left_movable, right_movable, up_movable, down_movable;
	protected int[] ideal_up = new int[2];
	protected int[] ideal_down = new int[2];
	protected int[] ideal_left = new int[2];
	protected int[] ideal_right = new int[2];
	protected int ideal_X, ideal_Y;

	public Character(double xcoordinate2, double ycoordinate2) {
		this.Xcoordinate = xcoordinate2;
		this.Ycoordinate = ycoordinate2;
		this.pace = DEFAULT_PACE;
		ideal_X = (int) xcoordinate2;
		ideal_Y = (int) ycoordinate2;
	}

	public abstract void render(Graphics g);

	public abstract void tick();

	public void movable() {
		setX(Xcoordinate);	// bomb
		setY(Ycoordinate);	// bomb
		
		this.up_movable = true;
		this.down_movable = true;
		this.left_movable = true;
		this.right_movable = true;

		// out border
		if (this.ideal_up[1] < DEFAULT_MIN_Y) {
			this.up_movable = false;
		}
		if (this.ideal_down[1] > DEFAULT_MAX_Y) {
			this.down_movable = false;
		}
		if (this.ideal_left[0] < DEFAULT_MIN_X) {
			this.left_movable = false;
		}
		if (this.ideal_right[0] > DEFAULT_MAX_X) {
			this.right_movable = false;
		}

		// check obstacle
		if (this.up_movable) {
			if (!Game.go[(this.ideal_up[0] - 400) / 100][(this.ideal_up[1]) / 100])
				this.up_movable = false;
		}
		if (this.down_movable) {
			if (!Game.go[(this.ideal_down[0] - 400) / 100][(this.ideal_down[1]) / 100])
				this.down_movable = false;
		}
		if (this.left_movable) {
			if (!Game.go[(this.ideal_left[0] - 400) / 100][(this.ideal_left[1]) / 100])
				this.left_movable = false;
		}
		if (this.right_movable) {
			if (!Game.go[(this.ideal_right[0] - 400) / 100][(this.ideal_right[1]) / 100])
				this.right_movable = false;
		}

	}

	public void collideProps() {
		if(Game.props[(int)(this.Xcoordinate-400)/100][(int)this.Ycoordinate/100]!=null&&this.Xcoordinate==ideal_X&&this.Ycoordinate==ideal_Y) {
			switch(Game.props[(int)(this.Xcoordinate-400)/100][(int)this.Ycoordinate/100].id) {
				case 1:{
					this.bombTotal++;
					Game.props[(int)(this.Xcoordinate-400)/100][(int)this.Ycoordinate/100]=null;
					break;
				}
				case 2:{
					this.fire++;
					Game.props[(int)(this.Xcoordinate-400)/100][(int)this.Ycoordinate/100]=null;
					break;
				}
				case 3:{
					if(paceLV<=5) {
						this.pace = pace_arr[paceLV];
						paceLV++;
						Game.props[(int) ((this.Xcoordinate-400)/100)][(int) (this.Ycoordinate/100)]=null;
					}else {
						Game.props[(int) ((this.Xcoordinate-400)/100)][(int) (this.Ycoordinate/100)]=null;
					}
					break;
				}
			}
		}
	}
	public void bombCheck() {
		for(int i=0;i<=10;i++) {
			for(int j=0;j<=8;j++) {
				if(bombPlace[i][j]) {
					if(bombPlace[i][j]!=Game.bomb_exist[i][j]) {
						bombPlace[i][j] = false;
						bombPut--;		
					}
				}
			}
		}
	}
	
}