package io.angularattack.loweredexpectations.rankit.api;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Accessors(chain=true)
public class RankDto {
    private UUID rankId;
    private String description;
    private Integer score;
}
