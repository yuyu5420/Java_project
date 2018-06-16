import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;

public class Bomber {
	int x, y;
	BufferedImage image;
	BufferedImage image1, image2;
	int counter = 0;
	boolean jumpstate = false;
	int jump_situation;

	public Bomber() {
		try {

			image1 = ImageIO.read(new File("image/superbomber_1.png"));
			image2 = ImageIO.read(new File("image/superbomber_2.png"));

		} catch (IOException e) {

			e.printStackTrace();

		}

		x = 200;
		y = 500;

	}

	public void move() {

		step();

		if (jumpstate) {
			if (y >= 500) {
				jump_situation = -17; // jump
			}
			if (y <= 0) { // height
				jump_situation = 17; // fall >>> y+
			}
			y += jump_situation;
			if (y >= 500) {
				jumpstate = false;
			}
		}

	}

	void step() {
		int walk = (counter / 250 % 2);
		switch (walk) {
		case 0:
			image = image1;
			break;
		case 1:
			image = image2;
			break;
		}
		counter += gamepanel.FRESH;
	}

	public void jump() {
		jumpstate = true;
	}

	
	  public Rectangle getFeetBounds() { return new Rectangle(x+80,y+210,140,70); }
	 
}
