package lotto.view;

import lotto.dto.LottoDto;
import lotto.dto.LottosDto;

import java.util.stream.Collectors;

public class OutputView {
    private static final OutputView instance = new OutputView();
    private static final String LOTTOS_QUANTITY_FORMAT = "%d개를 구매했습니다.";
    private static final String START_LOTTO_FORMAT = "[";
    private static final String END_LOTTO_FORMAT = "]";
    private static final String LOTTO_NUMBERS_DELIMITER = ", ";



    private OutputView() {
    }

    public static OutputView getInstance() {
        return instance;
    }

    public void printError(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printLottos(LottosDto lottosDto) {
        printLottoQuantity(lottosDto.quantity());
        lottosDto.lottoDtos().forEach(this::printLotto);
    }
    public void printLottoQuantity(long quantity) {
        printLine();
        System.out.printf((LOTTOS_QUANTITY_FORMAT) + "%n", quantity);
    }

    private void printLine() {
        System.out.println();
    }

    private void printLotto(LottoDto lottoDto) {
        System.out.print(START_LOTTO_FORMAT);
        String lottoNumbers = lottoDto.numbers().stream()
                .map(Object::toString)
                .collect(Collectors.joining(LOTTO_NUMBERS_DELIMITER));
        System.out.print(lottoNumbers);
        System.out.print(END_LOTTO_FORMAT);
        printLine();
    }
}
