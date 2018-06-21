import java.awt.Font;
import java.awt.Insets;
import javax.swing.*;
import java.awt.BorderLayout;
import java.util.*;
import javax.swing.plaf.FontUIResource;

public class Setting_page {
	private String title;
	public static JFrame startframe;
	private int width, height;
	public static int Player_Number = 0;
	public static int character_choose1 = 1;
	public static int character_choose2 = 1;

	public Setting_page(String title, int width, int height) {
		this.title = title;
		this.width = width;

		this.height = height;
		Display();
	}

	private void Display() {

		JButton btn1 = new JButton("1 Player");
		ImageIcon btn1icon = new ImageIcon("./res/images/1P400.png");

		btn1.setBorder(null);
		btn1.setFocusPainted(false);
		btn1.setOpaque(false);
		btn1.setContentAreaFilled(false);
		btn1.setIcon(btn1icon);
		MyButtonListener mblistener = new MyButtonListener();
		btn1.addActionListener(mblistener);
		btn1.setLocation(130, 650);
		btn1.setSize(400, 180);

		JButton btn2 = new JButton("2 Player");
		ImageIcon btn2icon = new ImageIcon("./res/images/2P400.png");

		btn2.setBorder(null);
		btn2.setFocusPainted(false);
		btn2.setOpaque(false);
		btn2.setContentAreaFilled(false);
		btn2.setIcon(btn2icon);
		btn2.addActionListener(mblistener);
		btn2.setLocation(1020, 650);
		btn2.setSize(400, 180);


		btn1.setFont(new Font("SansSerif", Font.ITALIC, 0));
		btn2.setFont(new Font("SansSerif", Font.ITALIC, 0));

		JLabel lb = new JLabel("Choose the Game type!");
		lb.setLocation(400, 70);
		lb.setSize(1600, 100);
		lb.setFont(new Font("SansSerif", Font.ITALIC, 70));
		
		JLabel b = new JLabel();
		JLabel p1 = new JLabel();
		JLabel p1_1 = new JLabel();
		ImageIcon bb = new ImageIcon("./res/images/desert.gif");
		b.setIcon(bb);

		b.setSize(1600, 1000);
		ImageIcon p1icon = new ImageIcon("./res/images/Afenda.gif");
		p1.setIcon(p1icon);
		p1_1.setIcon(p1icon);
		p1.setLocation(190, 250);
		p1.setSize(270, 300);

		p1_1.setLocation(1000, 250);
		p1_1.setSize(270, 300);

		JLabel p2 = new JLabel();
		ImageIcon p2icon = new ImageIcon("./res/images/niger.gif");
		p2.setIcon(p2icon);
		p2.setLocation(1250, 250);
		p2.setSize(270, 300);

		startframe = new JFrame();
		startframe.setLocation(150, 50);
		startframe.setLayout(null);
		startframe.add(btn1);
		startframe.add(btn2);
		startframe.add(lb);
		startframe.add(p1);
		startframe.add(p1_1);
		startframe.add(p2);
		startframe.add(b);//
		startframe.setSize(width, height);
		startframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		startframe.setResizable(false);
		startframe.setLocationRelativeTo(null);
		startframe.setVisible(true);

	}

}