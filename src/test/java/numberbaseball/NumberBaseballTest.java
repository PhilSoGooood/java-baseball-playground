package numberbaseball;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import numberbaseball.domain.NumberBaseball;

class NumberBaseballTest {

	NumberBaseball baseball = new NumberBaseball();

	@BeforeEach
	void setBaseball() {
		baseball.setUp();
	}

	@DisplayName("숫자가 중복 되는 경우 true 를 반환 한다. ")
	@ParameterizedTest
	@CsvSource(value = {"339:true", "121:true", "123:false", "456:false", "777:true", "198:false"}, delimiter = ':')
	void has_Duplicate_Num_Then_True(String input, boolean expected) {
		int[] numbers = new int[3];
		String[] splitString = input.split("");
		for (int i = 0; i < 3; i++) {
			numbers[i] = Integer.parseInt(splitString[i]);
		}
		boolean result = false;
		int i = 0;
		while (!result && i < 3) {
			int num = numbers[i];
			result = hasDuplicateNumber(i, num, numbers);
			i++;
		}
		assertThat(result).isEqualTo(expected);
	}

	private boolean hasDuplicateNumber(int idx, int num, int[] numbers) {
		boolean result = false;
		int i=0;
		while (!result && i < idx){
			result = isSameNumber(num, numbers[i]);
			i++;
		}
		return result;
	}

	private boolean isSameNumber(int x, int y) {
		return x == y;
	}

	@DisplayName("컴퓨터의 수들의 범위는 1~9이다")
	@ParameterizedTest
	@ValueSource(ints = {0, 1, 2})
	void numRangeTest(int idx) {
		int num = baseball.answer[idx];
		assertThat(num).isBetween(1, 9);
		System.out.println(Arrays.toString(baseball.answer));
	}
}
