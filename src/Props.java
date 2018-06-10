
import java.util.Random;

public class Props {

	private int random[] = { 0, 3, 0, 0, 2, 0, 1, 0, 0 };
	private Random random_num = new Random();
	public int id = 0;

	public Props() {//
		switch (random[random_num.nextInt(9)]) {///
		case 1: {//////
			id = 1;
			break;
		} //////
		case 2: {/////
			id = 2;
			break;
		} /////
		case 3: {////
			id = 3;
			break;
		} ////
		default: {
			break;
		}

		}///
	}//

}