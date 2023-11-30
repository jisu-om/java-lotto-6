package lotto.domain;

import static lotto.constants.Constants.MAX_LOTTO_NUMBER;
import static lotto.constants.Constants.MIN_LOTTO_NUMBER;
import static lotto.exception.ErrorMessage.INVALID_BONUS_NUMBER;
import static lotto.exception.ErrorMessage.INVALID_LOTTO_NUMBER_RANGE;

public class WinningLotto {
    private final Lotto winningNumbers;
    private final int bonusNumber;

    private WinningLotto(Lotto winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(Lotto winningNumbers, int bonusNumber) {
        validateBonusNumber(winningNumbers, bonusNumber);
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private static void validateBonusNumber(Lotto winningNumbers, int bonusNumber) {
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
