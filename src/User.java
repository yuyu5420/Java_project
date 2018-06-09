import java.awt.Graphics;
import java.awt.event.KeyAdapter;

import javafx.scene.input.*;

public abstract class User extends Character {

	private Game game;
	
	public User(Game game, int Xcoordinate, int Ycoordinate) {
		super(game, Xcoordinate, Ycoordinate);
		this.game = game;
		
	}

	@Override
	public abstract void render(Graphics g);

	@Override
	public void tick() {
		movable();
		if(game.getKeyManager().up && up_movable) {
			super.setYcoordinate(super.getYcoordinate()-DEFAULT_PACE);
		} else if(game.getKeyManager().down && down_movable) {
			super.setYcoordinate(super.getYcoordinate()+DEFAULT_PACE);
		} else if(game.getKeyManager().left && left_movable) {
			super.setXcoordinate(super.getXcoordinate()-DEFAULT_PACE);
		} else if(game.getKeyManager().right && right_movable) {
			super.setXcoordinate(super.getXcoordinate()+DEFAULT_PACE);
		}
		
	}

	
	@Override
	public void putBomb() {
		// TODO Auto-generated method stub
		
	}
	

}