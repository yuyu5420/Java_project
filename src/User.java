import java.awt.Graphics;

public abstract class User extends Character {

	public User(int Xcoordinate, int Ycoordinate) {
		super(Xcoordinate, Ycoordinate);
		this.addKeyListener(new KeyManager());
	}

	@Override
	public abstract void render(Graphics g) ;

	@Override
	public abstract void tick() ;

}
