import java.awt.image.BufferedImage;

public class Assets {

	public static BufferedImage background, background2, obstacle1, obstacle2, box, bomb, fire, fire_d, fire_r, player1,
			cowboy, cowboy_left, cowboy_right, inventory, power, speed;
	
	public static BufferedImage one, two , three , four , five , six , seven , eight , nine , zero , t , i , m ,e , colon, stick ;
	public static BufferedImage[] cowboys;
	public static BufferedImage[] p1 = new BufferedImage[8];
	public static void init() {
		//game's objects
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
		//left screen's objects
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
		p1[0] = ImageLoader.loadImage("/images/p1u1.png");
		p1[1] = ImageLoader.loadImage("/images/p1u2.png");
		p1[2] = ImageLoader.loadImage("/images/p1d1.png");
		p1[3] = ImageLoader.loadImage("/images/p1d2.png");
		p1[4] = ImageLoader.loadImage("/images/p1l1.png");
		p1[5] = ImageLoader.loadImage("/images/p1l2.png");
		p1[6] = ImageLoader.loadImage("/images/p1r1.png");
		p1[7] = ImageLoader.loadImage("/images/p1r2.png");
	}

}
