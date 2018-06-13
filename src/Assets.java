import java.awt.image.BufferedImage;

public class Assets{

	public static BufferedImage background, obstacle1, obstacle2, box, cowboy, cowboy_left, cowboy_right, jin;
	public static BufferedImage[] blue_down = new BufferedImage[2];
	public static BufferedImage[] blue_up = new BufferedImage[2];
	public static BufferedImage[] blue_left = new BufferedImage[2];
	public static BufferedImage[] blue_right = new BufferedImage[2];
	public static BufferedImage[] cowboys = new BufferedImage[3];
	
	public static void init() {
		background = ImageLoader.loadImage("/images/last_map.png");
		obstacle1 = ImageLoader.loadImage("/images/obstacle1.png");
		obstacle2 = ImageLoader.loadImage("/images/obstacle2.png");
		box = ImageLoader.loadImage("/images/box.png");
		cowboy = ImageLoader.loadImage("/images/cowboy.png");
		cowboy_left = ImageLoader.loadImage("/images/cowboy_left.png");
		cowboy_right = ImageLoader.loadImage("/images/cowboy_right.png");
		//
		cowboys[0] = ImageLoader.loadImage("/images/cowboy_left.png");
		cowboys[1] = ImageLoader.loadImage("/images/cowboy_right.png");
		cowboys[2] = ImageLoader.loadImage("/images/cowboy.png");
		jin = ImageLoader.loadImage("/images/jin.png");
		//
		blue_down[0] = ImageLoader.loadImage("images/blue_down_0.png");
		blue_down[1] = ImageLoader.loadImage("images/blue_down_1.png");
		blue_left[0] = ImageLoader.loadImage("images/blue_left_0.png");
		blue_left[1] = ImageLoader.loadImage("images/blue_left_1.png");
		blue_right[0] = ImageLoader.loadImage("images/blue_right_0.png");
		blue_right[1] = ImageLoader.loadImage("images/blue_right_1.png");
		blue_up[0] = ImageLoader.loadImage("images/blue_up_0.png");
		blue_up[1] = ImageLoader.loadImage("images/blue_up_1.png");

	}
	
}
