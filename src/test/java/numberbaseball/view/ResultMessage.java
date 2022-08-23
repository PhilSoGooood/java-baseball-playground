package numberbaseball.view;

public enum ResultMessage {
	BALL("볼"), STRIKE("스트라이크"), NOTHING("낫싱");
	private final String message;
	ResultMessage(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
}
