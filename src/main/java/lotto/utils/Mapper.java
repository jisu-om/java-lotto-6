package lotto.utils;

import lotto.domain.LottoRank;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import lotto.domain.RankResult;
import lotto.dto.LottoDto;
import lotto.dto.LottosDto;
import lotto.dto.RankDto;
import lotto.dto.ResultDto;

import java.util.Arrays;
import java.util.List;

public class Mapper {
    public static LottosDto toLottosDto(Lottos lottos) {
        List<LottoDto> lottoDtos = lottos.getLottos().stream()
                .map(lotto -> new LottoDto(lotto.getNumbers()))
                .toList();
        return new LottosDto(lottos.getQuantity(), lottoDtos);
    }

    public static ResultDto toTotalRankDto(PurchaseAmount purchaseAmount, RankResult rankResult) {
        List<RankDto> rankDtos = Arrays.stream(LottoRank.values())
                .map(rank -> new RankDto(rank, rankResult.getRankCount(rank)))
                .toList();
        long totalPrize = rankResult.getTotalPrize();
        double profit = (double)totalPrize / purchaseAmount.getAmount() * 100;
        profit = Math.round(profit * 100.0) / 100.0;
        return new ResultDto(rankDtos, profit);
    }
}
