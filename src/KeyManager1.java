import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyManager1 extends KeyAdapter {

	private int module=0;

	protected boolean up, down, left, right, put;

	protected int state_now = 0, state_next, state;
	public static int bomb_counter = 0;
	private int moveUp = KeyEvent.VK_UP;
	private int moveDown = KeyEvent.VK_DOWN;
	private int moveLeft = KeyEvent.VK_LEFT;
	private int moveRight = KeyEvent.VK_RIGHT;
	private int putBomb = KeyEvent.VK_SPACE;
	protected boolean up2, down2, left2, right2, put2;
	protected int state_now2 = 0, state_next2, state2;
	private int moveUp2;
	private int moveDown2;
	private int moveRight2;
	private int moveLeft2;
	private int putBomb2;

	
	public KeyManager1(int module) {
		this.module = module;
		if(module==2) {			// two-person
			moveUp2 = KeyEvent.VK_W;
			moveDown2 = KeyEvent.VK_S;
			moveRight2 = KeyEvent.VK_D;
			moveLeft2 = KeyEvent.VK_A;
			putBomb = KeyEvent.VK_ENTER;
			putBomb2 = KeyEvent.VK_SPACE;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		super.keyPressed(e);

		if (ButtonListener.jjjjjj) {
			return;
		}
			
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
		if (e.getKeyCode() == putBomb) {
			put = true;

		}
		if (state_now == 0) {
			state_now = state_next;
			if (state_now != 0) {
				state = state_now;
			}
		}


		if(module!=2) {
			return; 
		} 
		if (e.getKeyCode() == moveUp2) {
			up2 = true;
			state_next2 = this.moveUp2;			
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
		if (e.getKeyCode() == putBomb2) {
			put2 = true;
		}
		if (state_now2 == 0) {
			state_now2 = state_next2;
			if (state_now2 != 0) {
				state2 = state_now2;
			}
		}
/*		if (e.getKeyCode() == putBomb2 && !Game.bomb_exist[(Player2.getXXXX()-445)/100][(Player2.getYYYY()-5)/100]) {
			if (bomb_counter == 50)
				bomb_counter = 0;
			GameState.bomb[bomb_counter] = new Bomb((Player2.getXXXX()-445)/100, (Player2.getYYYY()-5)/100, 6);
			GameState.first_bb[bomb_counter] = true;
			GameState.second_bb[bomb_counter] = true;
			GameState.third_bb[bomb_counter] = true;
			GameState.fourth_bb[bomb_counter] = true;
			bomb_counter++;
		}*/
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
		if(e.getKeyCode() == putBomb) {
			put = false;

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
		if(e.getKeyCode() == putBomb2) {
			put2 = false;
		}
	}


	public int getMoveUp() {
		return moveUp;
	}

	public int getMoveDown() {
		return moveDown;
	}

	public int getMoveLeft() {
		return moveLeft;
	}

	public int getMoveRight() {
		return moveRight;
	}

	public int getMoveUp2() {
		return moveUp2;
	}

	public int getMoveDown2() {
		return moveDown2;
	}

	public int getMoveRight2() {
		return moveRight2;
	}

	public int getMoveLeft2() {
		return moveLeft2;
	}

	public int getPutBomb() {
		return putBomb;
	}

	public int getPutBomb2() {
		return putBomb2;
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
	
	public void setPutBomb(int putBomb) {
		this.putBomb = putBomb;
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

	public void setPutBomb2(int putBomb2) {
		this.putBomb2 = putBomb2;
	}

}
