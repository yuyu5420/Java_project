
import java.awt.Graphics;
import java.util.Random;

public class AI {
	double x, y, speed = 5;
	int bomb_number = 1, fire_range = 1;
	boolean right = false, left = false, up = false, down = false, bomb = true;
	int width = 100, height = 125;
	Game game;
	int cnt = 0;
	int temp = 0;
	int box_x, box_y;
	int hello = 0;
	protected Random random_num = new Random();

	public AI(Game game, int xcoordinate, int ycoordinate) {
		this.x = xcoordinate;
		this.y = ycoordinate;
		this.game = game;
		this.box_x = (int) ((x - 445) / 100);
		this.box_y = (int) ((y - 5) / 100);
	}

	public void tick() {
		if ((temp - Game.time) >= 3) {
			bomb = true;
		}
		box_x = (int) ((x - 445) / 100);
		box_y = (int) ((y - 5) / 100);
		
		decide_direction();

		

		if (right) {
			x += speed;
			cnt++;

		}

		else if (up) {
			y -= speed;
			cnt++;
		}

		else if (down) {
			y += speed;
			cnt++;
		} else if (left) {
			x -= speed;
			cnt++;
		}

	}

	public void render(Graphics g, int number) {

		if(number ==1) {
		if (cnt == 0) {
			g.drawImage(Assets.purple_down[0], (int) x, (int) y, width, height, null);
		}
		if (right) {
			hello = 1;
			g.drawImage(Assets.purple_right[cnt % 2], (int) x, (int) y, width, height, null);
		} else if (left) {
			hello = 2;
			g.drawImage(Assets.purple_left[cnt % 2], (int) x, (int) y, width, height, null);

		} else if (up) {
			hello = 3;
			g.drawImage(Assets.purple_up[cnt % 2], (int) x, (int) y, width, height, null);

		} else if (down) {
			hello = 4;
			g.drawImage(Assets.purple_down[cnt % 2], (int) x, (int) y, width, height, null);

		} else {
			switch (hello) {
			case 1:
				g.drawImage(Assets.purple_right[cnt % 2], (int) x, (int) y, width, height, null);
				break;

			case 2:
				g.drawImage(Assets.purple_left[cnt % 2], (int) x, (int) y, width, height, null);
				break;

			case 3:
				g.drawImage(Assets.purple_up[cnt % 2], (int) x, (int) y, width, height, null);
				break;

			case 4:
				g.drawImage(Assets.purple_down[cnt % 2], (int) x, (int) y, width, height, null);
				break;

			}
		
		}
		}
			if(number ==2) {
			if (cnt == 0) {
				g.drawImage(Assets.black_down[0], (int) x, (int) y, width, height, null);
			}
			if (right) {
				hello = 1;
				g.drawImage(Assets.black_right[cnt % 2], (int) x, (int) y, width, height, null);
			} else if (left) {
				hello = 2;
				g.drawImage(Assets.black_left[cnt % 2], (int) x, (int) y, width, height, null);

			} else if (up) {
				hello = 3;
				g.drawImage(Assets.black_up[cnt % 2], (int) x, (int) y, width, height, null);

			} else if (down) {
				hello = 4;
				g.drawImage(Assets.black_down[cnt % 2], (int) x, (int) y, width, height, null);

			} else {
				switch (hello) {
				case 1:
					g.drawImage(Assets.black_right[cnt % 2], (int) x, (int) y, width, height, null);
					break;

				case 2:
					g.drawImage(Assets.black_left[cnt % 2], (int) x, (int) y, width, height, null);
					break;

				case 3:
					g.drawImage(Assets.black_up[cnt % 2], (int) x, (int) y, width, height, null);
					break;

				case 4:
					g.drawImage(Assets.black_down[cnt % 2], (int) x, (int) y, width, height, null);
					break;

				}
			}
			

		}

		arrive_destination();
	}

