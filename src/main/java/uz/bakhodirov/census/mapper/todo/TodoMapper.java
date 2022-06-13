package uz.bakhodirov.census.mapper.todo;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.bakhodirov.census.dto.todo.TodoCreateDto;
import uz.bakhodirov.census.dto.todo.TodoDto;
import uz.bakhodirov.census.dto.todo.TodoUpdateDto;
import uz.bakhodirov.census.entity.todo.Todo;
import uz.bakhodirov.census.mapper.base.BaseMapper;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface TodoMapper extends BaseMapper<Todo, TodoDto, TodoCreateDto, TodoUpdateDto> {

    @Override
    TodoDto toDto(Todo todo);

    @Override
    List<TodoDto> toDto(List<Todo> e);

    @Override
    Todo fromCreateDto(TodoCreateDto todoCreateDto);

    @Override
    Todo fromUpdateDto(TodoUpdateDto todoUpdateDto);
}
