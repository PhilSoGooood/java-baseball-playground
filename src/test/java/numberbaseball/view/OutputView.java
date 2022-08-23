package numberbaseball.view;

import static numberbaseball.view.ResultMessage.*;

public class OutputView {

	public void printResult(int[] score) {
		int ballCount = score[0];
		int strikeCount = score[1];
		String result = makeResultMessage(ballCount, strikeCount);
		System.out.println(result);
	}

	private String makeResultMessage(int ballCount, int strikeCount) {
		if (ballCount == 0 && strikeCount == 0) {
			return NOTHING.getMessage();
		}
		if (strikeCount == 0) {
			return ballCount + BALL.getMessage();
		}
		if (ballCount == 0) {
			return strikeCount + STRIKE.getMessage();
		}
		return (ballCount + BALL.getMessage() + " " + strikeCount + STRIKE.getMessage());
	}
}
