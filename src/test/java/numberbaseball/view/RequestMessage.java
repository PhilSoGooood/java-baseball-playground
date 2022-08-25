package numberbaseball.view;

public enum RequestMessage {
	REQUEST_NUMBER("숫자를 입력해 주세요 : "), RESTART_OR_QUIT("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");

	private final String message;

	RequestMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
