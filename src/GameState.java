import java.awt.Graphics;

public class GameState extends State implements GameStateDefault{

	private Player player1;
	public static Bomb[] bomb = new Bomb[50]; 
	public GameState(Game game){
		player1 = new Player(game, DEFAULT_MIN_X, DEFAULT_MIN_Y);
	}
	
	public void tick() {
		player1.tick();
	}

	public void render(Graphics g) {
		g.drawImage(Assets.background, 400 ,0, null);
		String s3 = "0,0 0,1 0,2 0,3 0,4 0,5 0,6 0,7 0,8 1,0 1,2 1,4 1,6 1,8 2,0 2,1 2,2 2,3 2,4 2,5 2,6 2,7 2,8 3,0 3,1 3,3 3,5 3,7 4,0 4,1 4,2 4,3 4,4 4,5 4,6 4,7 4,8 5,1 5,2 5,5 5,7 5,8 6,0 6,1 6,2 6,3 6,4 6,5 6,6 6,7 6,8 7,2 7,4 7,6 8,2 8,3 8,4 8,5 8,6 -1,2 -1,4 -2,2 -2,3 -2,4 -2,5";
		String[] tokens5 = s3.split(" ");
		for (String token:tokens5) {
			String[] tokens6 = token.split(",");
			String x = tokens6[0];
			String y = tokens6[1];
			if(!Game.go[Integer.valueOf(x)+2][Integer.valueOf(y)])	g.drawImage(Assets.box, 650+(Integer.valueOf(x)*100) , 55+(Integer.valueOf(y)*100), null);	
		}
		
		
		for(int i = 0; i < 50; i++)	{
			if(bomb[i] != null) {
				bomb[i].setB_duration();
				if(bomb[i].getB_duration() <= 1)	{//炸彈還沒爆
					g.drawImage(Assets.bomb, bomb[i].getB_x()*100+455, bomb[i].getB_y()*100+65,80,80, null);
				}
				else {
					if(bomb[i].isFirst()) {
				
						bomb[i].setFirst(false);
						for(int j = 1; j <= bomb[i].getRange(); j++) {//右
							if(bomb[i].getB_x()+j >= 0 && bomb[i].getB_x()+j < 11) {
								if(Game.box_exist[bomb[i].getB_x()+j][bomb[i].getB_y()])	{
									Game.box_exist[bomb[i].getB_x()+j][bomb[i].getB_y()] = false;
									Game.go[bomb[i].getB_x()+j][bomb[i].getB_y()] = true;
									bomb[i].setRight(j);
									break;
								}
							}
							bomb[i].setRight(j);
						}
						for(int j = 1; j <= bomb[i].getRange(); j++) {//左
							if(bomb[i].getB_x()-j >= 0 && bomb[i].getB_x()-j < 11) {
								if(Game.box_exist[bomb[i].getB_x()-j][bomb[i].getB_y()])	{
									Game.box_exist[bomb[i].getB_x()-j][bomb[i].getB_y()] = false;
									Game.go[bomb[i].getB_x()-j][bomb[i].getB_y()] = true;
									g.drawImage(Assets.fire_r , bomb[i].getB_x()*100+458 , bomb[i].getB_y()*100+59 ,-j*100-17,90,null);//左
									bomb[i].setLeft(j);
									break;
								}
							}
							bomb[i].setLeft(j);
						}
						for(int j = 1; j <= bomb[i].getRange(); j++) {//上
							if(bomb[i].getB_y()-j >= 0 && bomb[i].getB_y()-j < 9) {
								if(Game.box_exist[bomb[i].getB_x()][bomb[i].getB_y()-j])	{
									Game.box_exist[bomb[i].getB_x()][bomb[i].getB_y()-j] = false;
									Game.go[bomb[i].getB_x()][bomb[i].getB_y()-j] = true;
									g.drawImage(Assets.fire_d , bomb[i].getB_x()*100+458 , bomb[i].getB_y()*100+67,90,-j*100-17,null);//上
									bomb[i].setUp(j);
									break;
								}
							}
							bomb[i].setUp(j);
						}
						for(int j = 1; j <= bomb[i].getRange(); j++) {//下
							if(bomb[i].getB_y()+j >= 0 && bomb[i].getB_y()+j < 9) {
								if(Game.box_exist[bomb[i].getB_x()][bomb[i].getB_y()+j])	{
									Game.box_exist[bomb[i].getB_x()][bomb[i].getB_y()+j] = false;
									Game.go[bomb[i].getB_x()][bomb[i].getB_y()+j] = true;
									g.drawImage(Assets.fire_d , bomb[i].getB_x()*100+458, bomb[i].getB_y()*100+145 ,90,j*100+17,null);//下
									bomb[i].setDown(j);
									break;
							}
						}
							bomb[i].setDown(j);
						}
					}
					if(bomb[i].getF_duration() == 2) {
						g.drawImage(Assets.fire , bomb[i].getB_x()*100+455, bomb[i].getB_y()*100+60 ,93,93,null);
						g.drawImage(Assets.fire_r , bomb[i].getB_x()*100+530 , bomb[i].getB_y()*100+59 ,bomb[i].getRight()*100+20,90,null);//右
						g.drawImage(Assets.fire_r , bomb[i].getB_x()*100+458 , bomb[i].getB_y()*100+59 ,-bomb[i].getLeft()*100-17,90,null);//左
						g.drawImage(Assets.fire_d , bomb[i].getB_x()*100+458 , bomb[i].getB_y()*100+67,90,-bomb[i].getUp()*100-17,null);//上
						g.drawImage(Assets.fire_d , bomb[i].getB_x()*100+458, bomb[i].getB_y()*100+145 ,90,bomb[i].getDown()*100+17,null);//下
					}
				}
				
				/*else 
					
					

					
					
					
						else 	g.drawImage(Assets.fire_r , bomb[i].getB_x()*100+530 , bomb[i].getB_y()*100+59 ,bomb[i].getRange()*100+20,90,null);//右
					}
					
						else	g.drawImage(Assets.fire_r , bomb[i].getB_x()*100+458 , bomb[i].getB_y()*100+59 ,-bomb[i].getRange()*100-17,90,null);//左
					}
					
						else 	g.drawImage(Assets.fire_d , bomb[i].getB_x()*100+458 , bomb[i].getB_y()*100+67,90,-bomb[i].getRange()*100-17,null);//上
					}
					
						else		g.drawImage(Assets.fire_d , bomb[i].getB_x()*100+458, bomb[i].getB_y()*100+145 ,90,bomb[i].getRange()*100+17,null);//		
						}
						
				

				}*/
						//炸彈爆了
			}
			else bomb[i] = null;		
		}
		String s1 = "540,280 538,680 540,770 740,278 740,75 740,480 940,175 940,580 1140,275 1140,375 1135,580 1335,480";
		String[] tokens = s1.split(" ");
		for (String token:tokens) {
			String[] tokens2 = token.split(",");
			String x = tokens2[0];
			String y = tokens2[1];
			g.drawImage(Assets.obstacle1, Integer.valueOf(x) , Integer.valueOf(y), null);	
		}
		String s2 = "520,65 520,465 920,365 720,665 920,750 1320,65 1320,265 1320,665 1120,-35";
		String[] tokens3 = s2.split(" ");
		for (String token:tokens3) {
			String[] tokens4 = token.split(",");
			String x = tokens4[0];
			String y = tokens4[1];
			g.drawImage(Assets.obstacle2, Integer.valueOf(x) , Integer.valueOf(y), null);	
		}
		player1.render(g);

	}
}

