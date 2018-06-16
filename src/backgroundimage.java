import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class backgroundimage {
	BufferedImage image;
	BufferedImage image1, image2;
	Graphics2D g2;
	int x1, x2;
	int speed = 12;

	public backgroundimage() {

		try {
			image1 = ImageIO.read(new File("./image/background.png"));
			image2 = ImageIO.read(new File("./image/background.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		image = new BufferedImage(1600, 1000, BufferedImage.TYPE_INT_BGR);
		g2 = image.createGraphics();
		x1 = 0;
		x2 = 1600;
		g2.drawImage(image1, x1, 0, null);
		g2.drawImage(image2, x2, 0, null);

	}

	public void roll() {
		x1 -= speed;
		x2 -= speed;
		if (x1 <= -1600) {
			x1 = 1600;
		}
		if (x2 <= -1600) {
			x2 = 1600;
		}
		g2.drawImage(image1, x1, 0, null);
		g2.drawImage(image2, x2, 0, null);

	}
}
