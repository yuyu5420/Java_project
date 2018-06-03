import java.awt.Graphics;


public class GameState extends State {

	public GameState(){
		
	}
	
	public void tick() {
		
	}

	public void render(Graphics g) {
		g.drawImage(Assets.background, 400 ,0, null);
	}

}