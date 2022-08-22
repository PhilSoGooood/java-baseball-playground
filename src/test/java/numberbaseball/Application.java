package numberbaseball;

import java.io.IOException;
import java.util.Arrays;

import numberbaseball.view.InputView;

public class Application {
	public static void main(String[] args) throws IOException {
		InputView inputView = new InputView();
		int[] input = inputView.getPlayerNumber();

		System.out.println(Arrays.toString(input));
	}
}
