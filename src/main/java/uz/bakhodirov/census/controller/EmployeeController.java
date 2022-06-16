package uz.bakhodirov.census.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uz.bakhodirov.census.controller.base.AbstractController;
import uz.bakhodirov.census.dto.employee.EmployeeCreateDto;
import uz.bakhodirov.census.dto.employee.EmployeeDto;
import uz.bakhodirov.census.dto.quarter.QuarterCreateDto;
import uz.bakhodirov.census.dto.quarter.QuarterDto;
import uz.bakhodirov.census.dto.responce.DataDto;
import uz.bakhodirov.census.services.auth.EmployeeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeController extends AbstractController {

    private final EmployeeService employeeService;
    @PostMapping(PATH + "/employee/create")
    public ResponseEntity<DataDto<Long>> create(@RequestBody EmployeeCreateDto dto) {
        return employeeService.create(dto);
    }

    @GetMapping(PATH + "/employee/list")
    public ResponseEntity<DataDto<List<EmployeeDto>>> getAll() {
        return employeeService.getAll();
    }
}
