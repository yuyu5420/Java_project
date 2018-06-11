import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyManager extends KeyAdapter {

	public boolean finish = true;
	public boolean up, down, left, right;
	protected boolean temp_up, temp_down, temp_right, temp_left;
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
		if (!finish) {
			return;
		}
		if (e.getKeyCode() == moveUp) {
			up = true;
			down = false;
			left = false;
			right = false;
		}
		if (e.getKeyCode() == moveDown) {
			up = false;
			down = true;
			left = false;
			right = false;
		}
		if (e.getKeyCode() == moveRight) {
			up = false;
			down = false;
			left = false;
			right = true;
		}
		if (e.getKeyCode() == moveLeft) {
			up = false;
			down = false;
			left = true;
			right = false;
		}
		if(e.getKeyCode() == put && !Game.bomb_exist[(Character.Xcoordinate-445)/100][(Character.Ycoordinate-5)/100]) {
			if (k == 50)	k = 0;
			GameState.bomb[k] = new Bomb((Character.Xcoordinate-445)/100,(Character.Ycoordinate-5)/100,6);
			GameState.first[k] = true;
			GameState.second[k] = true;
			GameState.third[k] = true;
			GameState.fourth[k] = true;
			k++;
		}
	
	}

	/*
	 * @Override public void keyReleased(KeyEvent e) { super.keyReleased(e);
	 * if(!finish) { return; } if(e.getKeyCode() == moveUp) { temp_up = false; }
	 * if(e.getKeyCode() == moveDown) { temp_down = false; } if(e.getKeyCode() ==
	 * moveRight) { temp_right = false; } if(e.getKeyCode() == moveLeft) { temp_left
	 * = false; } }
	 */
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
