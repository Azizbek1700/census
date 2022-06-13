package uz.bakhodirov.census.dto.quarter;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import uz.bakhodirov.census.dto.base.GenericDto;


@Getter
@Setter
public class QuarterDto extends GenericDto {
    private String name;
    private String code;
    private String address;

}
