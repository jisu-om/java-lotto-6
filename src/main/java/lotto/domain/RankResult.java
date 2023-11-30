package lotto.domain;

import java.util.List;

public class RankResult {
    private final List<LottoRank> lottoRanks;

    private RankResult(List<LottoRank> lottoRanks) {
        this.lottoRanks = lottoRanks;
    }

    public static RankResult from(List<LottoRank> lottoRanks) {
        return new RankResult(lottoRanks);
    }

    public long getRankCount(LottoRank rank) {
        return lottoRanks.stream()
                .filter(lottoRank -> lottoRank == rank)
                .count();
    }

    public long getTotalPrize() {
        return lottoRanks.stream()
                .mapToLong(LottoRank::getPrize)
                .sum();
    }
}
