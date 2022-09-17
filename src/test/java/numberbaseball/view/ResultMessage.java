package numberbaseball.view;

public enum ResultMessage {
	BALL("볼"), STRIKE("스트라이크"), NOTHING("낫싱"), CLEAR("3개의 숫자를 모두 맞히셨습니다! 게임 종료"), QUIT("안녕~~"), RESTART("게임을 다시 시작합니다");
	private final String message;
	ResultMessage(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
}
