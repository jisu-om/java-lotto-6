package lotto.utils;

import lotto.domain.Lotto;
import org.junit.platform.commons.util.StringUtils;

import java.util.List;

import static lotto.constants.Constants.MAX_LOTTO_NUMBER;
import static lotto.constants.Constants.MIN_LOTTO_NUMBER;
import static lotto.exception.ErrorMessage.*;
import static lotto.exception.ErrorMessage.INVALID_LOTTO_NUMBER_RANGE;

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

    public static void validateBonusNumber(Lotto winningNumbers, int bonusNumber) {
        validateRange(bonusNumber);
        validateDuplicate(winningNumbers, bonusNumber);
    }

    private static void validateDuplicate(Lotto winningNumbers, int bonusNumber) {
        if (winningNumbers.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER.getMessage());
        }
    }

    private static void validateRange(int bonusNumber) {
        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }
}
