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
	private BufferedImage background;
	
	public Game(String title , int width , int height) {
		this.width = width;
		this.height = height;
		this.title = title;
	}

	private void init(){
		map = new Map(title, width, height);
		background = ImageLoader.loadImage("/images/last_map.png");
		
	}

	private void tick(){
	
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
		
		g.drawImage(background,400,0,null);
		
		//End Drawing!
		bs.show();
		g.dispose();
	}
	
	public void run(){
		
		init();
		
		while(running){
			tick();
			render();
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