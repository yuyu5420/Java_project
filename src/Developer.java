import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



public class Developer implements ActionListener {
	private String title;
	public  JFrame  DeveloperFrame;
	private int width, height;
	
	
	public Developer() {
		
		this.width = 1600;
		this.height = 1000;
		Display();
		
	}

	private void Display() {
		

		
		JLabel lb1 = new JLabel("¤ýªlÝÂ");
		lb1.setLocation(700, 550);
		lb1.setSize(200, 100);
		lb1.setFont(new Font("SansSerif", Font.BOLD,60));
		lb1.setForeground(Color.black);
		
		JLabel lb2 = new JLabel("¶À·ç½¬");
		lb2.setLocation(300, 550);
		lb2.setSize(200, 100);
		lb2.setFont(new Font("SansSerif", Font.BOLD,60));
		lb2.setForeground(Color.black);	
		
		JLabel lb3 = new JLabel("³¯­»§g");
		lb3.setLocation(1100, 550);
		lb3.setSize(200, 100);
		lb3.setFont(new Font("SansSerif", Font.BOLD,60));
		lb3.setForeground(Color.black);
		
		JLabel lb4 = new JLabel("§ºª÷¾Þ");
		lb4.setLocation(450, 300);
		lb4.setSize(200, 100);
		lb4.setFont(new Font("SansSerif", Font.BOLD,60));
		lb4.setForeground(Color.black);
		
		JLabel lb5 = new JLabel("³¯¬ý´Q");
		lb5.setLocation(950, 300);
		lb5.setSize(200, 100);
		lb5.setFont(new Font("SansSerif", Font.BOLD,60));
		lb5.setForeground(Color.black);
		
		
		JButton btn1 = new JButton("back");
		ImageIcon btn1icon = new ImageIcon("./res/images/Back.png");
		btn1.setBorder(null);
		btn1.setFocusPainted(false);
		btn1.setOpaque(false);
		btn1.setContentAreaFilled(false);
		btn1.setIcon(btn1icon);
		btn1.addActionListener(this);
		btn1.setLocation(670, 700);
		btn1.setSize(280, 130);
		btn1.setFont(new Font("SansSerif", Font.ITALIC, 0));

		
		
		JLabel b = new JLabel();
		ImageIcon bb = new ImageIcon("./res/images/desert.gif");
		b.setIcon(bb);
		b.setSize(1600, 1000);
	
		JLabel title = new JLabel();
		ImageIcon titleicon = new ImageIcon("./res/images/title.gif");
		title.setIcon(titleicon);
		title.setSize(1200,300);
		title.setLocation(200, 0);
		
		DeveloperFrame = new JFrame();
		DeveloperFrame.setLocation(150, 50);
		DeveloperFrame.setLayout(null);
		DeveloperFrame.add(lb1);
		DeveloperFrame.add(lb2);
		DeveloperFrame.add(lb3);
		DeveloperFrame.add(lb4);
		DeveloperFrame.add(lb5);
		DeveloperFrame.add(btn1);
		DeveloperFrame.add(title);
		DeveloperFrame.add(b);
		DeveloperFrame.setSize(width, height);
		DeveloperFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		DeveloperFrame.setResizable(false);
		DeveloperFrame.setLocationRelativeTo(null);
		DeveloperFrame.setVisible(true);
	
	}

	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		
		if (str.equals("back")) {
			DeveloperFrame.dispose();
			Start_menu.Menu_frame.setVisible(true);
		}

	}

}

