import java.awt.Graphics;

public class Bomb{

	private int x;
	private int y;
	private Graphics g;
	private boolean G = true;
	public Bomb(Graphics g, int x, int y) {
		
		this.setX(x);
		this.setY(y);
		this.setG(g);
		
	}
	
	public Graphics getG() {
		return g;
	}


	public void setG(Graphics g) {
		this.g = g;
	}

	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public boolean isG() {
		return G;
	}

	public void setG(boolean g) {
		G = g;
	}
}