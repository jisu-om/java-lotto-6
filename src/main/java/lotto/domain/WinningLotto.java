package lotto.domain;

import lotto.utils.WinningLottoValidator;

public class WinningLotto {
    private final Lotto winningNumbers;
    private final int bonusNumber;

    private WinningLotto(Lotto winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(Lotto winningNumbers, int bonusNumber) {
        WinningLottoValidator.validateBonusNumber(winningNumbers, bonusNumber);
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
