package numberbaseball.view;

import static numberbaseball.exception.ExceptionMessage.*;
import static numberbaseball.view.RequestMessage.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {

	private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public int[] getPlayerNumber() throws IOException {
		boolean isWrongInput = false;
		String[] input = new String[0];
		while (!isWrongInput) {
			input = requestNumbers();
			isWrongInput = checkNumber(input);
		}
		int[] numbers = new int[3];
		for (int i = 0; i < 3; i++) {
			numbers[i] = Integer.parseInt(input[i]);
		}
		return numbers;
	}
	public int requestContinue() throws IOException {
		System.out.println(RESTART_OR_QUIT.getMessage());
		return Integer.parseInt(br.readLine());
	}

	private String[] requestNumbers() throws IOException {
		System.out.print(REQUEST_NUMBER.getMessage());
		return br.readLine().split("");
	}

	private boolean checkNumber(String[] input) {
		if (!isDigit(input)) {
			System.out.println(NOT_NUMBERS.getMessage());
			return false;
		}
		if (checkLength(input)) {
			System.out.println(NOT_THREE_NUMBERS.getMessage());
			return false;
		}
		if (checkDuplicateNumber(input)) {
			System.out.println(DUPLICATE_NUMBER.getMessage());
			return false;
		}
		return true;
	}

	private boolean checkLength(String[] input) {
		if (input.length != 3) {
			return true;
		}
		return false;
	}

	private boolean isDigit(String[] input) {
		String strInput = String.join("", input);
		return strInput.chars().allMatch(Character::isDigit);
	}

	private boolean checkDuplicateNumber(String[] input) {
		boolean result = false;
		int i=0;
		while (!result && i < input.length) {
			result = hasDuplicateNumber(i, input[i], input);
			i++;
		}
		return result;
	}
	private boolean hasDuplicateNumber(int idx, String num, String[] input) {
		boolean result = false;
		int i=0;
		while (!result && i < idx){
			result = isSameNumber(num, input[i]);
			i++;
		}
		return result;
	}
	private boolean isSameNumber(String x, String y) {
		return x.equals(y);
	}
}
