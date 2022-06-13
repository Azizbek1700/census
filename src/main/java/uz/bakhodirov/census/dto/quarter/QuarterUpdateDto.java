package uz.bakhodirov.census.dto.quarter;

import lombok.Data;
import uz.bakhodirov.census.dto.base.GenericDto;

@Data
public class QuarterUpdateDto extends GenericDto {
    private String name;
    private String code;
    private String address;
}
