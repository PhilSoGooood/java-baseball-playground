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
		if (input.length != 3) {
			System.out.println(NOT_THREE_NUMBERS.getMessage());
			return false;
		}
		return true;
	}
}
