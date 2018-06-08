import java.awt.Graphics;

public class GameState extends State {

	private Player player1;
	
	public GameState(){
		player1 = new Player(400, 400);
	}

	public void tick() {
		
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