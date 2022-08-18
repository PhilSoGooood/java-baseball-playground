package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringTest {

    @DisplayName("abc 를 adc 로 변환한다.")
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @DisplayName("문자열을 ',' 기준으로 분리한다.")
    @Test
    void split() {
    	// given
        String oneTwo = "1,2";
        String one = "1";
        // when
        String[] arrOneTwo = oneTwo.split(",");
        String[] arrOne = one.split(",");
        // then
        assertThat(arrOneTwo).containsExactly("1", "2");
        assertThat(arrOne).containsExactly("1");
    }

    @DisplayName("(1,2)에서 괄호를 제거한다.")
    @Test
    void substring() {
        // given
        String str = "(1,2)";
        int length = str.length();
        // when
        String expected = "1,2";
        String result = str.substring(1, length - 1);
        // then
        assertThat(result).isEqualTo(expected);
    }
    @DisplayName("문자열의 특정 위치의 문자열을 반환하고 범위를 벗어난 경우 예외를 발생시킨다.")
    @Test
    void charAt() {
    	// given
        String str = "abc";
    	// when
    	char a = str.charAt(0);
    	char b = str.charAt(1);
    	char c = str.charAt(2);
    	// then
        assertThat(a).isEqualTo('a');
        assertThat(b).isEqualTo('b');
        assertThat(c).isEqualTo('c');
        assertThatThrownBy(() -> str.charAt(str.length())).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
