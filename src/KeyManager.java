import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyManager extends KeyAdapter {

	public boolean finish = true;
	public boolean up = false, down = false, left= false, right = false;
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
			System.out.println("1111finish:"+finish + "   up:" +up);
		}
		else if (e.getKeyCode() == moveDown) {
			up = false;
			down = true;
			left = false;
			right = false;System.out.println("111111111finish:"+finish + "   down:" +down);
		}
		else if (e.getKeyCode() == moveRight) {
			up = false;
			down = false;
			left = false;
			right = true;System.out.println("1111111finish:"+finish + "   rght:" +right);
		}
		else if (e.getKeyCode() == moveLeft) {
			up = false;
			down = false;
			left = true;System.out.println("11111finish:"+finish + "   left:" +left);
			right = false;
		}
		if(e.getKeyCode() == put && !Game.bomb_exist[(Character.Xcoordinate-445)/100][(Character.Ycoordinate-5)/100]) {
			if (k == 50)	k = 0;
			GameState.bomb[k] = new Bomb((Character.Xcoordinate-400)/100,(Character.Ycoordinate)/100,6);
			GameState.first[k] = true;
			GameState.second[k] = true;
			GameState.third[k] = true;
			GameState.fourth[k] = true;
			k++;
		}
	
	}
	public void keyReleased(KeyEvent e) {
		super.keyReleased(e);
		if (e.getKeyCode() == moveUp ) {
			
			up = true;
			down = false;
			left = false;
			right = false;
			finish = false;
			System.out.println("finish:"+finish + "   up:" +up);
		}
		else if (e.getKeyCode() == moveDown ) {
			up = false;
			down = true;
			left = false;
			right = false;
			finish = false;

			System.out.println("finish:"+finish + "   down:" +down);
			
		}
		else if (e.getKeyCode() == moveRight ) {
			up = false;
			down = false;
			left = false;
			right = true;
			finish = false;
			System.out.println("finish:"+finish + "   rrrrr:" +right);
		}
		else if (e.getKeyCode() == moveLeft ) {
			up = false;
			down = false;
			left = true;
			right = false;
			finish = false;
			System.out.println("finish:"+finish + "   down:" +down);
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
