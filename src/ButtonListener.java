import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

public class ButtonListener implements ActionListener{
	public static boolean jjjjjj = false;
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
			if (jjjjjj)	{System.out.print("51313213155");
				Map.yoyoyo.setIcon(new ImageIcon(new ImageIcon("./res/images/pause.png").getImage().getScaledInstance(300, 150, Image.SCALE_DEFAULT)));
				jjjjjj = false;
			}
			else	{System.out.println("51313213155");
				Map.yoyoyo.setIcon(new ImageIcon(new ImageIcon("./res/images/resume.png").getImage().getScaledInstance(300, 150, Image.SCALE_DEFAULT)));
				jjjjjj = true;
			}
	}

}
