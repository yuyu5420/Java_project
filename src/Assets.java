import java.awt.image.BufferedImage;

public class Assets{

	public static BufferedImage background;
	
	public static void init() {
		background = ImageLoader.loadImage("/images/last_map.png");
	}
	
}
