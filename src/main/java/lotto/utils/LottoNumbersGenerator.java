package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.constants.Constants.LOTTO_NUMBERS_SIZE;
import static lotto.constants.Constants.MIN_LOTTO_NUMBER;
import static lotto.constants.Constants.MAX_LOTTO_NUMBER;

public class LottoNumbersGenerator {
    public static List<Integer> generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBERS_SIZE);
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }
}
