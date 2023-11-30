package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.PurchaseAmountValidator;

public class InputView {
    private static final InputView instance = new InputView();
    private static final String ASK_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";

    private InputView() {
    }

    public static InputView getInstance() {
        return instance;
    }

    public long readPurchaseAmount() {
        System.out.println(ASK_PURCHASE_AMOUNT);
        String input = Console.readLine();
        return PurchaseAmountValidator.safeParseLong(input);
    }
}
