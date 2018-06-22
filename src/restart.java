import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



public class restart implements ActionListener {
	
	public  JFrame  restart;
	private int width, height;
	public static boolean bye = false;
	public restart(int i) {
		this.width = 600;
		this.height = 400;
		Display(i);
	}

	private void Display(int i) {
		
		JLabel lb0 = new JLabel("U LOSE ­ú­ú  ");
		lb0.setLocation(170, 10);
		lb0.setSize(400, 100);
		lb0.setFont(new Font("Serif", Font.ITALIC, 40));
		
		JLabel lb1 = new JLabel(" P1 win ");
		lb1.setLocation(170, 10);
		lb1.setSize(400, 100);
		lb1.setFont(new Font("Serif", Font.ITALIC , 40));
	
		
		JLabel lb2 = new JLabel(" P2 win ");
		lb2.setLocation(170, 10);
		lb2.setSize(400, 100);
		lb2.setFont(new Font("Serif", Font.ITALIC , 40));
		//lb2.setForeground(Color.white);

		JButton btn1 = new JButton("EXIT");
		ImageIcon btn1icon = new ImageIcon("./res/images/EXIT.png");
		btn1.setBorder(null);
		btn1.setFocusPainted(false);
		btn1.setOpaque(false);
		btn1.setContentAreaFilled(false);
		btn1.setIcon(btn1icon);
		btn1.addActionListener(this);
		btn1.setLocation(135, 100);
		btn1.setSize(280, 130);
		btn1.setFont(new Font("SansSerif", Font.ITALIC, 0));
		
		JButton btn2 = new JButton("menu");
		ImageIcon btn2icon = new ImageIcon("./res/images/menu.png");
		btn2.setBorder(null);
		btn2.setFocusPainted(false);
		btn2.setOpaque(false);
		btn2.setContentAreaFilled(false);
		btn2.setIcon(btn2icon);
		btn2.addActionListener(this);
		btn2.setLocation(135, 200);
		btn2.setSize(280, 130);
		btn2.setFont(new Font("SansSerif", Font.ITALIC, 0));


		
		restart = new JFrame();
		restart.setLocation(150, 50);
		restart.setLayout(null);
		restart.add(btn1);
		restart.add(btn2);
		if(i==0) {restart.add(lb0);}
		if(i==1) {restart.add(lb1);}
		if(i==2) {restart.add(lb2);}
		restart.setSize(width, height);
		restart.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		restart.setResizable(false);
		restart.setLocationRelativeTo(null);
		restart.setVisible(true);
	
	}

	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		if (str.equals("EXIT")) {
			bye = true;
			restart.dispose();
			////////////
		}
     	if (str.equals("menu")) {
     		bye = true;
			restart.dispose();
			Start_menu.Menu_frame.setVisible(true);
		}

	}

}
