package lotto.domain;

import java.util.HashSet;
import java.util.List;

import static lotto.constants.Constants.*;
import static lotto.exception.ErrorMessage.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicates(numbers);
        validateRange(numbers);
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBERS_SIZE.getMessage());
        }
    }

    private void validateDuplicates(List<Integer> numbers) {
        HashSet<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (numbers.size() != uniqueNumbers.size()) {
            throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBERS.getMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        boolean isOutOfRange = numbers.stream()
                .anyMatch(number -> number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER);
        if (isOutOfRange) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    public int getMatchCount(Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto.numbers::contains)
                .count();
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }
}
