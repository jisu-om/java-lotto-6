package lotto.dto;

import java.util.List;

public record ResultDto(List<RankDto> rankDtos, double profit) {
}
