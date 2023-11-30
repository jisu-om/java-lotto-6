package lotto.domain;

import lotto.utils.PurchaseAmountValidator;

public class PurchaseAmount {
    private final long amount;

    private PurchaseAmount(long amount) {
        this.amount = amount;
    }

    public static PurchaseAmount of(long amount) {
        PurchaseAmountValidator.validatePositive(amount);
        PurchaseAmountValidator.validateDividedByUnit(amount);
        return new PurchaseAmount(amount);
    }


}
