import java.awt.Graphics;
import java.awt.event.KeyAdapter;

public abstract class User extends Character {

	public User(int Xcoordinate, int Ycoordinate) {
		super(Xcoordinate, Ycoordinate);
	}

	@Override
	public abstract void render(Graphics g);

	@Override
	public abstract void tick();

	@Override
	public void move(int Xcoordinate, int Ycoordinate) {
		
		
	}
	
	

}
