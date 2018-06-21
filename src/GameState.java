
import java.awt.Graphics;

public class GameState extends State implements GameStateDefault {

	private Game game;
	private User player1;
	private User player2;
	private AI ai1, ai2, ai3;
	public static Bomb[] bomb = new Bomb[50];
	public static long[] start_time = new long[50];
	public static boolean[] first_bb = new boolean[50];
	public static boolean[] second_bb = new boolean[50];
	public static boolean[] third_bb = new boolean[50];
	public static boolean[] fourth_bb = new boolean[50];
	public static boolean explosion_sound = false;
	public GameState(Game game) {
		this.game = game;
		if(Setting_page.Player_Number == 2) {
			player2 = new Player(game, DEFAULT_MAX_X, DEFAULT_MIN_Y);
			player2.setKey(game.getKeyManager().getMoveUp2(), game.getKeyManager().getMoveDown2(), game.getKeyManager().getMoveLeft2(), game.getKeyManager().getMoveRight2());

			player2.setDirection(game.getKeyManager().up2, game.getKeyManager().down2, game.getKeyManager().left2, game.getKeyManager().right2);
			player2.setStateNow(game.getKeyManager().state_now2);
			player2.setID(2);
		}
		player1 = new Player(game, DEFAULT_MIN_X, DEFAULT_MIN_Y);

		player1.setKey(game.getKeyManager().getMoveUp(), game.getKeyManager().getMoveDown(), game.getKeyManager().getMoveLeft(), game.getKeyManager().getMoveRight());
		player1.setDirection(game.getKeyManager().up, game.getKeyManager().down, game.getKeyManager().left, game.getKeyManager().right);
		player1.setBombSignal(game.getKeyManager().put);
		player1.setStateNow(game.getKeyManager().state_now);
		player1.setID(1);
		ai1 = new AI(game, 445,5,player1.Xcoordinate,player1.Ycoordinate);
		ai2 = new AI(game, 1445,805,player1.Xcoordinate,player1.Ycoordinate);
		if(Setting_page.Player_Number == 1) ai3 = new AI(game, 1445,5,player1.Xcoordinate,player1.Ycoordinate);
		
	}

	public void tick() {

		if(game.getKeyManager().state_now!=0) {
			player1.setState(game.getKeyManager().state_now);
		}
		player1.setStateNow(game.getKeyManager().state_now);
		player1.setBombSignal(game.getKeyManager().put);

		player1.tick();
		if(player1.getStateNow()==0) {
			game.getKeyManager().state_now = game.getKeyManager().state_next;
		}
		if(Setting_page.Player_Number == 2) {

			if(game.getKeyManager().state_now2!=0) {
				player2.setState(game.getKeyManager().state_now2);
			}
			player2.setStateNow(game.getKeyManager().state_now2);
			player1.setBombSignal(game.getKeyManager().put2);
			player2.tick();
			if(player2.getStateNow()==0) {
				game.getKeyManager().state_now2 = game.getKeyManager().state_next2;
			}

		}
		ai1.tick(player1.Xcoordinate,player1.Ycoordinate);
		ai2.tick(player1.Xcoordinate,player1.Ycoordinate);
		if(Setting_page.Player_Number == 1)	ai3.tick(player1.Xcoordinate,player1.Ycoordinate);
	}

