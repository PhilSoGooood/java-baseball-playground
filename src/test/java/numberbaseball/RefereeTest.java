package numberbaseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import numberbaseball.domain.Referee;

class RefereeTest {

	private final Referee referee = new Referee();

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
		int result = referee.countStrike(answer, trial);

		// then
		assertThat(result).isEqualTo(expected);
	}
}
