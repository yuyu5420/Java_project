import java.awt.Graphics;


public class GameState extends State {

	public GameState(){
		
	}
	
	public void tick() {
		
	}

	public void render(Graphics g) {
		g.drawImage(Assets.background, 400 ,0, null);
		g.drawImage(Assets.obstacle1, 540 ,280, null);	Game.go[3][1] = false;
		g.drawImage(Assets.obstacle1, 538 ,680, null);	Game.go[7][1] = false;
		g.drawImage(Assets.obstacle1, 540 ,770, null);	Game.go[8][1] = false;
		g.drawImage(Assets.obstacle1, 740 ,280, null);	Game.go[3][3] = false;
		g.drawImage(Assets.obstacle1, 740 ,75, null);	Game.go[3][1] = false;
		
		
	}

}