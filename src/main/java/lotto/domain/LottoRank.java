package lotto.domain;

import java.util.Arrays;
import java.util.Optional;

public enum LottoRank {
    FIFTH(3, false,5_000),
    FOURTH(4, false,50_000),
    THIRD(5, false,1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);

    private final int matchCount;
    private final boolean requiresBonusMatch;
    private final int prize;

    LottoRank(int matchCount, boolean requiresBonusMatch, int prize) {
        this.matchCount = matchCount;
        this.requiresBonusMatch = requiresBonusMatch;
        this.prize = prize;
    }

    public static Optional<LottoRank> findByMatchResult(int matchCount, boolean bonusMatch) {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank.matchCount == matchCount && (matchCount != 5 || rank.requiresBonusMatch == bonusMatch))
                .findAny();
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isRequiresBonusMatch() {
        return requiresBonusMatch;
    }

    public int getPrize() {
        return prize;
    }
}
