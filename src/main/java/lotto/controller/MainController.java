package lotto.controller;

import lotto.domain.*;
import lotto.dto.LottosDto;
import lotto.dto.ResultDto;
import lotto.service.LottoMaker;
import lotto.utils.Mapper;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.function.Supplier;

public class MainController {
    private final InputView inputView;
    private final OutputView outputView;

    private MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public static MainController create() {
        return new MainController(InputView.getInstance(), OutputView.getInstance());
    }

    public void run() {
        PurchaseAmount purchaseAmount = createPurchaseAmount();
        Lottos lottos = createLottos(purchaseAmount);
        printLottos(lottos);
        WinningLotto winningLotto = createWinningLotto();
        printResult(lottos, winningLotto, purchaseAmount);
    }

    private PurchaseAmount createPurchaseAmount() {
        return readUserInput(() -> {
            long input = inputView.readPurchaseAmount();
            return PurchaseAmount.from(input);
        });
    }

    private Lottos createLottos(PurchaseAmount purchaseAmount) {
        long quantityOfLotto = purchaseAmount.getQuantityOfLotto();
        List<Lotto> lottosMade = LottoMaker.makeLottos(quantityOfLotto);
        return Lottos.from(lottosMade);
    }

    private void printLottos(Lottos lottos) {
        LottosDto lottosDto = Mapper.toLottosDto(lottos);
        outputView.printLottos(lottosDto);
    }

    private WinningLotto createWinningLotto() {
        Lotto winningNumbers = createWinningNumbers();
        return readUserInput(() -> {
            int bonusNumber = inputView.readBonusNumber();
            return WinningLotto.of(winningNumbers, bonusNumber);
        });
    }

    private Lotto createWinningNumbers() {
        return readUserInput(() -> {
            List<Integer> numbers = inputView.readWinningNumbers();
            return new Lotto(numbers);
        });
    }

    private void printResult(Lottos lottos, WinningLotto winningLotto, PurchaseAmount purchaseAmount) {
        RankResult rankResult = lottos.findRanks(winningLotto);
        ResultDto resultDto = Mapper.toTotalRankDto(purchaseAmount, rankResult);
        outputView.printResult(resultDto);
    }

    private <T> T readUserInput(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }
}
