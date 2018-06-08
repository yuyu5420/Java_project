import java.awt.Graphics;
import javax.swing.JComponent;

public abstract class Character extends JComponent{

	private int Xcoordinate;
	private int Ycoordinate;
	private int moveSpeed;
	private int bombTotal;	/* total bomb number can put */
	private int bombNum;	
	private int score;
	
	public Character(int Xcoordinate, int Ycoordinate) {
		this.setXcoordinate(Xcoordinate);
		this.setYcoordinate(Ycoordinate);
		moveSpeed = 1;
		bombTotal = 1;
		bombNum = 1;
		score = 0;
	}

	public abstract void render(Graphics g) ;
	public abstract void tick() ;

	public int getYcoordinate() {
		return Ycoordinate;
	}

	public void setYcoordinate(int ycoordinate) {
		Ycoordinate = ycoordinate;
	}

	public int getXcoordinate() {
		return Xcoordinate;
	}

	public void setXcoordinate(int xcoordinate) {
		Xcoordinate = xcoordinate;
	}

}
