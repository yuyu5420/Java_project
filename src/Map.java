import java.awt.Dimension;
import java.awt.Image;

import javax.swing.*;
import java.awt.Canvas;
import java.awt.Color;

public class Map {
	private JFrame frame;
	public static JButton yoyoyo = new JButton();
	private String title;
	private int width, height;
	private Canvas canvas;
	
	public Map(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		Display();
	}

	private void Display() {
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		
		
		yoyoyo.setBorder(null);
		yoyoyo.setFocusPainted(false);
		yoyoyo.setFocusable(false);
		//yoyoyo.setOpaque(true);
	//	yoyoyo.setContentAreaFilled(false);
		
		yoyoyo.setIcon(new ImageIcon(new ImageIcon("./res/images/pause.png").getImage().getScaledInstance(300, 150, Image.SCALE_DEFAULT)));
		yoyoyo.setVisible(true);
		ButtonListener mblistener = new ButtonListener();
		yoyoyo.addActionListener(mblistener);
		yoyoyo.setLocation(70, 620);
		yoyoyo.setSize(300, 150);
		Color color= new Color(122, 113, 106);
		yoyoyo.setBackground(color);
		frame.add(yoyoyo);
		yoyoyo.setPreferredSize(null);
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setFocusable(false);

		frame.add(canvas);
		frame.pack();
		
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public JFrame getFrame() {
		return frame;
	}


}