package numberbaseball.view;

public enum RequestMessage {
	REQUEST_NUMBER("숫자를 입력해 주세요 : ");

	private final String message;

	RequestMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
