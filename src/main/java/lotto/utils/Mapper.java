package lotto.utils;

import lotto.domain.Lottos;
import lotto.dto.LottoDto;
import lotto.dto.LottosDto;

import java.util.List;

public class Mapper {
    public static LottosDto toLottosDto(Lottos lottos) {
        List<LottoDto> lottoDtos = lottos.getLottos().stream()
                .map(lotto -> new LottoDto(lotto.getNumbers()))
                .toList();
        return new LottosDto(lottos.getQuantity(), lottoDtos);
    }
}
