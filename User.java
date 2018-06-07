import java.awt.Graphics;
import java.awt.event.KeyAdapter;

import javafx.scene.input.KeyCode;

public abstract class User extends Character {

	private Game game;
	protected int moveUp, moveLeft, moveRight, moveDown;
	
	public User(Game game, int Xcoordinate, int Ycoordinate) {
		super(Xcoordinate, Ycoordinate);
		this.game = game;
		moveUp = DEFAULT_UP;
		moveDown = DEFAULT_DOWN;
		moveLeft = DEFAULT_LEFT;
		moveRight = DEFAULT_RIGHT;
		
	}

	@Override
	public abstract void render(Graphics g);

	@Override
	public void tick() {
		if(game.getKeyManager().up) {
			super.setYcoordinate(super.getYcoordinate()-5);
		} else if(game.getKeyManager().down) {
			super.setYcoordinate(super.getYcoordinate()+5);
		} else if(game.getKeyManager().left) {
			super.setXcoordinate(super.getXcoordinate()-5);
		} else if(game.getKeyManager().right) {
			super.setXcoordinate(super.getXcoordinate()+5);
		}
		
	}

	@Override
	public void move(int Xcoordinate, int Ycoordinate) {
		if(Xcoordinate < 1455 && Xcoordinate >= 445) {
			if(Ycoordinate < 860 && Ycoordinate >= 15) {
				this.tick();
			}
		}
		
	}

	public int getMoveDown() {
		return moveDown;
	}

	public void setMoveDown(int moveDown) {
		this.moveDown = moveDown;
	}

	public int getMoveRight() {
		return moveRight;
	}

	public void setMoveRight(int moveRight) {
		this.moveRight = moveRight;
	}

	public int getMoveLeft() {
		return moveLeft;
	}

	public void setMoveLeft(int moveLeft) {
		this.moveLeft = moveLeft;
	}

	public int getMoveUp() {
		return moveUp;
	}

	public void setMoveUp(int moveUp) {
		this.moveUp = moveUp;
	}


	@Override
	public void putBomb() {
		// TODO Auto-generated method stub
		
	}
	

}
