package lotto.service;

import lotto.domain.Lotto;
import lotto.utils.LottoNumbersGenerator;

import java.util.List;
import java.util.stream.Stream;

public class LottoMaker {
    public static List<Lotto> makeLottos(long quantity) {
        return Stream.generate(() -> new Lotto(LottoNumbersGenerator.generate()))
                .limit(quantity)
                .toList();
    }
}
