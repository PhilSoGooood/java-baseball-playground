package numberbaseball;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import numberbaseball.domain.Referee;

class RefereeTest {

	private final Referee referee = new Referee();

	@DisplayName("볼, 스트라이크 순으로 판정 반환")
	@ParameterizedTest
	@CsvSource(value = {"123:03", "149:01", "981:10", "231:30", "126:02", "456:00"}, delimiter = ':')
	void strikeTest(String player, String expected) {
		// given
		int[] answer = {1, 2, 3};
		String[] splitPlayer = player.split("");
		String[] splitExpected = expected.split("");

		int[] trial = new int[3];
		for (int i = 0; i < 3; i++) {
			trial[i] = Integer.parseInt(splitPlayer[i]);
		}
		int ballCount = Integer.parseInt(splitExpected[0]);
		int strikeCount = Integer.parseInt(splitExpected[1]);
		int[] expectedResult = new int[] {ballCount, strikeCount};
		// when
		int[] result = referee.judge(answer, trial);

		// then
		assertThat(result).isEqualTo(expectedResult);
	}

	@DisplayName("같은 위치, 같은 숫자인 경우 스트라이크")
	@ParameterizedTest
	@CsvSource(value = {"123:3", "149:1", "981:0", "231:0", "126:2"}, delimiter = ':')
	void strikeTest(String player, int expected) {
		// given
		int[] answer = {1, 2, 3};
		String[] splitPlayer = player.split("");
		int[] trial = new int[3];

		for (int i = 0; i < 3; i++) {
			trial[i] = Integer.parseInt(splitPlayer[i]);
		}
		// when
		int result = countStrike(answer, trial);

		// then
		assertThat(result).isEqualTo(expected);
	}

	@DisplayName("다른 위치, 같은 숫자인 경우 볼")
	@ParameterizedTest
	@CsvSource(value = {"123:0", "213:2", "981:1", "231:3", "912:2"}, delimiter = ':')
	void ballTest(String player, int expected) {
		// given
		int[] answer = {1, 2, 3};
		String[] splitPlayer = player.split("");
		int[] trial = new int[3];

		for (int i = 0; i < 3; i++) {
			trial[i] = Integer.parseInt(splitPlayer[i]);
		}
		// when
		int result = countBall(answer, trial);

		// then
		assertThat(result).isEqualTo(expected);
	}

	private int countStrike(int[] answer, int[] trial) {
		int result = 0;
		for (int i = 0; i < 3; i++) {
			result += isSameNumber(answer[i], trial[i]);
		}
		return result;
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
	private int isSameNumber(int x, int y) {
		if (x == y) {
			return 1;
		}
		return 0;
	}
}
