
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.BorderLayout;
import java.util.*;
import javax.swing.plaf.FontUIResource;

public class Start_menu implements ActionListener {
	private String title;
	public static JFrame Menu_frame;
	private int width, height;

	public Start_menu(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		Display();
	}

	private void Display() {
		
		JButton btn1 = new JButton("Start");
		ImageIcon btn1icon = new ImageIcon("./res/images/START.png");
		btn1.setBorder(null);
		btn1.setFocusPainted(false);
		btn1.setOpaque(false);
		btn1.setContentAreaFilled(false);
		btn1.setIcon(btn1icon);
		btn1.addActionListener(this);
		btn1.setLocation(600, 300);
		btn1.setSize(400, 180);

		JButton btn2 = new JButton("Setting");
		ImageIcon btn2icon = new ImageIcon("./res/images/setting.png");
		btn2.setBorder(null);
		btn2.setFocusPainted(false);
		btn2.setOpaque(false);
		btn2.setContentAreaFilled(false);
		btn2.setIcon(btn2icon);
		btn2.addActionListener(this);
		btn2.setLocation(600, 500);
		btn2.setSize(400, 180);

		JButton btn3 = new JButton("How to play");
		ImageIcon btn3icon = new ImageIcon("./res/images/how_to_play.png");
		btn3.setBorder(null);
		btn3.setFocusPainted(false);
		btn3.setOpaque(false);
		btn3.setContentAreaFilled(false);
		btn3.setIcon(btn3icon);
		btn3.addActionListener(this);
		btn3.setLocation(600, 700);
		btn3.setSize(400, 180);

		btn1.setFont(new Font("SansSerif", Font.ITALIC, 0));
		btn2.setFont(new Font("SansSerif", Font.ITALIC, 0));
		btn3.setFont(new Font("SansSerif", Font.ITALIC, 0));

		JLabel title = new JLabel();
		ImageIcon titleicon = new ImageIcon("./res/images/title.gif");
		title.setIcon(titleicon);
		title.setSize(1200,300);
		title.setLocation(200, 0);
		
		JLabel b = new JLabel();
		ImageIcon bb = new ImageIcon("./res/images/desert.gif");
		b.setIcon(bb);
		b.setSize(1600, 1000);

		Menu_frame = new JFrame();
		Menu_frame.setLocation(150, 50);
		Menu_frame.setLayout(null);
		Menu_frame.add(btn1);
		Menu_frame.add(btn2);
		Menu_frame.add(btn3);
		Menu_frame.add(title);
		Menu_frame.add(b);//
		Menu_frame.setSize(width, height);
		Menu_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Menu_frame.setResizable(false);
		Menu_frame.setLocationRelativeTo(null);
		Menu_frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		if (str.equals("Start")) 
		{
			new Setting_page("Game!", 1600, 1000);
			Menu_frame.dispose();
		}

		else if (str.equals("How to play")) {
			new How_to_play();
			Menu_frame.setVisible(false);
		}

	}

}
