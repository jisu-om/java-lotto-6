package lotto.domain;

import java.util.List;
import java.util.Optional;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos from(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public List<Lotto> getLottos() {
        return List.copyOf(lottos);
    }

    public RankResult findRanks(WinningLotto winningLotto) {
        List<LottoRank> lottoRanks = lottos.stream()
                .map(lotto -> LottoRank.findByMatchResult(
                        lotto.getMatchCount(winningLotto.getWinningNumbers()),
                        lotto.contains(winningLotto.getBonusNumber())))
                .flatMap(Optional::stream)
                .toList();
        return RankResult.from(lottoRanks);
    }

    public long getQuantity() {
        return lottos.size();
    }
}