	public void arrive_destination() {

		box_x = (int) ((x - 445) / 100);
		box_y = (int) ((y - 5) / 100);

		if (right || left || up || down) {
			if (x % 100 == 45 && y % 100 == 5) {
				right = false;
				left = false;
				up = false;
				down = false;

				if (bomb) {
					if (box_y - 1 >= 0) {
						if (Game.box_exist[box_x][box_y - 1]) {
							if (KeyManager.bomb_counter == 50)
								KeyManager.bomb_counter = 0;
							GameState.bomb[KeyManager.bomb_counter] = new Bomb(box_x, box_y, fire_range);
							GameState.first_bb[KeyManager.bomb_counter] = true;
							GameState.second_bb[KeyManager.bomb_counter] = true;
							GameState.third_bb[KeyManager.bomb_counter] = true;
							GameState.fourth_bb[KeyManager.bomb_counter] = true;
							KeyManager.bomb_counter++;
							bomb = false;
							temp = Game.time;
						}
					}
					if (box_y + 1 < 9) {
						if (Game.box_exist[box_x][box_y + 1]) {
							if (KeyManager.bomb_counter == 50)
								KeyManager.bomb_counter = 0;
							GameState.bomb[KeyManager.bomb_counter] = new Bomb(box_x, box_y, fire_range);
							GameState.first_bb[KeyManager.bomb_counter] = true;
							GameState.second_bb[KeyManager.bomb_counter] = true;
							GameState.third_bb[KeyManager.bomb_counter] = true;
							GameState.fourth_bb[KeyManager.bomb_counter] = true;
							KeyManager.bomb_counter++;
							bomb = false;
							temp = Game.time;
						}
					}
					if (box_x - 1 >= 0) {
						if (Game.box_exist[box_x - 1][box_y]) {
							if (KeyManager.bomb_counter == 50)
								KeyManager.bomb_counter = 0;
							GameState.bomb[KeyManager.bomb_counter] = new Bomb(box_x, box_y, fire_range);
							GameState.first_bb[KeyManager.bomb_counter] = true;
							GameState.second_bb[KeyManager.bomb_counter] = true;
							GameState.third_bb[KeyManager.bomb_counter] = true;
							GameState.fourth_bb[KeyManager.bomb_counter] = true;
							KeyManager.bomb_counter++;
							bomb = false;
							temp = Game.time;
						}
					}
					if (box_x + 1 < 11) {
						if (Game.box_exist[box_x + 1][box_y]) {
							if (KeyManager.bomb_counter == 50)
								KeyManager.bomb_counter = 0;
							GameState.bomb[KeyManager.bomb_counter] = new Bomb(box_x, box_y, fire_range);
							GameState.first_bb[KeyManager.bomb_counter] = true;
							GameState.second_bb[KeyManager.bomb_counter] = true;
							GameState.third_bb[KeyManager.bomb_counter] = true;
							GameState.fourth_bb[KeyManager.bomb_counter] = true;
							KeyManager.bomb_counter++;
							bomb = false;
							temp = Game.time;
						}
					}

				}

			}
		}
	}

