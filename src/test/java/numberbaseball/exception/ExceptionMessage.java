package numberbaseball.exception;

public enum ExceptionMessage {
	NOT_THREE_NUMBERS("세자리 숫자를 입력해주세요"), NOT_NUMBERS("숫자만 입력해주세요"), DUPLICATE_NUMBER("중복되지 않는 숫자를 입력해주세요");

	private final String message;

	ExceptionMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
