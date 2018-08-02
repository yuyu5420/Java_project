
public class FreshThread extends Thread {
	gamepanel p;

	public FreshThread(gamepanel p) {
		this.p = p;
	}

	public void run() {
		while (p.isFinish() == false) {
			p.repaint();
			try {
				Thread.sleep(gamepanel.FRESH);
			}

			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
