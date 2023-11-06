package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String ASK_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String ASK_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String ASK_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public void printAskPurchaseAmount() {
        System.out.println(ASK_PURCHASE_AMOUNT);
    }

    public void printAskWinningNumbers() {
        System.out.println(ASK_WINNING_NUMBERS);
    }

    public void printAskBonusNumber() {
        System.out.println();
        System.out.println(ASK_BONUS_NUMBER);
    }

    public String readInputFromUser() {
        return Console.readLine();
    }
}
