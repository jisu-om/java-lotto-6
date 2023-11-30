package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import lotto.dto.LottosDto;
import lotto.service.LottoMaker;
import lotto.utils.Mapper;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.function.Supplier;

public class MainController {
    private final InputView inputView;
    private final OutputView outputView;
    //private OrderController orderController;  //컨트롤러 추가하는 경우

    private MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public static MainController create() {
        return new MainController(InputView.getInstance(), OutputView.getInstance());
    }

    public void run() {
        PurchaseAmount purchaseAmount = createPurchaseAmount();
        long quantityOfLotto = purchaseAmount.getQuantityOfLotto();
        List<Lotto> lottosMade = LottoMaker.makeLottos(quantityOfLotto);
        Lottos lottos = Lottos.from(lottosMade);
        LottosDto lottosDto = Mapper.toLottosDto(lottos);
        outputView.printLottos(lottosDto);

    }

//    private void initializeControllers() {
//        orderController = OrderController.of(inputView, outputView);
//    }

    private PurchaseAmount createPurchaseAmount() {
        return readUserInput(() -> {
            long input = inputView.readPurchaseAmount();
            return PurchaseAmount.from(input);
        });
    }

    private Orders createOrders() {
        return readUserInput(() -> {
            List<OrderItem> items = inputView.readOrders().stream()
                    .map(OrderItemDto::toOrderItem)
                    .toList();
            return Orders.from(items);
        });
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
