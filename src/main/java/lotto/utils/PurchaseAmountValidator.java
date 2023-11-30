package lotto.utils;

import static lotto.exception.ErrorMessage.*;

public class PurchaseAmountValidator {
    private static final int PURCHASE_AMOUNT_UNIT = 1000;

    public static long safeParseLong(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMERIC_INPUT.getMessage());
        }
    }

    public static void validatePositive(long value) {
        if (value <= 0) {
            throw new IllegalArgumentException(NOT_POSITIVE_INPUT.getMessage());
        }
    }

    public static void validateDividedByUnit(long value) {
        if (value % PURCHASE_AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }
}
