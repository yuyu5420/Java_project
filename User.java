import java.awt.Graphics;
import java.awt.event.KeyAdapter;

import javafx.scene.input.KeyCode;

public abstract class User extends Character {

	private Game game;
	
	public User(Game game, int Xcoordinate, int Ycoordinate) {
		super(Xcoordinate, Ycoordinate);
		this.game = game;
		
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
	public void putBomb() {
		// TODO Auto-generated method stub
		
	}
	

}
