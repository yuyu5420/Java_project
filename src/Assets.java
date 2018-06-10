import java.awt.image.BufferedImage;

public class Assets {

	public static BufferedImage background, background2, obstacle1, obstacle2, box, bomb, fire, fire_d, fire_r, player1,
			cowboy, cowboy_left, cowboy_right, inventory, power, speed;
	public static BufferedImage[] cowboys;

	public static void init() {
		background = ImageLoader.loadImage("/images/last_map.png");
		obstacle1 = ImageLoader.loadImage("/images/obstacle1.png");
		obstacle2 = ImageLoader.loadImage("/images/obstacle2.png");
		box = ImageLoader.loadImage("/images/box.png");
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
	}

}
