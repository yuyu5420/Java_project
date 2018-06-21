
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public abstract class User extends Character {

	protected int ID;
	protected int state_now, state;

	protected boolean up, down, left, right, bombSignal;

	protected int up_key;
	protected int down_key;
	protected int left_key;
	protected int right_key;

	public int bomb_counter = 0;
	
	public User(int Xcoordinate, int Ycoordinate) {
		super(Xcoordinate, Ycoordinate);
	}

	@Override
	public abstract void render(Graphics g);

	@Override
	public void tick() {
		collideProps();
		bombCheck();
		testIdealLocation();
		if (state_now == up_key && up_movable) {

			if (up) {

				this.Ycoordinate -= pace;
				this.pace_cnt++;
				return;
			} else { // button release
				check();
			}
		} else if (state_now == down_key && down_movable) {

			if (down) {

				this.Ycoordinate += pace;
				this.pace_cnt++;
				return;
			} else {
				check();
			}
		} else if (state_now == left_key && left_movable) {

			if (left) {

				this.Xcoordinate -= pace;
				this.pace_cnt++;
				return;
			} else {
				check();
			}
		} else if (state_now == right_key && right_movable) {

			if (right) {

				this.Xcoordinate += pace;
				this.pace_cnt++;
				return;
			} else {
				check();
			}
		}
		
		if (bombSignal && !Game.bomb_exist[(int)(Player.getX()-445)/100][(int)(Player.getY()-5)/100]&&bombPut<bombTotal) {
			if (KeyManager1.bomb_counter == 50)
				KeyManager1.bomb_counter = 0;
//			System.out.println("AAAA");
			GameState.bomb[KeyManager1.bomb_counter] = new Bomb((int)(Player.getX()-445)/100, (int)(Player.getY()-5)/100, fire);
			GameState.first_bb[KeyManager1.bomb_counter] = true;
			GameState.second_bb[KeyManager1.bomb_counter] = true;
			GameState.third_bb[KeyManager1.bomb_counter] = true;
			GameState.fourth_bb[KeyManager1.bomb_counter] = true;
			KeyManager1.bomb_counter++;
			bombPlace[(int)(Player.getX()-445)/100][(int)(Player.getY()-5)/100] = true;
			bombPut++;
		}
	}

	public void testIdealLocation() {
		if (ideal_X == this.Xcoordinate && ideal_Y == this.Ycoordinate) {
			ideal_up[0] = ideal_X;
			ideal_up[1] = ideal_Y - 100;
			ideal_down[0] = ideal_X;
			ideal_down[1] = ideal_Y + 100;
			ideal_left[0] = ideal_X - 100;
			ideal_left[1] = ideal_Y;
			ideal_right[0] = ideal_X + 100;
			ideal_right[1] = ideal_Y;
			super.movable();
		}
		this.setIdealLocation(state_now);
	}

	public void setIdealLocation(int direction) {
		if (direction == up_key && this.up_movable) {
			ideal_X = ideal_up[0];
			ideal_Y = ideal_up[1];
		} else if (direction == down_key && this.down_movable) {
			ideal_X = ideal_down[0];
			ideal_Y = ideal_down[1];
		} else if (direction == right_key && this.right_movable) {
			ideal_X = ideal_right[0];
			ideal_Y = ideal_right[1];
		} else if (direction == left_key && this.left_movable) {
			ideal_X = ideal_left[0];
			ideal_Y = ideal_left[1];
		}  else {
			state_now = 0;
		}
	}

	public void setStateNow(int state_now) {
		this.state_now = state_now;
	}
		
	public int getStateNow() {
		return state_now;
	}
	
	public void setKey(int up, int down, int left, int right) {
		this.up_key = up;
		this.down_key = down;
		this.left_key = left;
		this.right_key = right;
	}
	

	public void setDirection(boolean up, boolean down, boolean left, boolean right) {

		this.up = up;
		this.left = left;
		this.right = right;
		this.down = down;
	}
		
	public void check() {

		if (ideal_X == this.Xcoordinate && ideal_Y == this.Ycoordinate) {
			state_now = 0;
			return;
		} else {
			if (state_now == up_key || state_now == down_key) {
				if (Math.abs((ideal_Y - this.Ycoordinate)) == this.pace) {
					if (state_now == up_key) {
						this.Ycoordinate -= this.pace;
					} else {
						this.Ycoordinate += this.pace;
					}
					this.pace_cnt++;
					state_now = 0;
				} else {
					if (state_now == up_key) {
						this.Ycoordinate -= this.pace;
					} else {
						this.Ycoordinate += this.pace;
					}
					this.pace_cnt++;
				}
			} else {
				if (Math.abs((ideal_X - this.Xcoordinate)) == this.pace) {
					if (state_now == left_key) {
						this.Xcoordinate -= this.pace;
					} else {
						this.Xcoordinate += this.pace;
					}
					this.pace_cnt++;
					state_now = 0;
				} else {
					if (state_now == left_key) {
						this.Xcoordinate -= this.pace;
					} else {
						this.Xcoordinate += this.pace;
					}
					this.pace_cnt++;
				}
			}
		}
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	

	public void setBombSignal(boolean bombSignal) {

		this.bombSignal = bombSignal;
	}
}