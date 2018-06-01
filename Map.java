import java.awt.Container;
import javax.swing.*;
import java.awt.BorderLayout;
public class Map {
	private JFrame frame;
	private String title;
	private int width, height;


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
	}	

}
