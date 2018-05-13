package io.angularattack.loweredexpectations.rankit.api;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
public class MatchDto {
    private RankedItemDto itemA;
    private RankedItemDto itemB;
}
