import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.*;
import javax.swing.ImageIcon;
public class Game implements Runnable{
	
	private Map map;
	public int width , height;
	public String title;
	private boolean running = false;
	private Thread thread;
	private BufferStrategy bs;
	private Graphics g;
	private State gameState;
	private boolean bombbb;
	public static boolean go[][] = new boolean [11][9];
	
	int time = 0;
	public int k = 0;
	private Image[] icon = new Image[50];
	public short xx[] = new short[50];
	public short yy[] = new short[50];
	public long start_time[] = new long[50];
	public float b_duration[] = new float[50];
	public long b_timer[] = new long[50];
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
		gameState = new GameState();
		State.setState(gameState);
		String s1 = "0,0 0,1 1,0 0,6 0,7 0,8 1,6 9,0 10,0 10,1 9,8 10,8 10,7";
		String[] tokens = s1.split(" ");
		for (String token:tokens) {
			String[] tokens2 = token.split(",");
			String x = tokens2[0];
			String y = tokens2[1];
			go[Integer.valueOf(x)][Integer.valueOf(y)] = true;
		}

		for (Image image:icon)	image = null;
	}

	private void tick(){
		if(State.getState() != null)
			State.getState().tick();
	}
	boolean f = true;
	boolean s = true;
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
		/* Usage of putting bombs: 
		 * call setBombbb(true)
		 * xx[k] = x(bomb's x coordinate)
		 * yy[k] = y(bomb's y coordinate)
		 */
		try {
				if(isBombbb()) {
					if(k == 50)	k = 0;
					icon[k] = new ImageIcon(new URL("https://i.imgur.com/fXbu8CJ.gif")).getImage();
					start_time[k] = System.nanoTime();
					b_timer[k] = 0;
					b_duration[k] = 0;
					k++;
					setBombbb(false);
					System.out.println("k="+k);
				}
			
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0; i < 50; i++)	{
	
			if(icon[i] != null)	{
				long now = System.nanoTime();
				b_timer[i] +=  (now-start_time[i]);
				start_time[i] = now;
				if(b_timer[i] >= 1000000000) {
					b_duration[i] += 1;
					b_timer[i] = 0;
				}
				if(b_duration[i] <= 3)	g.drawImage(icon[i], xx[i], yy[i], null);
				else	icon[i] = null;
				System.out.println("i ===="+i);
			}
		}
		
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
			if (time == 3 && f) {
				setBombbb(true);
				xx[k] = 400;
				yy[k] = 300;
				f = false;
				System.out.println("start!!!!!!!!!!!!!!!");
			}
			if (time == 6 && s) {
				setBombbb(true);
				xx[k] = 700;
				yy[k] = 300;
				s  = false;
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

	public boolean isBombbb() {
		return bombbb;
	}

	public void setBombbb(boolean bombbb) {
		this.bombbb = bombbb;
	}

	
}
