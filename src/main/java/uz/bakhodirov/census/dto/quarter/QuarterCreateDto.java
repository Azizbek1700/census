package uz.bakhodirov.census.dto.quarter;

import lombok.Data;
import uz.bakhodirov.census.dto.base.BaseDto;

@Data
public class QuarterCreateDto implements BaseDto {
    private String name;
    private String code;
    private String address;

}
