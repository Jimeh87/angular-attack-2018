package io.angularattack.loweredexpectations.rankit.api;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.UUID;

@Data
@Accessors(chain=true)
public class MatchOutcomeDto {
    private UUID optionAId;
    private UUID optionBId;
    private MatchResultEnum result;
}
