import java.awt.image.BufferedImage;

public class Assets{

	public static BufferedImage background;
	
	public static void init() {
		background = ImageLoader.loadImage("/image/last_map.png");
	}
	
}
