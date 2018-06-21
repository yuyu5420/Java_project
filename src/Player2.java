
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Player2 {
	static final int DEFAULT_WIDTH2 = 100;
	static final int DEFAULT_HEIGHT2 = 125;

	static final int DISTANCE_PER_SWITCH2 = 25; /* every 100 pixel switch picture */

	static final int DEFAULT_BOMBTOTAL2 = 1;
	static final int DEFAULT_SCORE2 = 0;
	static final int DEFAULT_PLAYER_1_X2 = 445;
	static final int DEFAULT_PLAYER_1_Y2 = 5;
	static final int DEFAULT_MIN_X2 = 445;
	static final int DEFAULT_MAX_X2 = 1445;
	static final int DEFAULT_MIN_Y2 = 5;
	static final int DEFAULT_MAX_Y2 = 805;
	static final int DEFAULT_PACE2 = 10;
	private Game game;
	protected int Xcoordinate, Ycoordinate;
	public static int XXXX, YYYY;
	public static int getXXXX() {
		return XXXX;
	}


	public static void setXXXX(int xXXX) {
		XXXX = xXXX;
	}


	public static int getYYYY() {
		return YYYY;
	}


	public static void setYYYY(int yYYY) {
		YYYY = yYYY;
	}

	protected boolean left_movable2, right_movable2, up_movable2, down_movable2;
	protected int pace, pace_cnt = 0;
	protected int[] ideal_up = new int[2];
	protected int[] ideal_down = new int[2];
	protected int[] ideal_left = new int[2];
	protected int[] ideal_right = new int[2];
	protected int ideal_X, ideal_Y;
	public Player2(Game game, int Xcoordinate, int Ycoordinate) {
		
		this.game = game;
		this.Xcoordinate = Xcoordinate;
		this.Ycoordinate = Ycoordinate;
		this.pace = 10;
		ideal_X = Xcoordinate;
		ideal_Y = Ycoordinate;
	}

	
	public void render(Graphics g) { // draw
		if (this.pace_cnt == 0) {
			g.drawImage(Assets.green_down[0], this.Xcoordinate, this.Ycoordinate, DEFAULT_WIDTH2, DEFAULT_HEIGHT2, null);
		} else {
			if (game.getKeyManager().state2 == KeyEvent.VK_W) {
				g.drawImage(Assets.green_up[pace_cnt % 2], this.Xcoordinate, this.Ycoordinate, DEFAULT_WIDTH2,
						DEFAULT_HEIGHT2, null);
			} else if (game.getKeyManager().state2 == KeyEvent.VK_S) {
				g.drawImage(Assets.green_down[pace_cnt % 2], this.Xcoordinate, this.Ycoordinate, DEFAULT_WIDTH2,
						DEFAULT_HEIGHT2, null);
			} else if (game.getKeyManager().state2 == KeyEvent.VK_A) {
				g.drawImage(Assets.green_left[pace_cnt % 2], this.Xcoordinate, this.Ycoordinate, DEFAULT_WIDTH2,
						DEFAULT_HEIGHT2, null);
			} else if (game.getKeyManager().state2 == KeyEvent.VK_D) {
				g.drawImage(Assets.green_right[pace_cnt % 2], this.Xcoordinate, this.Ycoordinate, DEFAULT_WIDTH2,
						DEFAULT_HEIGHT2, null);
			}
		}

	}
	public void tick() {

		testIdealLocation(game.getKeyManager().state_now2);
		if (game.getKeyManager().state_now2 == KeyEvent.VK_W && up_movable2) {
			if (game.getKeyManager().up2) {
				this.Ycoordinate -= pace;
				this.pace_cnt++;
				return;
			} else { // button release
				check(game.getKeyManager().state_now2);
				return;
			}
		} else if (game.getKeyManager().state_now2 == KeyEvent.VK_S && down_movable2) {
			if (game.getKeyManager().down2) {
				this.Ycoordinate += pace;
				this.pace_cnt++;
				return;
			} else {
				check(game.getKeyManager().state_now2);
				return;
			}
		} else if (game.getKeyManager().state_now2 == KeyEvent.VK_A && left_movable2) {
			if (game.getKeyManager().left2) {
				this.Xcoordinate -= pace;
				this.pace_cnt++;
				return;
			} else {
				check(game.getKeyManager().state_now2);
				return;
			}
		} else if (game.getKeyManager().state_now2 == KeyEvent.VK_D && right_movable2) {
			if (game.getKeyManager().right2) {
				this.Xcoordinate += pace;
				this.pace_cnt++;
				return;
			} else {
				check(game.getKeyManager().state_now2);
				return;
			}
		}

	}public void movable() {
		setXXXX(Xcoordinate);
		setYYYY(Ycoordinate);
		this.up_movable2 = true;
		this.down_movable2 = true;
		this.left_movable2 = true;
		this.right_movable2 = true;

		// out border
		if (this.ideal_up[1] < DEFAULT_MIN_Y2) {
			this.up_movable2 = false;
		}
		if (this.ideal_down[1] > DEFAULT_MAX_Y2) {
			this.down_movable2 = false;
		}
		if (this.ideal_left[0] < DEFAULT_MIN_X2) {
			this.left_movable2 = false;
		}
		if (this.ideal_right[0] > DEFAULT_MAX_X2) {
			this.right_movable2 = false;
		}

		// check obstacle
		if (this.up_movable2) {
			if (!Game.go[(this.ideal_up[0] - 400) / 100][(this.ideal_up[1]) / 100])
				this.up_movable2 = false;
		}
		if (this.down_movable2) {
			if (!Game.go[(this.ideal_down[0] - 400) / 100][(this.ideal_down[1]) / 100])
				this.down_movable2 = false;
		}
		if (this.left_movable2) {
			if (!Game.go[(this.ideal_left[0] - 400) / 100][(this.ideal_left[1]) / 100])
				this.left_movable2 = false;
		}
		if (this.right_movable2) {
			if (!Game.go[(this.ideal_right[0] - 400) / 100][(this.ideal_right[1]) / 100])
				this.right_movable2 = false;
		}

	}

	public void testIdealLocation(int state) {
		if (ideal_X == this.Xcoordinate && ideal_Y == this.Ycoordinate) {
			ideal_up[0] = ideal_X;
			ideal_up[1] = ideal_Y - 100;
			ideal_down[0] = ideal_X;
			ideal_down[1] = ideal_Y + 100;
			ideal_left[0] = ideal_X - 100;
			ideal_left[1] = ideal_Y;
			ideal_right[0] = ideal_X + 100;
			ideal_right[1] = ideal_Y;
			this.movable();
		}
		this.setIdealLocation(state);
	}

	public void setIdealLocation(int direction) {
		if (direction == KeyEvent.VK_W && this.up_movable2) {
			ideal_X = ideal_up[0];
			ideal_Y = ideal_up[1];
		} else if (direction == KeyEvent.VK_S && this.down_movable2) {
			ideal_X = ideal_down[0];
			ideal_Y = ideal_down[1];
		} else if (direction == KeyEvent.VK_D && this.right_movable2) {
			ideal_X = ideal_right[0];
			ideal_Y = ideal_right[1];
		} else if (direction == KeyEvent.VK_A && this.left_movable2) {
			ideal_X = ideal_left[0];
			ideal_Y = ideal_left[1];
		} else {
			this.game.getKeyManager().state_now2 = 0;
		}
	}

	public void check(int state_now2) {

		if (ideal_X == this.Xcoordinate && ideal_Y == this.Ycoordinate) {
			game.getKeyManager().state_now2 = game.getKeyManager().state_next2;
			if (game.getKeyManager().state_now2 != 0) {
				game.getKeyManager().state2 = game.getKeyManager().state_now2;
			}
			return;
		} else {
			if (state_now2 == KeyEvent.VK_W || state_now2 == KeyEvent.VK_S) {
				if (Math.abs((ideal_Y - this.Ycoordinate)) == this.pace) {
					if (state_now2 == KeyEvent.VK_W) {
						this.Ycoordinate -= this.pace;
					} else {
						this.Ycoordinate += this.pace;
					}
					this.pace_cnt++;
					game.getKeyManager().state_now2 = game.getKeyManager().state_next2;
					if (game.getKeyManager().state_now2 != 0) {
						game.getKeyManager().state2 = game.getKeyManager().state_now2;
					}
				} else {
					if (state_now2 == KeyEvent.VK_W) {
						this.Ycoordinate -= this.pace;
					} else {
						this.Ycoordinate += this.pace;
					}
					this.pace_cnt++;
				}
			} else {
				if (Math.abs((ideal_X - this.Xcoordinate)) == this.pace) {
					if (state_now2 == KeyEvent.VK_A) {
						this.Xcoordinate -= this.pace;
					} else {
						this.Xcoordinate += this.pace;
					}
					this.pace_cnt++;
					game.getKeyManager().state_now2 = game.getKeyManager().state_next2;
					if (game.getKeyManager().state_now2 != 0) {
						game.getKeyManager().state2 = game.getKeyManager().state_now2;
					}
				} else {
					if (state_now2 == KeyEvent.VK_A) {
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

