package uz.bakhodirov.census.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.bakhodirov.census.controller.base.AbstractController;
import uz.bakhodirov.census.criteria.GenericCriteria;
import uz.bakhodirov.census.dto.responce.DataDto;
import uz.bakhodirov.census.dto.todo.TodoCreateDto;
import uz.bakhodirov.census.dto.todo.TodoDto;
import uz.bakhodirov.census.services.todo.TodoServices;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class TodoController extends AbstractController {
    private final TodoServices todoServices;

//    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(PATH + "/todo/create")
    public ResponseEntity<DataDto<Long>> create(@RequestBody TodoCreateDto dto) {
        return todoServices.create(dto);
    }

    @GetMapping(PATH + "/todo/getAll")
    public ResponseEntity<DataDto<List<TodoDto>>> getAll() {
        return todoServices.getAll();
    }


    @GetMapping(PATH+"/todo/listCriteria")
    public ResponseEntity<DataDto<List<TodoDto>>> getAllCriteria( GenericCriteria criteria) {
        return todoServices.getAllCriteria( criteria );
    }
    @GetMapping(PATH + "/todo/get/{id}")
    public ResponseEntity<DataDto<TodoDto>> get(@PathVariable Long id) {
        return todoServices.get(id);
    }

    @GetMapping(PATH + "/todo/delete/{id}")
    public ResponseEntity<DataDto<Void>> delete(@PathVariable Long id) {
        return todoServices.delete(id);
    }





}
