package stringcalculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StringCalculatorTest {

	private final StringCalculator calculator = new StringCalculator();

	@DisplayName("덧셈 결과를 반환한다")
	@ParameterizedTest
	@CsvSource({"1 + 2, 3", "2 + 3, 5", "11 + 20, 31"})
	void add(String value, int expected) {
		int result = calculator.calculate(value);
		assertThat(result).isEqualTo(expected);
	}

	@DisplayName("뺄셈 결과를 반환한다")
	@ParameterizedTest
	@CsvSource({"3 - 2, 1", "8 - 3, 5", "31 - 20, 11"})
	void subtract(String value, int expected) {
		int result = calculator.calculate(value);
		assertThat(result).isEqualTo(expected);
	}

	@DisplayName("곱셈 결과를 반환한다")
	@ParameterizedTest
	@CsvSource({"1 * 3, 3", "2 * 3, 6", "11 * 20, 220"})
	void multiply(String value, int expected) {
		int result = calculator.calculate(value);
		assertThat(result).isEqualTo(expected);
	}

	@DisplayName("나눗셈 결과를 반환한다")
	@ParameterizedTest
	@CsvSource({"6 / 2, 3", "10 / 5, 2", "121 / 11, 11"})
	void divide(String value, int expected) {
		int result = calculator.calculate(value);
		assertThat(result).isEqualTo(expected);
	}

	@DisplayName("계산 결과를 반환한다")
	@ParameterizedTest
	@CsvSource({"2 + 3 * 4 / 2, 10", "1 + 2 - 3 + 4 / 2 * 3, 6", "3 / 4 + 1 * 3 - 2, 1"})
	void calculateTest(String value, int expected) {
		int result = calculator.calculate(value);
		assertThat(result).isEqualTo(expected);
	}
}
