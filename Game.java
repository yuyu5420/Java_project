import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
	public static boolean go[][] = new boolean [11][9];
	private KeyManager keyManager;
//	protected boolean current[][] = new boolean [11][9];
	
	public Game(String title , int width , int height) {
		this.width = width;
		this.height = height;
		this.title = title;
	}

	private void init(){
		map = new Map(title, width, height);
		for(int x = 0; x < 11; x++)
			for(int y = 0; y < 9; y++)		go[x][y] = false;
		Assets.init();
		gameState = new GameState(this);
		State.setState(gameState);
		String s1 = "0,0 0,1 1,0 0,6 0,7 0,8 1,6 9,0 10,0 10,1 9,8 10,8 10,7";
		String[] tokens = s1.split(" ");
		for (String token:tokens) {
			String[] tokens2 = token.split(",");
			String x = tokens2[0];
			String y = tokens2[1];
			go[Integer.valueOf(x)][Integer.valueOf(y)] = true;
		}
		keyManager = new KeyManager();
		map.getFrame().addKeyListener(keyManager);
	}
	

	public KeyManager getKeyManager() {
		return keyManager;
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
