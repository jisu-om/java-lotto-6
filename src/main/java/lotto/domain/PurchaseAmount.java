package lotto.domain;

import lotto.utils.PurchaseAmountValidator;

import static lotto.constants.Constants.LOTTO_PRICE;

public class PurchaseAmount {
    private final long amount;

    private PurchaseAmount(long amount) {
        this.amount = amount;
    }

    public static PurchaseAmount from(long amount) {
        PurchaseAmountValidator.validatePositive(amount);
        PurchaseAmountValidator.validateDividedByUnit(amount);
        return new PurchaseAmount(amount);
    }

    public long getQuantityOfLotto() {
        return amount / LOTTO_PRICE;
    }

    public long getAmount() {
        return amount;
    }
}
