import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.List;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class gamepanel extends JPanel implements KeyListener {
	BufferedImage image;
	Graphics2D g2;
	Bomber Player;
	boolean finish = false;
	static final int FRESH = 20;
	int timer_obstacle = 0;

	backgroundimage background;
	ArrayList<obstacle> list = new ArrayList<obstacle>();

	public gamepanel() {
		image = new BufferedImage(1600, 1000, BufferedImage.TYPE_INT_BGR);
		g2 = image.createGraphics();
		Player = new Bomber();
		background = new backgroundimage();
		list.add(new obstacle());
		FreshThread t = new FreshThread(this);
		t.start();
	}

	private void paintImage() {
		background.roll();

		g2.drawImage(background.image, 0, 0, this);
		Player.move();
		g2.drawImage(Player.image, Player.x, Player.y, this);

		if (timer_obstacle >= 1500) {
			Random r = new Random();

			if (r.nextInt(100) > 40) {
				list.add(new obstacle());
				timer_obstacle = 0;
			}
			timer_obstacle = 0;
		}
		for (int i = 0; i < list.size(); i++) {
			obstacle o = list.get(i);

			if (o.getBounds().intersects(Player.getFeetBounds())) {
				finish = true;
				new Start_menu("Game!", 1600, 1000);
				MainFrame.smallgame.dispose();
			}

			if (o.x >= -200) {
				o.move();
				g2.drawImage(o.image, o.x, o.y, this);
			}
		}
		timer_obstacle += FRESH;
	}

	public void paint(Graphics g) {
		paintImage();
		g.drawImage(image, 0, 0, this);
	}

	public boolean isFinish() {
		return finish;
	}

	public void keyTyped(KeyEvent e) {

	}

	public void keyPressed(KeyEvent e) {
		Player.jump();
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_SPACE) {
			Player.jump();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}
