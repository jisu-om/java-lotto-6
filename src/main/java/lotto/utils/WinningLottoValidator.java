package lotto.utils;

import org.junit.platform.commons.util.StringUtils;

import java.util.List;

import static lotto.exception.ErrorMessage.INVALID_WINNING_NUMBERS;
import static lotto.exception.ErrorMessage.NOT_NUMERIC_INPUT;

public class WinningLottoValidator {
    public static List<Integer> safeSplit(String input, String delimiter) {
        validateEmpty(input);
        validateStartsOrEndsWithDelimiter(input, delimiter);
        List<String> splitInput = List.of(input.split(delimiter));
        return splitInput.stream()
                .map(WinningLottoValidator::safeParseInt)
                .toList();
    }

    private static void validateEmpty(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBERS.getMessage());
        }
    }

    private static void validateStartsOrEndsWithDelimiter(String input, String delimiter) {
        if (input.startsWith(delimiter) || input.endsWith(delimiter)) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBERS.getMessage());
        }
    }

    public static int safeParseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMERIC_INPUT.getMessage());
        }
    }
}
