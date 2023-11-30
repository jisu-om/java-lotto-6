package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class PurchaseAmountTest {
    @DisplayName("PurchaseAmount 정상 생성")
    @Test
    void create() {
        PurchaseAmount purchaseAmount = PurchaseAmount.from(1000);
        assertThat(purchaseAmount).isNotNull();
    }

    @ParameterizedTest(name = "[{index}] PurchaseAmount 생성 시 {0} 을 입력하면 예외 발생한다.")
    @ValueSource(ints = {1, 110, 0, -1000})
    void exception(int element) {
        assertThatThrownBy(() -> PurchaseAmount.from(element))
                .isInstanceOf(IllegalArgumentException.class);
    }
}