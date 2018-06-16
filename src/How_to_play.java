import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class How_to_play implements ActionListener {
	private String title;
	public  JFrame  How_to_play_frame;
	private int width, height;

	public How_to_play() {
		this.width = 1600;
		this.height = 1000;
		Display();
	}

	private void Display() {
		
		JButton btn1 = new JButton("Menu");
		ImageIcon btn1icon = new ImageIcon("./res/images/START.png");
		btn1.setBorder(null);
		btn1.setFocusPainted(false);
		btn1.setOpaque(false);
		btn1.setContentAreaFilled(false);
		btn1.setIcon(btn1icon);
		btn1.addActionListener(this);
		btn1.setLocation(600, 300);
		btn1.setSize(400, 180);
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
		
		How_to_play_frame = new JFrame();
		How_to_play_frame.setLocation(150, 50);
		How_to_play_frame.setLayout(null);
		How_to_play_frame.add(btn1);
		How_to_play_frame.add(title);
		How_to_play_frame.add(b);//
		How_to_play_frame.setSize(width, height);
		How_to_play_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		How_to_play_frame.setResizable(false);
		How_to_play_frame.setLocationRelativeTo(null);
		How_to_play_frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		
		if (str.equals("Menu")) {
			How_to_play_frame.dispose();
			Start_menu.Menu_frame.setVisible(true);
		}

	}

}
