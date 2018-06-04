import java.awt.Graphics;
import java.awt.image.*;

public class Game implements Runnable{
	
	private Map map;
	public int width , height;
	public String title;
	private boolean running = false;
	private Thread thread;
	private BufferStrategy bs;
	private Graphics g;
	private State gameState;
	public static boolean go[][] = new boolean [9][11];
	
	public Game(String title , int width , int height) {
		this.width = width;
		this.height = height;
		this.title = title;
	}

	private void init(){
		map = new Map(title, width, height);
		for(int x = 0; x < 9; x++)
			for(int y = 0; y < 11; y++)		go[x][y] = true;
		Assets.init();
		gameState = new GameState();
		State.setState(gameState);
		
	}

	private void tick(){
		if(State.getState() != null)
			State.getState().tick();
	}
	
	private void render(){
		bs = map.getCanvas().getBufferStrategy();
		if(bs == null){
			map.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//Clear Screen
		g.clearRect(0, 0, width, height);
		//Draw Here!
		
		if(State.getState() != null)
			State.getState().render(g);
		
		//End Drawing!
		bs.show();
		g.dispose();
	}
	
	public void run(){
		
		init();
		
		int fps = 60;
		double timepPerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int time = 0;
		
		while(running){
			now = System.nanoTime();
			delta += (now - lastTime)/timepPerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1){
			tick();
			render();
			delta--;
			}
			
			if(timer >= 1000000000) {
				time += 1;
				timer = 0;
				System.out.println("current time:" + time);
				
			}
		}
		
		stop();
		
	}
	
	public synchronized void start(){
		if(running)	return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop(){
		if(!running)	return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
