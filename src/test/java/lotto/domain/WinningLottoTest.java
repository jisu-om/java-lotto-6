package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;


class WinningLottoTest {
    @ParameterizedTest
    @ValueSource(ints = {47, 0, -1, 6})
    void exception(int element) {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Assertions.assertThatThrownBy(() -> WinningLotto.of(winningNumbers, element))
                .isInstanceOf(IllegalArgumentException.class);
    }

}