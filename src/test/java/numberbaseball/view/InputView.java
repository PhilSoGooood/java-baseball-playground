package numberbaseball.view;

import static numberbaseball.view.RequestMessage.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {

	private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public int[] getPlayerNumber() throws IOException {
		System.out.print(REQUEST_NUMBER.getMessage());
		String[] input = br.readLine().split("");
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
}
