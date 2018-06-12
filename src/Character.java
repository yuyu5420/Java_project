
import java.awt.Graphics;


public abstract class Character implements GameStateDefault {

	private Game game;
	public static int[] Xcoordinate = new int[2], Ycoordinate = new int[2];
	public int i;

	protected boolean left_movable = true, right_movable = true, up_movable = true, down_movable = true;
	protected int pace;
	protected int[][] ideal_up = new int[2][2];
	protected int[][] ideal_down = new int[2][2];
	protected int[][] ideal_left = new int[2][2];
	protected int[][] ideal_right = new int[2][2];

	public Character(Game game, int Xcoordinate, int Ycoordinate, int i) {
		this.game = game;
		Character.Xcoordinate[i] = Xcoordinate;
		Character.Ycoordinate[i] = Ycoordinate;
		this.pace = DEFAULT_PACE;
		ideal_up[i][0] = Xcoordinate;
		ideal_up[i][1] = Ycoordinate - 100;
		ideal_down[i][0] = Xcoordinate;
		ideal_down[i][1] = Ycoordinate + 100;
		ideal_left[i][0] = Xcoordinate - 100;
		ideal_left[i][1] = Ycoordinate;
		ideal_right[i][0] = Xcoordinate + 100;
		ideal_right[i][1] = Ycoordinate;
		this.i =i;
	}

	public abstract void render(Graphics g);

	public abstract void tick();

	public void movable() {

		this.up_movable = true;
		this.down_movable = true;
		this.left_movable = true;
		this.right_movable = true;

		// out border
		if (this.ideal_up[i][1] < DEFAULT_MIN_Y) {
			this.up_movable = false;
		}
		if (this.ideal_down[i][1] > DEFAULT_MAX_Y) {
			this.down_movable = false;
		}
		if (this.ideal_left[i][0] < DEFAULT_MIN_X) {
			this.left_movable = false;
		}
		if (this.ideal_right[i][0] > DEFAULT_MAX_X) {
			this.right_movable = false;
		}

		if (this.up_movable) {
			if (!Game.go[(this.ideal_up[i][0] - 445) / 100][(this.ideal_up[i][1]-5) / 100])
				this.up_movable = false;
		}
		if (this.down_movable) {
			if (!Game.go[(this.ideal_down[i][0] - 445) / 100][(this.ideal_down[i][1]-5) / 100])
				this.down_movable = false;
		}
		if (this.left_movable) {
			if (!Game.go[(this.ideal_left[i][0] - 445) / 100][(this.ideal_left[i][1]-5) / 100])
				this.left_movable = false;
		}
		if (this.right_movable) {
			if (!Game.go[(this.ideal_right[i][0] - 445) / 100][(this.ideal_right[i][1]-5) / 100])
				this.right_movable = false;
		}
	}

	public void setIdealLocation() {
		if(Character.Xcoordinate[i] % 100 == 45)	ideal_up[i][0] = Character.Xcoordinate[i];
		if(Character.Ycoordinate[i] % 100 == 5)	ideal_up[i][1] = Character.Ycoordinate[i] - 100;
		if(Character.Xcoordinate[i] % 100 == 45)	ideal_down[i][0] = Character.Xcoordinate[i];
		if(Character.Ycoordinate[i] % 100 == 5)	ideal_down[i][1] = Character.Ycoordinate[i] + 100;
		if(Character.Xcoordinate[i] % 100 == 45)	ideal_left[i][0] = Character.Xcoordinate[i] - 100;
		if(Character.Ycoordinate[i] % 100 == 5)	ideal_left[i][1] = Character.Ycoordinate[i];
		if(Character.Xcoordinate[i] % 100 == 45)	ideal_right[i][0] = Character.Xcoordinate[i] + 100;
		if(Character.Ycoordinate[i] % 100 == 5)	ideal_right[i][1] = Character.Ycoordinate[i];
		this.movable();
	}

}
