package uz.bakhodirov.census.dto.todo;

import lombok.Data;
import uz.bakhodirov.census.dto.base.GenericDto;

@Data
public class TodoUpdateDto extends GenericDto {
    private String name;
    private String description;
}
