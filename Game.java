public class Game {
	
	private Map map;
	public int width , height;
	
	public Game(String title , int width , int height) {
		this.width = width;
		this.height = height;
		
		map = new Map(title , width , height);
	}
}