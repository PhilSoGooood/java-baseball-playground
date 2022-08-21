package numberbaseball;

public class NumberBaseball {

	public final int[] answer = new int[3];

	void setUp() {
		for (int i = 0; i < 3; i++) {
			pickRandomNumber(i);
		}
	}

	private void pickRandomNumber(int idx) {
		int num = 0;
		boolean flag = true;
		while (flag) {
			num = (int)(Math.random() * 9) + 1;
			flag = hasDuplicateNumber(idx, num);
		}
		answer[idx] = num;
	}

	private boolean hasDuplicateNumber(int idx, int num) {
		boolean result = false;
		int i=0;
		while (!result && i < idx){
			result = isSameNumber(num, answer[i]);
			i++;
		}
		return result;
	}

	private boolean isSameNumber(int x, int y) {
		return x == y;
	}
}