	public void decide_direction() {

		if (!right && !left && !up && !down) {

			
			if ((box_x + 1) < 11) {
				if (Game.go[box_x + 1][box_y]) {
					right = true;
					if (box_x + 2 < 11) {
						if (Game.bomb_exist[box_x + 2][box_y] || Game.fire_exist[box_x + 2][box_y])
							right = false;
					}
					if (box_x + 3 < 11) {
						if (Game.bomb_exist[box_x + 3][box_y] || Game.fire_exist[box_x + 3][box_y])
							right = false;
					}
					if (box_x + 4 < 11) {
						if (Game.bomb_exist[box_x + 4][box_y] || Game.fire_exist[box_x + 4][box_y])
							right = false;
					}
					if (box_x >= 0) {
						if (Game.bomb_exist[box_x][box_y] || Game.fire_exist[box_x][box_y])
							right = false;
					}
					if (box_x - 1 >= 0) {
						if (Game.bomb_exist[box_x - 1][box_y] || Game.fire_exist[box_x - 1][box_y])
							right = false;
					}
					if (box_x - 2 >= 0) {
						if (Game.bomb_exist[box_x - 2][box_y] || Game.fire_exist[box_x - 2][box_y])
							right = false;
					}
					if (box_y + 1 < 9) {
						if (Game.bomb_exist[box_x + 1][box_y + 1] || Game.fire_exist[box_x + 1][box_y + 1])
							right = false;
					}
					if (box_y + 2 < 9) {
						if (Game.bomb_exist[box_x + 1][box_y + 2] || Game.fire_exist[box_x + 1][box_y + 2])
							right = false;
					}
					if (box_y + 3 < 9) {
						if (Game.bomb_exist[box_x + 1][box_y + 3] || Game.fire_exist[box_x + 1][box_y + 3])
							right = false;
					}
					if (box_y - 1 >= 0) {
						if (Game.bomb_exist[box_x + 1][box_y - 1] || Game.fire_exist[box_x + 1][box_y - 1])
							right = false;
					}
					if (box_y - 2 >= 0) {
						if (Game.bomb_exist[box_x + 1][box_y - 2] || Game.fire_exist[box_x + 1][box_y - 2])
							right = false;
					}
					if (box_y - 3 >= 0) {
						if (Game.bomb_exist[box_x + 1][box_y - 3] || Game.fire_exist[box_x + 1][box_y - 3])
							right = false;
					}
				}
			}

			if ((box_y + 1) < 9) {
				if (Game.go[box_x][box_y + 1]) {
					down = true;
					if (box_x + 1 < 11) {
						if (Game.bomb_exist[box_x + 1][box_y + 1] || Game.fire_exist[box_x + 1][box_y + 1])
							down = false;
					}
					if (box_x + 2 < 11) {
						if (Game.bomb_exist[box_x + 2][box_y + 1] || Game.fire_exist[box_x + 2][box_y + 1])
							down = false;
					}
					if (box_x + 3 < 11) {
						if (Game.bomb_exist[box_x + 3][box_y + 1] || Game.fire_exist[box_x + 3][box_y + 1])
							down = false;
					}
					if (box_x - 1 >= 0) {
						if (Game.bomb_exist[box_x - 1][box_y + 1] || Game.fire_exist[box_x - 1][box_y + 1])
							down = false;
					}
					if (box_x - 2 >= 0) {
						if (Game.bomb_exist[box_x - 2][box_y + 1] || Game.fire_exist[box_x - 2][box_y + 1])
							down = false;
					}
					if (box_x - 3 >= 0) {
						if (Game.bomb_exist[box_x - 3][box_y + 1] || Game.fire_exist[box_x - 3][box_y + 1])
							down = false;
					}
					if (box_y + 2 < 9) {
						if (Game.bomb_exist[box_x][box_y + 2] || Game.fire_exist[box_x][box_y + 2])
							down = false;
					}
					if (box_y + 3 < 9) {
						if (Game.bomb_exist[box_x][box_y + 3] || Game.fire_exist[box_x][box_y + 3])
							down = false;
					}
					if (box_y + 4 < 9) {
						if (Game.bomb_exist[box_x][box_y + 4] || Game.fire_exist[box_x][box_y + 4])
							down = false;
					}
					if (box_y >= 0) {
						if (Game.bomb_exist[box_x][box_y] || Game.fire_exist[box_x][box_y])
							down = false;
					}
					if (box_y - 1 >= 0) {
						if (Game.bomb_exist[box_x][box_y - 1] || Game.fire_exist[box_x][box_y - 1])
							down = false;
					}
					if (box_y - 2 >= 0) {
						if (Game.bomb_exist[box_x][box_y - 2] || Game.fire_exist[box_x][box_y - 2])
							down = false;
					}
				}
			}
			if ((box_x - 1) >= 0) {
				if (Game.go[box_x - 1][box_y]) {
					left = true;
					if (box_x < 11) {
						if (Game.bomb_exist[box_x][box_y] || Game.fire_exist[box_x][box_y])
							left = false;
					}
					if (box_x + 1 < 11) {
						if (Game.bomb_exist[box_x + 1][box_y] || Game.fire_exist[box_x + 1][box_y])
							left = false;
					}
					if (box_x + 2 < 11) {
						if (Game.bomb_exist[box_x + 2][box_y] || Game.fire_exist[box_x + 2][box_y])
							left = false;
					}
					if (box_x - 2 >= 0) {
						if (Game.bomb_exist[box_x - 2][box_y] || Game.fire_exist[box_x - 2][box_y])
							left = false;
					}
					if (box_x - 3 >= 0) {
						if (Game.bomb_exist[box_x - 3][box_y] || Game.fire_exist[box_x - 3][box_y])
							left = false;
					}
					if (box_x - 4 >= 0) {
						if (Game.bomb_exist[box_x - 4][box_y] || Game.fire_exist[box_x - 4][box_y])
							left = false;
					}

					if (box_y + 1 < 9) {
						if (Game.bomb_exist[box_x - 1][box_y + 1] || Game.fire_exist[box_x - 1][box_y + 1])
							left = false;
					}
					if (box_y + 2 < 9) {
						if (Game.bomb_exist[box_x - 1][box_y + 2] || Game.fire_exist[box_x - 1][box_y + 2])
							left = false;
					}
					if (box_y + 3 < 9) {
						if (Game.bomb_exist[box_x - 1][box_y + 3] || Game.fire_exist[box_x - 1][box_y + 3])
							left = false;
					}

					if (box_y - 1 >= 0) {
						if (Game.bomb_exist[box_x - 1][box_y - 1] || Game.fire_exist[box_x - 1][box_y - 1])
							left = false;
					}
					if (box_y - 2 >= 0) {
						if (Game.bomb_exist[box_x - 1][box_y - 2] || Game.fire_exist[box_x - 1][box_y - 2])
							left = false;
					}
					if (box_y - 3 >= 0) {
						if (Game.bomb_exist[box_x - 1][box_y - 3] || Game.fire_exist[box_x - 1][box_y - 3])
							left = false;
					}
				}
			}
			if ((box_y - 1) >= 0) {
				if (Game.go[box_x][box_y - 1]) {
					up = true;
					if (box_x + 1 < 11) {
						if (Game.bomb_exist[box_x + 1][box_y - 1] || Game.fire_exist[box_x + 1][box_y - 1])
							up = false;
					}
					if (box_x + 2 < 11) {
						if (Game.bomb_exist[box_x + 2][box_y - 1] || Game.fire_exist[box_x + 2][box_y - 1])
							up = false;
					}
					if (box_x + 3 < 11) {
						if (Game.bomb_exist[box_x + 3][box_y - 1] || Game.fire_exist[box_x + 3][box_y - 1])
							up = false;
					}

					if (box_x - 1 >= 0) {
						if (Game.bomb_exist[box_x - 1][box_y - 1] || Game.fire_exist[box_x - 1][box_y - 1])
							up = false;
					}
					if (box_x - 2 >= 0) {
						if (Game.bomb_exist[box_x - 2][box_y - 1] || Game.fire_exist[box_x - 2][box_y - 1])
							up = false;
					}
					if (box_x - 3 >= 0) {
						if (Game.bomb_exist[box_x - 3][box_y - 1] || Game.fire_exist[box_x - 3][box_y - 1])
							up = false;
					}

					if (box_y < 9) {
						if (Game.bomb_exist[box_x][box_y] || Game.fire_exist[box_x][box_y])
							up = false;
					}
					if (box_y + 1 < 9) {
						if (Game.bomb_exist[box_x][box_y + 1] || Game.fire_exist[box_x][box_y + 1])
							up = false;
					}
					if (box_y + 2 < 9) {
						if (Game.bomb_exist[box_x][box_y + 2] || Game.fire_exist[box_x][box_y + 2])
							up = false;
					}

					if (box_y - 2 >= 0) {
						if (Game.bomb_exist[box_x][box_y - 2] || Game.fire_exist[box_x][box_y - 2])
							up = false;
					}
					if (box_y - 3 >= 0) {
						if (Game.bomb_exist[box_x][box_y - 3] || Game.fire_exist[box_x][box_y - 3])
							up = false;
					}
					if (box_y - 4 >= 0) {
						if (Game.bomb_exist[box_x][box_y - 4] || Game.fire_exist[box_x][box_y - 4])
							up = false;
					}
				}
				if(right || down || left || up) {
					
					if (box_x - 1 >= 0 && box_y -1 >= 0) {
						if (Game.bomb_exist[box_x - 1][box_y -1] && Game.fire_exist[box_x - 1][box_y -1]) {
							up = false;
							left = false;
						}
					}
					if (box_x - 1 >= 0 && box_y +1 < 9) {
						if (Game.bomb_exist[box_x - 1][box_y +1] && Game.fire_exist[box_x - 1][box_y +1]) {
							down = false;
							left = false;
						}
					}
					if (box_x + 1 < 11  && box_y -1 >= 0) {
						if (Game.bomb_exist[box_x + 1][box_y -1] && Game.fire_exist[box_x + 1][box_y -1]) {
							up = false;
							right = false;
						}
					}
					if (box_x + 1 < 11 && box_y +1 < 9) {
						if (Game.bomb_exist[box_x + 1][box_y +1] && Game.fire_exist[box_x + 1][box_y +1]) {
							down = false;
							right = false;
						}
					}
				}
				
			}
			
			if(!right && !down && !left && !up) {
				
				if (box_x + 1 < 11 ) {
					if (Game.bomb_exist[box_x + 1][box_y] || Game.fire_exist[box_x + 1][box_y ]) {
						if (box_x -1 >= 0) {
							if(Game.go[box_x-1][box_y])	left = true;
						}
					}
				}
				if (box_x - 1 >= 0 ) {
					if (Game.bomb_exist[box_x - 1][box_y] || Game.fire_exist[box_x - 1][box_y ]) {
						if (box_x +1 < 11 ) {
							if(Game.go[box_x+1][box_y])	right = true;
						}
					}
				}
				if (box_y + 1 < 9 ) {
					if (Game.bomb_exist[box_x][box_y+1] || Game.fire_exist[box_x ][box_y +1]) {
						if (box_y -1 >= 0) {
							if(Game.go[box_x][box_y-1])	up = true;
						}
					}
				}
				if (box_y - 1 >= 0 ) {
					if (Game.bomb_exist[box_x][box_y-1] || Game.fire_exist[box_x][box_y -1]) {
						if (box_y +1 < 9) {
							if(Game.go[box_x][box_y+1])	down = true;
						}
					}
				}
			}
			if (right && down && left && up) {

				switch (random_num.nextInt(4)) {
				case 0:
					down = false;
					left = false;
					up = false;
					break;
				case 1:
					right = false;
					down = false;
					up = false;
					break;
				case 2:
					right = false;
					left = false;
					up = false;
					break;
				case 3:
					right = false;
					left = false;
					down = false;
					break;
				}
				return;
			}
			if (right && down && left) {

				switch (random_num.nextInt(3)) {
				case 0:
					down = false;
					left = false;
					break;
				case 1:
					right = false;
					down = false;
					break;
				case 2:
					right = false;
					left = false;
					break;
				}
				return;

			}
			if (right && down && up) {

				switch (random_num.nextInt(3)) {
				case 0:
					down = false;
					up = false;
					break;
				case 1:
					right = false;
					down = false;
					break;
				case 2:
					right = false;
					up = false;
					break;
				}
				return;

			}
			if (right && left && up) {

				switch (random_num.nextInt(3)) {
				case 0:
					left = false;
					up = false;
					break;
				case 1:
					right = false;
					up = false;
					break;
				case 2:
					right = false;
					left = false;
					break;
				}
				return;
			}
			if (down && left && up) {

				switch (random_num.nextInt(3)) {
				case 0:
					left = false;
					up = false;
					break;
				case 1:
					down = false;
					up = false;
					break;
				case 2:
					down = false;
					left = false;
					break;
				}
				return;
			}
			if (right && left) {

				switch (random_num.nextInt(2)) {
				case 0:
					left = false;
					break;
				case 1:
					right = false;
					break;

				}
				return;
			}
			if (up && down) {

				switch (random_num.nextInt(2)) {
				case 0:
					up = false;
					break;
				case 1:
					down = false;
					break;

				}
				return;
			}
			if (up && left) {

				switch (random_num.nextInt(2)) {
				case 0:
					up = false;
					break;
				case 1:
					left = false;
					break;

				}
				return;
			}

			if (up && right) {

				switch (random_num.nextInt(2)) {
				case 0:
					up = false;
					break;
				case 1:
					right = false;
					break;

				}
				return;
			}
			if (down && right) {

				switch (random_num.nextInt(2)) {
				case 0:
					down = false;
					break;
				case 1:
					right = false;
					break;

				}
				return;
			}
			if (down && left) {

				switch (random_num.nextInt(2)) {
				case 0:
					down = false;
					break;
				case 1:
					left = false;
					break;

				}
				return;
			}
		}
	}

	

}
