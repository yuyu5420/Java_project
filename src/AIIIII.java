import java.awt.Graphics;

public class AIIIII extends AI {

	public AIIIII(Game game, int Xcoordinate, int Ycoordinate) {
		super(game, Xcoordinate, Ycoordinate);

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.jin, this.Xcoordinate, this.Ycoordinate, DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
	}

	@Override
	public void tick() {
		super.tick();
	}

}
