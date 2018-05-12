package io.angularattack.loweredexpectations.rankit.api;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class RankedGroupDto {
    private UUID id;
    private String name;
    private List<RankedItemDto> rankedItems = new ArrayList<>();
}
