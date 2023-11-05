package lotto.domain;

import lotto.exception.ErrorMessage;
import lotto.validator.LottoNumberValidator;

public class LottoPurchaseManager {
    private static final int LOTTO_PRICE = 1000;
    private final LottoGenerator lottoGenerator;
    private long inputMoney;

    public LottoPurchaseManager(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public Lottos createLottos(String input) {
        long quantity = calculateLottoQuantity(input);
        return lottoGenerator.generateLottos(quantity);
    }

    public long getInputMoney() {
        return inputMoney;
    }

    private long calculateLottoQuantity(String input) {
        inputMoney = LottoNumberValidator.validateNumeric(input);
        validatePurchaseAmount(inputMoney);
        return inputMoney / LOTTO_PRICE;
    }

    private void validatePurchaseAmount(long money) {
        validatePositive(money);
        validateMultipleOfLottoPrice(money);
    }

    private void validatePositive(long money) {
        if (money <= 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_NEGATIVE.getMessage());
        }
    }

    private void validateMultipleOfLottoPrice(long money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_NOT_MULTIPLE_OF_LOTTO_PRICE.getMessage());
        }
    }
}
