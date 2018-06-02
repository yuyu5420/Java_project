import java.awt.Container;
import java.awt.Dimension;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Canvas;


public class Map {
	private JFrame frame;
	private String title;
	private int width, height;
	private Canvas canvas;

	public Map(String title, int width, int height){
		this.title = title;
		this.width = width;
		this.height = height;	
		Display();
	}
	
	private void Display(){
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width,height));
		canvas.setMaximumSize(new Dimension(width-400,height));
		canvas.setMinimumSize(new Dimension(width-400,height));
		
		frame.add(canvas);
		frame.pack();
	}	
	public Canvas getCanvas(){
		return canvas;
	}
	
}