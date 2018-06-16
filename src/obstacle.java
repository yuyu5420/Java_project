import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class obstacle {
	int x, y;
	BufferedImage image;
	int speed = 12;

	public obstacle() {
		try {
			image = ImageIO.read(new File("./image/ob.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		x = 1600;
		y = 700;
	}

	public void move() {
		x -= speed;	
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,image.getWidth(),image.getHeight());
	}
}
