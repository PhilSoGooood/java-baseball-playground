package numberbaseball.domain;

public class NumberBaseball {

	private final int[] answer = new int[3];

	public NumberBaseball() {
		setUp();
	}
	public int[] getAnswer() {
		return answer;
	}
	private void setUp() {
		for (int i = 0; i < 3; i++) {
			answer[i] = pickRandomNumber(i);
		}
	}

	private int pickRandomNumber(int idx) {
		int num = 0;
		boolean flag = true;
		while (flag) {
			num = (int)(Math.random() * 9) + 1;
			flag = hasDuplicateNumber(idx, num);
		}
		return num;
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
