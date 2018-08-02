

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyButtonListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		if (str.equals("1 Player")) // 1 players
		// if (e.getSource().equals(s.getBtn1())) // 1 players
		{

			Setting_page.Player_Number = 1;
			new Character_page("Game!", 1600, 1000);
			Setting_page.startframe.dispose();
		}

		else if (str.equals("2 Player"))
		// else if (e.getSource().equals(s.btn2)) // 1 players
		{

			Setting_page.Player_Number = 2;
			new Character_page("Game!", 1600, 1000);
			Setting_page.startframe.dispose();
		}

		System.out.println("Start_Menu.Player_Number :");
		System.out.println(Setting_page.Player_Number);
		System.out.print("\n");

	}

}
