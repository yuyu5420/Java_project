import java.awt.Graphics;


public class GameState extends State {

	public GameState(){
		
	}
	
	public void tick() {
		
	}

	public void render(Graphics g) {
		g.drawImage(Assets.background, 400 ,0, null);
		g.drawImage(Assets.obstacle1, 540 ,280, null);	Game.go[1][3] = false;
		g.drawImage(Assets.obstacle1, 538 ,680, null);	Game.go[1][7] = false;
		g.drawImage(Assets.obstacle1, 540 ,770, null);	Game.go[1][8] = false;
		g.drawImage(Assets.obstacle1, 740 ,278, null);	Game.go[3][3] = false;
		g.drawImage(Assets.obstacle1, 740 ,75, null);	Game.go[3][1] = false;
		g.drawImage(Assets.obstacle1, 740 ,480, null);	Game.go[3][5] = false;
		g.drawImage(Assets.obstacle1, 940 ,175, null);	Game.go[5][2] = false;
		g.drawImage(Assets.obstacle1, 940 ,580, null);	Game.go[5][6] = false;
		g.drawImage(Assets.obstacle1, 1140 ,275, null);	Game.go[7][3] = false;
		g.drawImage(Assets.obstacle1, 1140 ,375, null);	Game.go[7][4] = false;
		g.drawImage(Assets.obstacle1, 1135 ,580, null);	Game.go[7][6] = false;
		g.drawImage(Assets.obstacle1, 1335 ,480, null);	Game.go[9][5] = false;
		g.drawImage(Assets.obstacle2,520,65,null);	Game.go[1][1] = false;
		g.drawImage(Assets.obstacle2,520,465,null);	Game.go[1][5] = false;
		g.drawImage(Assets.obstacle2,920,365,null);	Game.go[5][4] = false;
		g.drawImage(Assets.obstacle2,720,665,null);	Game.go[3][7] = false;
		g.drawImage(Assets.obstacle2,920,750,null);	Game.go[5][8] = false;
		g.drawImage(Assets.obstacle2,1320,65,null);	Game.go[9][1] = false;
		g.drawImage(Assets.obstacle2,1320,265,null);	Game.go[9][3] = false;
		g.drawImage(Assets.obstacle2,1320,665,null);	Game.go[9][7] = false;
		g.drawImage(Assets.obstacle2,1120,-35,null);	Game.go[7][0] = false;
		
	}

}