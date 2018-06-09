import java.awt.image.BufferedImage;

public class Assets{

	public static BufferedImage background, obstacle1, obstacle2, box, bomb, fire, fire_u, fire_d, fire_l, fire_r, player1;
	
	public static void init() {
		background = ImageLoader.loadImage("/images/last_map.png");
		obstacle1 = ImageLoader.loadImage("/images/obstacle1.png");
		obstacle2 = ImageLoader.loadImage("/images/obstacle2.png");
		box = ImageLoader.loadImage("/images/box.png");
		bomb = ImageLoader.loadImage("images/player_bomb.png");
		fire = ImageLoader.loadImage("images/fire.png");
		player1 = ImageLoader.loadImage("/images/player1.png");
		fire_r = ImageLoader.loadImage("images/fire_r.png");
		fire_u = ImageLoader.loadImage("images/fire_u.png");
		fire_d = ImageLoader.loadImage("images/fire_d.png");
		fire_l = ImageLoader.loadImage("images/fire_l.png");
	}
	
}
