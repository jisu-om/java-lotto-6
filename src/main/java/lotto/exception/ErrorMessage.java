package lotto.exception;

public enum ErrorMessage {
    ERROR_CAPTION("[ERROR] "),
    NOT_NUMERIC_INPUT("숫자를 입력해 주세요."),
    NOT_POSITIVE_INPUT("0 보다 큰 수를 입력해 주세요."),
    INVALID_PURCHASE_AMOUNT("1000 으로 나누어 떨어지는 값을 입력해 주세요."),
    INVALID_LOTTO_NUMBERS_SIZE("유효하지 않은 로또 숫자 개수 입니다."),
    DUPLICATED_LOTTO_NUMBERS("중복된 로또 숫자가 있습니다."),
    INVALID_LOTTO_NUMBER_RANGE("1 이상 45 이하의 숫자만 가능합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_CAPTION.message + message;
    }
}
