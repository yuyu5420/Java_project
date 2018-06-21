import java.awt.image.BufferedImage;

public class Assets {

	public static BufferedImage background, background2, obstacle1, obstacle2, box, bomb, fire, fire_d, fire_r, player1,
			cowboy, cowboy_left, cowboy_right, inventory, power, speed;
	public static BufferedImage[] blue_down = new BufferedImage[2];
	public static BufferedImage[] blue_up = new BufferedImage[2];
	public static BufferedImage[] blue_left = new BufferedImage[2];
	public static BufferedImage[] blue_right = new BufferedImage[2];
	public static BufferedImage[] black_down = new BufferedImage[2];
	public static BufferedImage[] black_up = new BufferedImage[2];
	public static BufferedImage[] black_left = new BufferedImage[2];
	public static BufferedImage[] black_right = new BufferedImage[2];
	public static BufferedImage[] green_down = new BufferedImage[2];
	public static BufferedImage[] green_up = new BufferedImage[2];
	public static BufferedImage[] green_left = new BufferedImage[2];
	public static BufferedImage[] green_right = new BufferedImage[2];
	public static BufferedImage[] purple_down = new BufferedImage[2];
	public static BufferedImage[] purple_up = new BufferedImage[2];
	public static BufferedImage[] purple_left = new BufferedImage[2];
	public static BufferedImage[] purple_right = new BufferedImage[2];
	public static BufferedImage[] cowboys = new BufferedImage[3];
	
	public static BufferedImage one, two, three, four, five, six, seven, eight, nine, zero, t, i, m, e, colon, block, black_head, purple_head, blue_head, green_head;
	public static BufferedImage[] btn = new BufferedImage[2];
	public static BufferedImage[] p1 = new BufferedImage[8], p2 = new BufferedImage[8], p3 = new BufferedImage[8],
			p4 = new BufferedImage[8];

	public static void init() {
		// game's objects

		btn[0] = ImageLoader.loadImage("/images/pause.png");
		btn[1] = ImageLoader.loadImage("/images/resume.png");
		background = ImageLoader.loadImage("/images/last_map.png");
		block = ImageLoader.loadImage("/images/block.png");
		black_head = ImageLoader.loadImage("/images/black_photo.png");
		green_head = ImageLoader.loadImage("/images/green_photo.png");
		purple_head = ImageLoader.loadImage("/images/purple_photo.png");
		blue_head = ImageLoader.loadImage("/images/blue_photo.png");
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

		//
		blue_down[0] = ImageLoader.loadImage("images/blue_down_0.png");
		blue_down[1] = ImageLoader.loadImage("images/blue_down_1.png");
		blue_left[0] = ImageLoader.loadImage("images/blue_left_0.png");
		blue_left[1] = ImageLoader.loadImage("images/blue_left_1.png");
		blue_right[0] = ImageLoader.loadImage("images/blue_right_0.png");
		blue_right[1] = ImageLoader.loadImage("images/blue_right_1.png");
		blue_up[0] = ImageLoader.loadImage("images/blue_up_0.png");
		blue_up[1] = ImageLoader.loadImage("images/blue_up_1.png");
		
		green_down[0] = ImageLoader.loadImage("/images/p2_1.png");
		green_down[1] = ImageLoader.loadImage("/images/p2_2.png");
		green_left[0] = ImageLoader.loadImage("/images/p2_3.png");
		green_left[1] = ImageLoader.loadImage("/images/p2_4.png");
		green_right[0] = ImageLoader.loadImage("/images/p2_5.png");
		green_right[1] = ImageLoader.loadImage("/images/p2_6.png");
		green_up[0] = ImageLoader.loadImage("/images/p2_7.png");
		green_up[1] = ImageLoader.loadImage("/images/p2_8.png");
		
		purple_down[0] = ImageLoader.loadImage("/images/p3_1.png");
		purple_down[1] = ImageLoader.loadImage("/images/p3_2.png");
		purple_left[0] = ImageLoader.loadImage("/images/p3_3.png");
		purple_left[1] = ImageLoader.loadImage("/images/p3_4.png");
		purple_right[0] = ImageLoader.loadImage("/images/p3_5.png");
		purple_right[1] = ImageLoader.loadImage("/images/p3_6.png");
		purple_up[0] = ImageLoader.loadImage("/images/p3_7.png");
		purple_up[1] = ImageLoader.loadImage("/images/p3_8.png");
		
		black_down[0] = ImageLoader.loadImage("/images/p4_1.png");
		black_down[1] = ImageLoader.loadImage("/images/p4_2.png");
		black_left[0] = ImageLoader.loadImage("/images/p4_3.png");
		black_left[1] = ImageLoader.loadImage("/images/p4_4.png");
		black_right[0] = ImageLoader.loadImage("/images/p4_5.png");
		black_right[1] = ImageLoader.loadImage("/images/p4_6.png");
		black_up[0] = ImageLoader.loadImage("/images/p4_7.png");
		black_up[1] = ImageLoader.loadImage("/images/p4_8.png");
		
		
		bomb = ImageLoader.loadImage("images/player_bomb.png");
		fire = ImageLoader.loadImage("images/fire.png");
		player1 = ImageLoader.loadImage("/images/player1.png");
		fire_r = ImageLoader.loadImage("images/fire_r.png");
		fire_d = ImageLoader.loadImage("images/fire_d.png");
		inventory = ImageLoader.loadImage("images/inventory.png");
		power = ImageLoader.loadImage("images/fire_forPower.png");
		speed = ImageLoader.loadImage("images/boot_forSpeed.png");
		background2 = ImageLoader.loadImage("images/background2.png");
		cowboy = ImageLoader.loadImage("/images/cowboy.png");
		cowboy_left = ImageLoader.loadImage("/images/cowboy_left.png");
		cowboy_right = ImageLoader.loadImage("/images/cowboy_right.png");
		// left screen's objects
		one = ImageLoader.loadImage("/images/1.png");
		two = ImageLoader.loadImage("/images/2.png");
		three = ImageLoader.loadImage("/images/3.png");
		four = ImageLoader.loadImage("/images/4.png");
		five = ImageLoader.loadImage("/images/5.png");
		six = ImageLoader.loadImage("/images/6.png");
		seven = ImageLoader.loadImage("/images/7.png");
		eight = ImageLoader.loadImage("/images/8.png");
		nine = ImageLoader.loadImage("/images/9.png");
		zero = ImageLoader.loadImage("/images/0.png");
		t = ImageLoader.loadImage("/images/T.png");
		i = ImageLoader.loadImage("/images/I.png");
		m = ImageLoader.loadImage("/images/M.png");
		e = ImageLoader.loadImage("/images/E.png");
		colon = ImageLoader.loadImage("/images/colon.png");
		

	}

}
