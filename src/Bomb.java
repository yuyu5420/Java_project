
public class Bomb {
	private int b_x;
	private int b_y;
	private int range;
	private int up, down, right, left;
	private long start_time;
	private short b_duration = 0;
	private short f_duration = 0;
	private long b_timer = 0;
	private long e_timer = 0;
	private boolean first = true;
	private int size = 80;
	private int e_duration = 0;
	private boolean change = false;

	public Bomb(int i, int j, int range) {
		this.setB_x(i);
		this.setB_y(j);
		this.setRange(range);
		this.start_time = System.nanoTime();

	}

	public int getB_x() {
		return b_x;
	}

	public void setB_x(int i) {
		this.b_x = i;
	}

	public int getB_y() {
		return b_y;
	}

	public void setB_y(int j) {
		this.b_y = j;
	}

	public short getB_duration() {
		return b_duration;
	}

	public void setB_duration() {
		long now = System.nanoTime();
		this.setB_timer(getB_timer() + now - this.start_time);
		this.start_time = now;
		if (this.getB_timer() >= 250000000)
			this.f_duration += 1;
		if (this.getB_timer() >= 1000000000) {
			this.b_duration += 1;
			this.b_timer = 0;
		}
	}

	public short getF_duration() {
		return f_duration;
	}

	public void setF_duration(short f_duration) {
		this.f_duration = f_duration;
	}

	public long getB_timer() {
		return b_timer;
	}

	public void setB_timer(long b_timer) {
		this.b_timer = b_timer;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public boolean isFirst() {
		return first;
	}

	public void setFirst(boolean first) {
		this.first = first;
	}

	public int getDown() {
		return down;
	}

	public void setDown(int down) {
		this.down = down;
	}

	public int getLeft() {
		return left;
	}

	public void setLeft(int left) {
		this.left = left;
	}

	public int getUp() {
		return up;
	}

	public void setUp(int up) {
		this.up = up;
	}

	public int getRight() {
		return right;
	}

	public void setRight(int right) {
		this.right = right;
	}

	public int getSize() {
		return size;
	}

	public void setSize() {
		if (this.size == 80 || !change) {
			this.size++;
			this.change = false;
		}
		if (this.size == 90 || change) {
			this.size--;
			this.change = true;
		}
	}

	public int getE_duration() {
		return e_duration;
	}

	public void setE_duration(int i) {
		long now = System.nanoTime();
		this.setE_timer(getE_timer() + now - GameState.start_time[i]);
		GameState.start_time[i] = now;
		if (this.getE_timer() >= 250000000) {
			this.e_duration += 1;
			this.e_timer = 0;
		}
	}

	public long getE_timer() {
		return e_timer;
	}

	public void setE_timer(long e_timer) {
		this.e_timer = e_timer;
	}

}
