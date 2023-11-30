package lotto.dto;

import java.util.List;

public record LottosDto(long quantity, List<LottoDto> lottoDtos) {
}
