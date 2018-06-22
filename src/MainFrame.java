import java.awt.Font;
import java.awt.Container;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainFrame extends JFrame {

	static MainFrame smallgame;

	public static void main(String[] args) {
		gamepanel p;
		p = new gamepanel();
		// MainFrame smallgame = new MainFrame();
		smallgame = new MainFrame();
		smallgame.addKeyListener(p);
		smallgame.setSize(1600, 1000);
		smallgame.setLocation(150, 50);
		smallgame.setVisible(true);
		smallgame.add(p);
		smallgame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

}