	public void render(Graphics g) {
		
		g.drawImage(Assets.background, 400, 0, null);
		g.drawImage(Assets.background2, 0, 0, null);
		// timer
		g.drawImage(Assets.block, 0, 0, 400, 150,null);
		g.drawImage(Assets.block, 0, 150, 400, 150,null);
		g.drawImage(Assets.block, 0, 300, 400, 150,null);
		g.drawImage(Assets.block, 0, 450, 400, 150,null);
		
		g.drawImage(Assets.blue_head, 0,0,148,148,null);
		g.drawImage(Assets.blue_head, 0,150,148,148,null);
		g.drawImage(Assets.blue_head, 0,300,148,148,null);
		g.drawImage(Assets.blue_head, 0,450,148,148,null);
		
		
		g.drawImage(Assets.t, 60, 779, 100, 100, null);
		g.drawImage(Assets.i, 130, 780, 100, 100, null);
		g.drawImage(Assets.m, 200, 780, 100, 100, null);
		g.drawImage(Assets.e, 280, 785, 100, 100, null);
		g.drawImage(Assets.colon, 140, 880, 60, 90, null);
		switch (Game.minute) {// 1

		case 1: {
			g.drawImage(Assets.one, 50, 880, 80, 100, null);
			break;
		}
		case 2: {
			g.drawImage(Assets.two, 50, 880, 80, 100, null);
			break;
		}
		case 3: {
			g.drawImage(Assets.three, 50, 880, 80, 100, null);
			break;
		}
		default: {
			g.drawImage(Assets.zero, 50, 880, 80, 100, null);
			break;
		}

		}// 1

		switch (Game.second / 10) {
		case 0: {
			g.drawImage(Assets.zero, 200, 880, 80, 100, null);
			break;
		}
		case 1: {
			g.drawImage(Assets.one, 200, 880, 80, 100, null);
			break;
		}
		case 2: {
			g.drawImage(Assets.two, 200, 880, 80, 100, null);
			break;
		}
		case 3: {
			g.drawImage(Assets.three, 200, 880, 80, 100, null);
			break;
		}
		case 4: {
			g.drawImage(Assets.four, 200, 880, 80, 100, null);
			break;
		}
		case 5: {
			g.drawImage(Assets.five, 200, 880, 80, 100, null);
			break;
		}
		case 6: {
			g.drawImage(Assets.six, 200, 880, 80, 120, null);
			break;
		}
		case 7: {
			g.drawImage(Assets.seven, 200, 880, 80, 120, null);
			break;
		}
		case 8: {
			g.drawImage(Assets.eight, 200, 880, 80, 100, null);
			break;
		}
		case 9: {
			g.drawImage(Assets.nine, 200, 880, 80, 100, null);
			break;
		}
		default: {
			g.drawImage(Assets.zero, 200, 880, 80, 100, null);
			break;
		}
		}

		switch (Game.second % 10) {
		case 0: {
			g.drawImage(Assets.zero, 300, 880, 80, 100, null);
			break;
		}
		case 1: {
			g.drawImage(Assets.one, 300, 880, 80, 100, null);
			break;
		}
		case 2: {
			g.drawImage(Assets.two, 300, 880, 80, 100, null);
			break;
		}
		case 3: {
			g.drawImage(Assets.three, 300, 880, 80, 100, null);
			break;
		}
		case 4: {
			g.drawImage(Assets.four, 300, 880, 80, 100, null);
			break;
		}
		case 5: {
			g.drawImage(Assets.five, 300, 880, 80, 100, null);
			break;
		}
		case 6: {
			g.drawImage(Assets.six, 300, 880, 80, 110, null);
			break;
		}
		case 7: {
			g.drawImage(Assets.seven, 300, 880, 80, 110, null);
			break;
		}
		case 8: {
			g.drawImage(Assets.eight, 300, 880, 80, 100, null);
			break;
		}
		case 9: {
			g.drawImage(Assets.nine, 300, 880, 80, 100, null);
			break;
		}
		default: {
			g.drawImage(Assets.zero, 200, 880, 80, 100, null);
			break;
		}
		}

		String s3 = "0,0 0,1 0,2 0,3 0,4 0,5 0,6 0,7 0,8 1,0 1,2 1,4 1,6 1,8 2,0 2,1 2,2 2,3 2,4 2,5 2,6 2,7 2,8 3,0 3,1 3,3 3,5 3,7 4,0 4,1 4,2 4,3 4,4 4,5 4,6 4,7 4,8 5,1 5,2 5,5 5,7 5,8 6,0 6,1 6,2 6,3 6,4 6,5 6,6 6,7 6,8 7,2 7,4 7,6 8,2 8,3 8,4 8,5 8,6 -1,2 -1,4 -2,2 -2,3 -2,4 -2,5";
		String[] tokens5 = s3.split(" ");
		for (String token : tokens5) {
			String[] tokens6 = token.split(",");
			String x = tokens6[0];
			String y = tokens6[1];
			if (Game.box_exist[Integer.valueOf(x) + 2][Integer.valueOf(y)])
				g.drawImage(Assets.box, 650 + (Integer.valueOf(x) * 100), 55 + (Integer.valueOf(y) * 100), null);
		}

		for (int i = 0; i < 50; i++) {
			if (bomb[i] != null) {

				if (fourth_bb[i]) {
					Game.bomb_exist[bomb[i].getB_x()][bomb[i].getB_y()] = true;
					
				}
				bomb[i].setB_duration();
				if (bomb[i].getB_duration() <= 1 && !Game.fire_exist[bomb[i].getB_x()][bomb[i].getB_y()]) {// put bomb
					//explosion_sound = false;
					if (Game.bomb_exist[bomb[i].getB_x()][bomb[i].getB_y()])
						g.drawImage(Assets.bomb, bomb[i].getB_x() * 100 + 455, bomb[i].getB_y() * 100 + 65,bomb[i].getSize(), bomb[i].getSize(), null);
					bomb[i].setSize();
					Game.go[bomb[i].getB_x()][bomb[i].getB_y()] = false;
					
				} else {// start fire
					
					fourth_bb[i] = false;
					Game.bomb_exist[bomb[i].getB_x()][bomb[i].getB_y()] = false;
					Game.go[bomb[i].getB_x()][bomb[i].getB_y()] = true;
					if (bomb[i].isFirst()) {// bomb's range now
						explosion_sound = true;
						bomb[i].setFirst(false);
						for (int j = 1; j <= bomb[i].getRange(); j++) {// right(1)
							if (bomb[i].getB_x() + j >= 0 && bomb[i].getB_x() + j < 11) { // set the positions of the
																							// walls(2)
								if (!Game.go[bomb[i].getB_x() + j][bomb[i].getB_y()]
										&& !Game.bomb_exist[bomb[i].getB_x() + j][bomb[i].getB_y()]) { // detect the
																										// obstacles
																										// exist or
									// not(3)
									if (Game.box_exist[bomb[i].getB_x() + j][bomb[i].getB_y()]) {// detect boxes(4)
										Game.box_exist[bomb[i].getB_x() + j][bomb[i].getB_y()] = false;
										Game.go[bomb[i].getB_x() + j][bomb[i].getB_y()] = true;
										Game.props[bomb[i].getB_x() + j][bomb[i].getB_y()] = new Props();
										bomb[i].setRight(j);
										break;
									} // (4)
									else {// (5)
										bomb[i].setRight(j - 1);// set range that touch the obstacles not include boxes
										break;
									} // (5)
								} // (3)}
							} // (2)
							else {// detect walls(6)
								bomb[i].setRight(j - 1);
								break;
							} // (6)
							bomb[i].setRight(j);
						} // (1)
						for (int j = 1; j <= bomb[i].getRange(); j++) {// left
							if (bomb[i].getB_x() - j >= 0 && bomb[i].getB_x() - j < 11) {// set the positions of the
																							// walls(2)
								if (!Game.go[bomb[i].getB_x() - j][bomb[i].getB_y()]
										&& !Game.bomb_exist[bomb[i].getB_x() - j][bomb[i].getB_y()]) {// detect the
																										// obstacles
																										// exist or
									// not(3)
									if (Game.box_exist[bomb[i].getB_x() - j][bomb[i].getB_y()]) {// detect boxes(4)
										Game.box_exist[bomb[i].getB_x() - j][bomb[i].getB_y()] = false;
										Game.go[bomb[i].getB_x() - j][bomb[i].getB_y()] = true;
										Game.props[bomb[i].getB_x() - j][bomb[i].getB_y()] = new Props();
										g.drawImage(Assets.fire_r, bomb[i].getB_x() * 100 + 458,bomb[i].getB_y() * 100 + 59, -j * 100 - 17, 90, null);// left
										bomb[i].setLeft(j);
										break;
									} // (4)
									else {// (5)
										bomb[i].setLeft(j - 1);// set range that touch the obstacles not include boxes
										break;
									} // (5)
								} // (3)
							} // (2)
							else {// detect walls(6)
								bomb[i].setLeft(j - 1);
								break;
							} // (6)
							bomb[i].setLeft(j);
						} // (1)
						for (int j = 1; j <= bomb[i].getRange(); j++) {// up
							if (bomb[i].getB_y() - j >= 0 && bomb[i].getB_y() - j < 9) {
								if (!Game.go[bomb[i].getB_x()][bomb[i].getB_y() - j]
										&& !Game.bomb_exist[bomb[i].getB_x()][bomb[i].getB_y() - j]) {

									if (Game.box_exist[bomb[i].getB_x()][bomb[i].getB_y() - j]) {
										Game.box_exist[bomb[i].getB_x()][bomb[i].getB_y() - j] = false;
										Game.go[bomb[i].getB_x()][bomb[i].getB_y() - j] = true;
										Game.props[bomb[i].getB_x()][bomb[i].getB_y() - j] = new Props();
										g.drawImage(Assets.fire_d, bomb[i].getB_x() * 100 + 458,bomb[i].getB_y() * 100 + 67, 90, -j * 100 - 17, null);// 銝�
										bomb[i].setUp(j);
										break;
									} else {
										bomb[i].setUp(j - 1);
										break;
									}
								}
							} else {
								bomb[i].setUp(j - 1);
								break;
							}
							bomb[i].setUp(j);
						}
						for (int j = 1; j <= bomb[i].getRange(); j++) {// bottom
							if (bomb[i].getB_y() + j >= 0 && bomb[i].getB_y() + j < 9) {
								if (!Game.go[bomb[i].getB_x()][bomb[i].getB_y() + j]
										&& !Game.bomb_exist[bomb[i].getB_x()][bomb[i].getB_y() + j]) {
									if (Game.box_exist[bomb[i].getB_x()][bomb[i].getB_y() + j]) {
										Game.box_exist[bomb[i].getB_x()][bomb[i].getB_y() + j] = false;
										Game.go[bomb[i].getB_x()][bomb[i].getB_y() + j] = true;
										Game.props[bomb[i].getB_x()][bomb[i].getB_y() + j] = new Props();
										g.drawImage(Assets.fire_d, bomb[i].getB_x() * 100 + 458,bomb[i].getB_y() * 100 + 145, 90, j * 100 + 17, null);// 銝�
										bomb[i].setDown(j);
										break;
									} else {
										bomb[i].setDown(j - 1);
										break;
									}
								}
							} else {
								bomb[i].setDown(j - 1);
								break;
							}
							bomb[i].setDown(j);
						}
					}
					if (bomb[i].getF_duration() == 2 && second_bb[i]) {// normal
						for (int hi = 0; hi <= bomb[i].getRight(); hi++)
							Game.fire_exist[bomb[i].getB_x() + hi][bomb[i].getB_y()] = true;
						for (int hi = 0; hi <= bomb[i].getLeft(); hi++)
							Game.fire_exist[bomb[i].getB_x() - hi][bomb[i].getB_y()] = true;
						for (int hi = 0; hi <= bomb[i].getUp(); hi++)
							Game.fire_exist[bomb[i].getB_x()][bomb[i].getB_y() - hi] = true;
						for (int hi = 0; hi <= bomb[i].getDown(); hi++)
							Game.fire_exist[bomb[i].getB_x()][bomb[i].getB_y() + hi] = true;
						g.drawImage(Assets.fire, bomb[i].getB_x() * 100 + 455, bomb[i].getB_y() * 100 + 60, 93, 93,null);
						g.drawImage(Assets.fire_r, bomb[i].getB_x() * 100 + 530, bomb[i].getB_y() * 100 + 59,bomb[i].getRight() * 100 + 20, 90, null);// right
						g.drawImage(Assets.fire_r, bomb[i].getB_x() * 100 + 458, bomb[i].getB_y() * 100 + 59,-bomb[i].getLeft() * 100 - 17, 90, null);// left
						g.drawImage(Assets.fire_d, bomb[i].getB_x() * 100 + 458, bomb[i].getB_y() * 100 + 67, 90,-bomb[i].getUp() * 100 - 17, null);// up
						g.drawImage(Assets.fire_d, bomb[i].getB_x() * 100 + 458, bomb[i].getB_y() * 100 + 145, 90,bomb[i].getDown() * 100 + 17, null);// down
						third_bb[i] = false;

					} else if (!Game.bomb_exist[bomb[i].getB_x()][bomb[i].getB_y()] && third_bb[i]) {// bomb together
						second_bb[i] = false;
						if (first_bb[i]) {
							start_time[i] = System.nanoTime();
							first_bb[i] = false;
						}
						bomb[i].setE_duration(i);
						if (bomb[i].getE_duration() >= 1) {
							for (int hi = 0; hi <= bomb[i].getRight(); hi++)
								Game.fire_exist[bomb[i].getB_x() + hi][bomb[i].getB_y()] = false;
							for (int hi = 0; hi <= bomb[i].getLeft(); hi++)
								Game.fire_exist[bomb[i].getB_x() - hi][bomb[i].getB_y()] = false;
							for (int hi = 0; hi <= bomb[i].getUp(); hi++)
								Game.fire_exist[bomb[i].getB_x()][bomb[i].getB_y() - hi] = false;
							for (int hi = 0; hi <= bomb[i].getDown(); hi++)
								Game.fire_exist[bomb[i].getB_x()][bomb[i].getB_y() + hi] = false;
							bomb[i] = null;
						} else {
							for (int hi = 0; hi <= bomb[i].getRight(); hi++)
								Game.fire_exist[bomb[i].getB_x() + hi][bomb[i].getB_y()] = true;
							for (int hi = 0; hi <= bomb[i].getLeft(); hi++)
								Game.fire_exist[bomb[i].getB_x() - hi][bomb[i].getB_y()] = true;
							for (int hi = 0; hi <= bomb[i].getUp(); hi++)
								Game.fire_exist[bomb[i].getB_x()][bomb[i].getB_y() - hi] = true;
							for (int hi = 0; hi <= bomb[i].getDown(); hi++)
								Game.fire_exist[bomb[i].getB_x()][bomb[i].getB_y() + hi] = true;
							g.drawImage(Assets.fire, bomb[i].getB_x() * 100 + 455, bomb[i].getB_y() * 100 + 60, 93, 93,
									null);
							g.drawImage(Assets.fire_r, bomb[i].getB_x() * 100 + 530, bomb[i].getB_y() * 100 + 59,
									bomb[i].getRight() * 100 + 20, 90, null);// right
							g.drawImage(Assets.fire_r, bomb[i].getB_x() * 100 + 458, bomb[i].getB_y() * 100 + 59,
									-bomb[i].getLeft() * 100 - 17, 90, null);// left
							g.drawImage(Assets.fire_d, bomb[i].getB_x() * 100 + 458, bomb[i].getB_y() * 100 + 67, 90,
									-bomb[i].getUp() * 100 - 17, null);// up
							g.drawImage(Assets.fire_d, bomb[i].getB_x() * 100 + 458, bomb[i].getB_y() * 100 + 145, 90,
									bomb[i].getDown() * 100 + 17, null);// down

						}
					} else {
						for (int hi = 0; hi <= bomb[i].getRight(); hi++)
							Game.fire_exist[bomb[i].getB_x() + hi][bomb[i].getB_y()] = false;
						for (int hi = 0; hi <= bomb[i].getLeft(); hi++)
							Game.fire_exist[bomb[i].getB_x() - hi][bomb[i].getB_y()] = false;
						for (int hi = 0; hi <= bomb[i].getUp(); hi++)
							Game.fire_exist[bomb[i].getB_x()][bomb[i].getB_y() - hi] = false;
						for (int hi = 0; hi <= bomb[i].getDown(); hi++)
							Game.fire_exist[bomb[i].getB_x()][bomb[i].getB_y() + hi] = false;
					}
				}

			} else {

				bomb[i] = null;
			}

		}

		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 9; j++) {
				if (Game.props[i][j] != null) {
					switch (Game.props[i][j].id) {
					case 1: {
						g.drawImage(Assets.inventory, i * 100 + 440, j * 100 + 50, 120, 120, null);
						break;
					}
					case 2: {
						g.drawImage(Assets.power, i * 100 + 460, j * 100 + 60, 80, 80, null);
						break;
					}
					case 3: {
						g.drawImage(Assets.speed, i * 100 + 460, j * 100 + 60, 80, 80, null);
						break;
					}
					default: {
						Game.props[i][j] = null;
						break;
					}

					}
				}
			}
		}
		String s1 = "540,280 538,680 540,770 740,278 740,75 740,480 940,175 940,580 1140,275 1140,375 1135,580 1335,480";
		String[] tokens = s1.split(" ");
		for (String token : tokens) {
			String[] tokens2 = token.split(",");
			String x = tokens2[0];
			String y = tokens2[1];
			g.drawImage(Assets.obstacle1, Integer.valueOf(x), Integer.valueOf(y), null);
		}
		String s2 = "520,65 520,465 920,365 720,665 920,750 1320,65 1320,265 1320,665 1120,-35";
		String[] tokens3 = s2.split(" ");
		for (String token : tokens3) {
			String[] tokens4 = token.split(",");
			String x = tokens4[0];
			String y = tokens4[1];
			g.drawImage(Assets.obstacle2, Integer.valueOf(x), Integer.valueOf(y), null);
		}

		player1.render(g);

		if(Setting_page.Player_Number == 2) {
			player2.render(g);
		}
		ai1.render(g,1);
		ai2.render(g,2);
		if(Setting_page.Player_Number == 1) {
			ai3.render(g,2);
		}

	}
	
}