package numberbaseball.domain;

import java.util.Arrays;

public class Referee {

	public int[] judge(int[] answer, int[] trial) {
		// 볼, 스트라이크
		int ballCount = countBall(answer, trial);
		int strikeCount = countStrike(answer, trial);
		return new int[] {ballCount, strikeCount};
	}

	private int countStrike(int[] answer, int[] trial) {
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
	private int countBall(int[] answer, int[] trial) {
		int result = 0;
		for (int i = 0; i < 3; i++) {
			int number = trial[i];
			result += isBall(answer, number, i);
		}
		return result;
	}
	private int isBall(int[] answer, int number, int idx) {
		boolean hasSameNumber = Arrays.stream(answer)
			.anyMatch(n -> n == number);
		boolean isSamePosition = (answer[idx] == number);
		if (hasSameNumber && !isSamePosition) {
			return 1;
		}
		return 0;
	}
}
