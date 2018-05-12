package io.angularattack.loweredexpectations.chili.api;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
public class HelloDto {
    private String firstName;
    private String lastName;
    private String message;
}
