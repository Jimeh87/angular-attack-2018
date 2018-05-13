package io.angularattack.loweredexpectations.rankit.api;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.UUID;

@Data
@Accessors(chain = true)
@ToString
public class RankedItemDto {
    private UUID id;
    private String name;
    private String image;
    private Integer score;
}
