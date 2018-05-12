package io.angularattack.loweredexpectations.rankit.api;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
public class EloOutcomeDto {
    private Integer scoreA;
    private Integer scoreB;
}
