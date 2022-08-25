package numberbaseball;

import java.io.IOException;

import numberbaseball.domain.NumberBaseball;
import numberbaseball.domain.Referee;
import numberbaseball.view.InputView;
import numberbaseball.view.OutputView;

public class Game {
	private final InputView inputView = new InputView();
	private final OutputView outputView = new OutputView();
	private final NumberBaseball numberBaseball = new NumberBaseball();
	private final Referee referee = new Referee();

	public void run() throws IOException {
		numberBaseball.setUp();
		boolean running = true;
		while (running) {
			int[] input = inputView.getPlayerNumber();
			int[] answer = numberBaseball.getAnswer();
			int[] score = referee.judge(answer, input);
			outputView.printResult(score);
			running = checkStrikeCount(score[1]);
		}
	}

	private boolean checkStrikeCount(int strikeCount) throws IOException {
		if (strikeCount == 3) {
			int response = inputView.requestContinue();
			return checkResponse(response);
		}
		return true;
	}

	private boolean checkResponse(int response) {
		if (response == 2) {
			outputView.printQuitMessage();
			return false;
		}
		numberBaseball.setUp();
		outputView.printRestartMessage();
		return true;
	}
}
