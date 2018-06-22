import java.awt.Color;
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
		

	
		
		JLabel P1 = new JLabel("P1");
		P1.setLocation(200, 300);
		P1.setSize(400, 100);
		P1.setFont(new Font("SansSerif", Font.ITALIC , 40));
		//P1.setForeground(Color.white);
		
		JLabel P2 = new JLabel("P2");
		P2.setLocation(1300, 300);
		P2.setSize(1400, 100);
		P2.setFont(new Font("SansSerif", Font.ITALIC , 40));
		//P2.setForeground(Color.white);
		
		
		
		JButton btn1 = new JButton("back");
		ImageIcon btn1icon = new ImageIcon("./res/images/Back.png");
		btn1.setBorder(null);
		btn1.setFocusPainted(false);
		btn1.setOpaque(false);
		btn1.setContentAreaFilled(false);
		btn1.setIcon(btn1icon);
		btn1.addActionListener(this);
		btn1.setLocation(635, 700);
		btn1.setSize(280, 130);
		btn1.setFont(new Font("SansSerif", Font.ITALIC, 0));

		JLabel bomb = new JLabel();
		ImageIcon bomb_icon= new ImageIcon("./res/images/big_bomb.gif");
		bomb.setIcon(bomb_icon);
		bomb.setSize(180, 180);
		bomb.setLocation(130, 420);
		
		
		JLabel bomb2 = new JLabel();
		bomb2.setIcon(bomb_icon);
		bomb2.setSize(180, 180);
		bomb2.setLocation(1350, 420);
		
		
		JLabel b = new JLabel();
		ImageIcon bb = new ImageIcon("./res/images/desert.gif");
		b.setIcon(bb);
		b.setSize(1600, 1000);
		
		JLabel character = new JLabel();
		ImageIcon character_icon = new ImageIcon("./res/images/small_Afenda.gif");
		character.setIcon(character_icon);
		character.setSize(180, 180);
		character.setLocation(370, 430);
		
		
		JLabel character2 = new JLabel();
		character2.setIcon(character_icon);
		character2.setSize(180, 180);
		character2.setLocation(1000, 430);
		
		JLabel S = new JLabel();
		ImageIcon S_icon = new ImageIcon("./res/images/S.png");
		S.setIcon(S_icon);
		S.setSize(60, 60);
		S.setLocation(1060, 630);

		JLabel A = new JLabel();
		ImageIcon A_icon = new ImageIcon("./res/images/A.png");
		A.setIcon(A_icon);
		A.setSize(60, 60);
		A.setLocation(930, 490);
		
		JLabel W = new JLabel();
		ImageIcon W_icon = new ImageIcon("./res/images/W.png");
		W.setIcon(W_icon);
		W.setSize(60, 60);
		W.setLocation(1060, 350);
		
		
		JLabel D = new JLabel();
		ImageIcon D_icon = new ImageIcon("./res/images/D.png");
		D.setIcon(D_icon);
		D.setSize(60, 60);
		D.setLocation(1190, 490);
		
		JLabel ENTER = new JLabel();
		ImageIcon ENTER_icon = new ImageIcon("./res/images/ENTER.png");
		ENTER.setIcon(ENTER_icon);
		ENTER.setSize(200, 100);
		ENTER.setLocation(80, 600);
		
		
		JLabel UP = new JLabel();
		ImageIcon UP_icon = new ImageIcon("./res/images/UP.png");
		UP.setIcon(UP_icon);
		UP.setSize(60, 60);
		UP.setLocation(430, 350);
		
		JLabel DOWN = new JLabel();
		ImageIcon DOWN_icon = new ImageIcon("./res/images/DOWN.png");
		DOWN.setIcon(DOWN_icon);
		DOWN.setSize(60, 60);
		DOWN.setLocation(430, 630);
		
		JLabel LEFT = new JLabel();
		ImageIcon LEFT_icon = new ImageIcon("./res/images/LEFT.png");
		LEFT.setIcon(LEFT_icon);
		LEFT.setSize(60, 60);
		LEFT.setLocation(300, 490);
		
		
		JLabel RIGHT = new JLabel();
		ImageIcon RIGHT_icon = new ImageIcon("./res/images/RIGHT.png");
		RIGHT.setIcon(RIGHT_icon);
		RIGHT.setSize(60, 60);
		RIGHT.setLocation(560, 490);
		
		JLabel SPACE = new JLabel();
		ImageIcon SPACE_icon = new ImageIcon("./res/images/SPACE.png");
		SPACE.setIcon(SPACE_icon);
		SPACE.setSize(200, 100);
		SPACE.setLocation(1300, 600);
		
		
		
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
		How_to_play_frame.add(character);
		How_to_play_frame.add(character2);
		How_to_play_frame.add(P2);
		How_to_play_frame.add(P1);
		How_to_play_frame.add(S);
		How_to_play_frame.add(D);
		How_to_play_frame.add(W);
		How_to_play_frame.add(A);
		How_to_play_frame.add(DOWN);
		How_to_play_frame.add(LEFT);
		How_to_play_frame.add(UP);
		How_to_play_frame.add(RIGHT);
		How_to_play_frame.add(bomb);
		How_to_play_frame.add(bomb2);
		How_to_play_frame.add(ENTER);
		How_to_play_frame.add(SPACE);
		
		How_to_play_frame.add(b);//
		How_to_play_frame.setSize(width, height);
		How_to_play_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		How_to_play_frame.setResizable(false);
		How_to_play_frame.setLocationRelativeTo(null);
		How_to_play_frame.setVisible(true);
	
	}

	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		
		if (str.equals("back")) {
			How_to_play_frame.dispose();
			Start_menu.Menu_frame.setVisible(true);
		}

	}

}
