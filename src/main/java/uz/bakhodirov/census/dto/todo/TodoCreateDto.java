package uz.bakhodirov.census.dto.todo;

import lombok.Data;
import uz.bakhodirov.census.dto.base.BaseDto;

@Data
public class TodoCreateDto implements BaseDto {
    private String name;
    private String description;

}
