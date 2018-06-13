import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyManager extends KeyAdapter {

	protected boolean up, down, left, right;
	protected int state_now = 0, state_next, state;
	private int moveUp, moveDown, moveRight, moveLeft , put;
	int k = 0;

	public KeyManager() {
		moveUp = KeyEvent.VK_UP;
		moveDown = KeyEvent.VK_DOWN;
		moveLeft = KeyEvent.VK_LEFT;
		moveRight = KeyEvent.VK_RIGHT;
		put = KeyEvent.VK_SPACE;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		super.keyPressed(e);
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
		  if(e.getKeyCode() == put && !Game.bomb_exist[0][0] ) { 
			  if (k == 50) k =0;
			  GameState.bomb[k] = new Bomb( 0,0,6 ); 
			  GameState.first_bb[k] =true; 
			  GameState.second_bb[k] = true; 
			  GameState.third_bb[k] = true;
			  GameState.fourth_bb[k] = true;
			  k++;
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

	
	

}
