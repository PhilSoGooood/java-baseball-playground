package study;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class SetTest {
	private Set<Integer> numbers;

	@BeforeEach
	void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	@DisplayName("numbers 의 크기를 size 메서드를 통해 확인한다.")
	@Test
	void checkSize() {
		// given
		int size = numbers.size();
		// then
		assertThat(size).isEqualTo(3);
	}

	@DisplayName("Set 에 1, 2, 3이 있는지 ParameterizedTest 를 통해 확인한다.")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	void checkContainsExactNumbers(int number) {
		assertThat(numbers.contains(number)).isTrue();
	}

	@DisplayName("Set 에 존재하지 않는 값을 넣으면 false 를 반환한다.")
	@ParameterizedTest
	@CsvSource({"1, true", "2, true", "3, true", "4, false", "5, false"})
	void checkContainsExactNumbers(int number, boolean expected) {
		assertThat(numbers.contains(number)).isEqualTo(expected);

		// 자동으로 형변환이 이루어진다.
		assertThat(number).isInstanceOf(Integer.class);
		assertThat(expected).isInstanceOf(Boolean.class);
	}
}
