package lotto.view;

import lotto.dto.LottoDto;
import lotto.dto.LottosDto;
import lotto.dto.ResultDto;

import java.util.stream.Collectors;

public class OutputView {
    private static final OutputView instance = new OutputView();
    private static final String LOTTOS_QUANTITY_FORMAT = "%d개를 구매했습니다.";
    private static final String START_LOTTO_FORMAT = "[";
    private static final String END_LOTTO_FORMAT = "]";
    private static final String LOTTO_NUMBERS_DELIMITER = ", ";
    private static final String RESULT_TITLE = "당첨 통계";
    private static final String RESULT_SIGNATURE = "---";
    private static final String RESULT_FORMAT = "%d개 일치 (%,d원) - %d개";
    private static final String RESULT_FORMAT_BONUS_MATCH = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개";
    private static final int RANK_NEEDS_BONUS = 5;
    private static final String PROFIT_FORMAT = "총 수익률은 %,.1f%%입니다.";

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

    public void printResult(ResultDto resultDto) {
        printLine();
        System.out.println(RESULT_TITLE);
        System.out.println(RESULT_SIGNATURE);
        printRankResult(resultDto);
        printProfit(resultDto.profit());
    }

    private static void printRankResult(ResultDto resultDto) {
        resultDto.rankDtos().forEach(rankDto -> {
            String format = RESULT_FORMAT;
            if (rankDto.rank().isRequiresBonusMatch()) {
                format = RESULT_FORMAT_BONUS_MATCH;
            }
            System.out.printf((format) + "%n",
                    rankDto.rank().getMatchCount(), rankDto.rank().getPrize(), rankDto.quantity());
        });
    }

    private void printProfit(double profit) {
        System.out.printf((PROFIT_FORMAT) + "%n", profit);
    }
}
