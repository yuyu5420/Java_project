import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyManager extends KeyAdapter {

	protected boolean up, down, left, right;
	protected int state_now = 0, state_next, state;
	private int moveUp, moveDown, moveRight, moveLeft, put;
	protected boolean up2, down2, left2, right2;
	protected int state_now2 = 0, state_next2, state2;
	private int moveUp2, moveDown2, moveRight2, moveLeft2, put2;
	public static int bomb_counter = 0;

	public KeyManager() {
		moveUp = KeyEvent.VK_UP;
		moveDown = KeyEvent.VK_DOWN;
		moveLeft = KeyEvent.VK_LEFT;
		moveRight = KeyEvent.VK_RIGHT;
		put = KeyEvent.VK_ENTER;
		moveUp2 = KeyEvent.VK_W;
		moveDown2 = KeyEvent.VK_S;
		moveLeft2 = KeyEvent.VK_A;
		moveRight2 = KeyEvent.VK_D;
		put2 = KeyEvent.VK_SPACE;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		super.keyPressed(e);
		if (!ButtonListener.jjjjjj) {
			if (e.getKeyCode() == moveUp) {
				up = true;
				state_next = this.moveUp;			
			}
			if (e.getKeyCode() == moveDown) {
				down = true;
				state_next = this.moveDown;
			}
			if (e.getKeyCode() == moveRight) {
				right = true;
				state_next = this.moveRight;
			}
			if (e.getKeyCode() == moveLeft) {
				left = true;
				state_next = moveLeft;
			}
			if (state_now == 0) {
				state_now = state_next;
				if (state_next != 0) {
					state = state_now;
				}
			}
			if (e.getKeyCode() == put && !Game.bomb_exist[(Character.getX()-445)/100][(Character.getY()-5)/100]) {
				if (bomb_counter == 50)
					bomb_counter = 0;
				GameState.bomb[bomb_counter] = new Bomb((Character.getX()-445)/100, (Character.getY()-5)/100, 6);
				GameState.first_bb[bomb_counter] = true;
				GameState.second_bb[bomb_counter] = true;
				GameState.third_bb[bomb_counter] = true;
				GameState.fourth_bb[bomb_counter] = true;
				bomb_counter++;
			}
			if (e.getKeyCode() == put2 && !Game.bomb_exist[(Player2.getXXXX()-445)/100][(Player2.getYYYY()-5)/100]) {
				if (bomb_counter == 50)
					bomb_counter = 0;
				GameState.bomb[bomb_counter] = new Bomb((Player2.getXXXX()-445)/100, (Player2.getYYYY()-5)/100, 6);
				GameState.first_bb[bomb_counter] = true;
				GameState.second_bb[bomb_counter] = true;
				GameState.third_bb[bomb_counter] = true;
				GameState.fourth_bb[bomb_counter] = true;
				bomb_counter++;
			}
			
			////////////////
			if (e.getKeyCode() == moveUp2) {
				up2 = true;
				state_next2 = this.moveUp2;			
				System.out.println("sersrsers");
			}
			if (e.getKeyCode() == moveDown2) {
				down2 = true;
				state_next2 = this.moveDown2;
			}
			if (e.getKeyCode() == moveRight2) {
				right2 = true;
				state_next2 = this.moveRight2;
			}
			if (e.getKeyCode() == moveLeft2) {
				left2 = true;
				state_next2 = moveLeft2;
			}
			if (state_now2 == 0) {
				state_now2 = state_next2;
				if (state_next2 != 0) {
					state2 = state_now2;
				}
			}
			
			
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		super.keyReleased(e);
		state_next = 0;
		if (e.getKeyCode() == moveUp) {
			up = false;
		}
		if (e.getKeyCode() == moveDown) {
			down = false;
		}
		if (e.getKeyCode() == moveRight) {
			right = false;
		}
		if (e.getKeyCode() == moveLeft) {
			left = false;
		}
		state_next2 = 0;
		if (e.getKeyCode() == moveUp2) {
			up2 = false;
		}
		if (e.getKeyCode() == moveDown2) {
			down2 = false;
		}
		if (e.getKeyCode() == moveRight2) {
			right2 = false;
		}
		if (e.getKeyCode() == moveLeft2) {
			left2 = false;
		}
	}

	public int getMoveUp() {
		return moveUp;
	}

	public void setMoveUp(int moveUp) {
		this.moveUp = moveUp;
	}

	public void setMoveDown(int moveDown) {
		this.moveDown = moveDown;
	}

	public void setMoveRight(int moveRight) {
		this.moveRight = moveRight;
	}

	public void setMoveLeft(int moveLeft) {
		this.moveLeft = moveLeft;
	}
	
	public int getMoveUp2() {
		return moveUp2;
	}

	public void setMoveUp2(int moveUp) {
		this.moveUp2 = moveUp;
	}

	public void setMoveDown2(int moveDown) {
		this.moveDown2 = moveDown;
	}

	public void setMoveRight2(int moveRight) {
		this.moveRight2 = moveRight;
	}

	public void setMoveLeft2(int moveLeft) {
		this.moveLeft2 = moveLeft;
	}

}
