package uz.bakhodirov.census.dto.base;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public abstract class GenericDto implements BaseDto {
    @NotBlank
    private Long id;
}
