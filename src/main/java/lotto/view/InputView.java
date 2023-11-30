package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.WinningLotto;
import lotto.utils.PurchaseAmountValidator;
import lotto.utils.WinningLottoValidator;

import java.util.List;

public class InputView {
    private static final InputView instance = new InputView();
    private static final String ASK_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String ASK_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String WINNING_NUMBERS_DELIMITER = ",";
    private static final String ASK_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

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

    public List<Integer> readWinningNumbers() {
        printLine();
        System.out.println(ASK_WINNING_NUMBERS);
        String input = Console.readLine();
        return WinningLottoValidator.safeSplit(input, WINNING_NUMBERS_DELIMITER);
    }

    private static void printLine() {
        System.out.println();
    }

    public int readBonusNumber() {
        printLine();
        System.out.println(ASK_BONUS_NUMBER);
        String input = Console.readLine();
        return WinningLottoValidator.safeParseInt(input);
    }
}
