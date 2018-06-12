import java.awt.Graphics;
import java.awt.image.*;

public class Game implements Runnable {

	private KeyManager keyManager;
	private Map map;
	public int width, height;
	public String title;
	public static boolean running = false;
	private Thread thread;
	private BufferStrategy bs;
	private Graphics g;
	private static int time = 180;
	public static int minute = time / 60;
	public static int second = time % 60;
	private State gameState;
	public static boolean box_exist[][] = new boolean[11][9];
	public static boolean bomb_exist[][] = new boolean[11][9];
	public static boolean fire_exist[][] = new boolean[11][9];
	public static boolean go[][] = new boolean[11][9];
	public static Props props[][] = new Props[11][9];

	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
	}

	private void init() {
		map = new Map(title, width, height);
		for (int x = 0; x < 11; x++)
			for (int y = 0; y < 9; y++) {
				go[x][y] = false;
				box_exist[x][y] = false;
				fire_exist[x][y] = false;
				bomb_exist[x][y] = false;
				props[x][y] = null;
			}
		for (int i = 0; i < 50; i++) {
			GameState.bomb[i] = null;
			GameState.start_time[i] = 0;
			
		}

		String s3 = "2,0 2,1 2,2 2,3 2,4 2,5 2,6 2,7 2,8 3,0 3,2 3,4 3,6 3,8 4,0 4,1 4,2 4,3 4,4 4,5 4,6 4,7 4,8 5,0 5,1 5,3 5,5 5,7 6,0 6,1 6,2 6,3 6,4 6,5 6,6 6,7 6,8 7,1 7,2 7,5 7,7 7,8 8,0 8,1 8,2 8,3 8,4 8,5 8,6 8,7 8,8 9,2 9,4 9,6 10,2 10,3 10,4 10,5 10,6 1,2 1,4 0,2 0,3 0,4 0,5";
		String[] tokens5 = s3.split(" ");
		for (String token : tokens5) {
			String[] tokens6 = token.split(",");
			String x = tokens6[0];
			String y = tokens6[1];
			box_exist[Integer.valueOf(x)][Integer.valueOf(y)] = true;
		}
		Assets.init();
		gameState = new GameState(this);
		State.setState(gameState);
		String s1 = "0,0 0,1 1,0 0,6 0,7 0,8 1,6 9,0 10,0 10,1 9,8 10,8 10,7";
		String[] tokens = s1.split(" ");
		for (String token : tokens) {
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

	private void tick() {
		if (State.getState() != null)
			State.getState().tick();
	}

	private void render() {
		bs = map.getCanvas().getBufferStrategy();
		if (bs == null) {
			map.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		// Clear Screen
		g.clearRect(0, 0, width, height);
		// Draw Here!

		if (State.getState() != null)
			State.getState().render(g);
		
		// End Drawing!
		bs.show();
		g.dispose();
	}

	public void run() {

		init();

		int fps = 100;
		double timepPerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;

		while (running) {
			
			  while (ButtonListener.jjjjjj) {  
				  System.out.print(""); 
				  }
			  
			now = System.nanoTime();
			delta += (now - lastTime) / timepPerTick;
			timer += now - lastTime;
			lastTime = now;

			if (delta >= 1) {
				tick();
				render();
				delta--;
			}

			if (timer >= 1000000000) {
				time -= 1;
				timer = 0;
				minute = time / 60;
				second = time % 60;
				
			}

		}
	}

	public synchronized void start() {
		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop() {
		if (!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}