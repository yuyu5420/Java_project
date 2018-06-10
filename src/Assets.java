import java.awt.image.BufferedImage;

public class Assets{

	public static BufferedImage background, obstacle1, obstacle2, box, cowboy, cowboy_left, cowboy_right;
	public static BufferedImage[] cowboys = new BufferedImage[3];
	
	public static void init() {
		background = ImageLoader.loadImage("/images/last_map.png");
		obstacle1 = ImageLoader.loadImage("/images/obstacle1.png");
		obstacle2 = ImageLoader.loadImage("/images/obstacle2.png");
		box = ImageLoader.loadImage("/images/box.png");
		cowboy = ImageLoader.loadImage("/images/cowboy.png");
		cowboy_left = ImageLoader.loadImage("/images/cowboy_left.png");
		cowboy_right = ImageLoader.loadImage("/images/cowboy_right.png");
		cowboys[0] = ImageLoader.loadImage("/images/cowboy_left.png");
		cowboys[1] = ImageLoader.loadImage("/images/cowboy_right.png");
		cowboys[2] = ImageLoader.loadImage("/images/cowboy.png");
	}
	
}
