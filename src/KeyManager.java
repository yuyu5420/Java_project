import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JLabel;

public class KeyManager implements KeyListener {
	private boolean[] keys;
	protected int x = 300;
	private boolean next;
	public boolean left, right, enter;

	public KeyManager() {
		keys = new boolean[256];
	}

	public void tick() {
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
		enter = keys[KeyEvent.VK_ENTER];

	}

	public void DisplayP2(JLabel arrow2) {
		Character_page.arrow2.setLocation(x, 100);
		Character_page.arrow2.setVisible(true);
	}

	@Override
	public void keyPressed(KeyEvent e) {

		switch (e.getKeyCode()) {
		case KeyEvent.VK_RIGHT:
			if (next == false) {
				if (Setting_page.character_choose1 < 4)
					Setting_page.character_choose1 = Setting_page.character_choose1 + 1;

				x = 300 + (Setting_page.character_choose1 - 1) * 300;
				Character_page.P1_arrow_move(x);
			} else {
				if (Setting_page.character_choose2 < 4
						&& ((Setting_page.character_choose2 + 1) != Setting_page.character_choose1))
					Setting_page.character_choose2 = Setting_page.character_choose2 + 1;
				else if (Setting_page.character_choose2 < 3
						&& ((Setting_page.character_choose2 + 1) == Setting_page.character_choose1))
					Setting_page.character_choose2 = Setting_page.character_choose2 + 2;

				x = 300 + (Setting_page.character_choose2 - 1) * 300;
				Character_page.P2_arrow_move(x);
			}

			break;

		case KeyEvent.VK_LEFT:
			if (next == false) {
				if (Setting_page.character_choose1 > 1)
					Setting_page.character_choose1 = Setting_page.character_choose1 - 1;
				x = 300 + (Setting_page.character_choose1 - 1) * 300;
				Character_page.P1_arrow_move(x);
			} else {

				if (Setting_page.character_choose2 > 1
						&& ((Setting_page.character_choose2 - 1) != Setting_page.character_choose1))
					Setting_page.character_choose2 = Setting_page.character_choose2 - 1;
				else if (Setting_page.character_choose2 > 2
						&& ((Setting_page.character_choose2 - 1) == Setting_page.character_choose1))
					Setting_page.character_choose2 = Setting_page.character_choose2 - 2;

				x = 300 + (Setting_page.character_choose2 - 1) * 300;
				Character_page.P2_arrow_move(x);
			}
			break;

		case KeyEvent.VK_ENTER:
			if (Setting_page.Player_Number == 2 && next == false) {
				if (x != 300) {
					x = 300;
				} else {
					x = 600;
				}

				Setting_page.character_choose2 = (x - 300) / 300 + 1;
				next = true;
				DisplayP2(Character_page.arrow2);

			} else {

				Game game = new Game("Game!", 1600, 1000);
				game.start();
				Character_page.frame_C.dispose();
			}

			System.out.println(Setting_page.character_choose1);
			System.out.println(Setting_page.character_choose2);

			break;
		}
	}

	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	public void keyTyped(KeyEvent e) {
	}

}
