package numberbaseball;

import java.io.IOException;
import java.util.Arrays;

import numberbaseball.domain.NumberBaseball;
import numberbaseball.domain.Referee;
import numberbaseball.view.InputView;
import numberbaseball.view.OutputView;

public class Application {
	public static void main(String[] args) throws IOException {
		NumberBaseball numberBaseball = new NumberBaseball();
		Referee referee = new Referee();
		InputView inputView = new InputView();
		OutputView outputView = new OutputView();
		int[] input = inputView.getPlayerNumber();
		int[] answer = numberBaseball.getAnswer();
		int[] score = referee.judge(answer, input);
		System.out.println(Arrays.toString(answer));
		outputView.printResult(score);
	}
}
