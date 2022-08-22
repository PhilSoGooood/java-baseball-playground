package numberbaseball.domain;

public class Referee {

	// public int[] judge(int[] answer, int[] trial) {
	// 	// 볼, 스트라이크
	// 	int[] result = new int[2];
	// 	int strikeCount = countStrike(answer, trial);
	// 	result[1] = strikeCount;
	// 	return result;
	// }

	public int countStrike(int[] answer, int[] trial) {
		int result = 0;
		for (int i = 0; i < 3; i++) {
			result += isSameNumber(answer[i], trial[i]);
		}
		return result;
	}

	private int isSameNumber(int x, int y) {
		if (x == y) {
			return 1;
		}
		return 0;
	}
}
