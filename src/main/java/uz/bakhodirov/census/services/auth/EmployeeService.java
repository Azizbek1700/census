package uz.bakhodirov.census.services.auth;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.bakhodirov.census.dto.employee.EmployeeCreateDto;
import uz.bakhodirov.census.dto.employee.EmployeeDto;
import uz.bakhodirov.census.dto.employee.EmployeeUpdateDto;
import uz.bakhodirov.census.dto.quarter.QuarterDto;
import uz.bakhodirov.census.dto.responce.AppErrorDto;
import uz.bakhodirov.census.dto.responce.DataDto;
import uz.bakhodirov.census.entity.auth.Employee;
import uz.bakhodirov.census.entity.quarter.Quarter;
import uz.bakhodirov.census.entity.todo.Todo;
import uz.bakhodirov.census.mapper.auth.EmployeeMapper;
import uz.bakhodirov.census.repository.auth.EmployeeRepository;
import uz.bakhodirov.census.services.base.AbstractService;
import uz.bakhodirov.census.services.base.GenericCrudService;
import uz.bakhodirov.census.session.SessionUser;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService extends AbstractService<EmployeeRepository, EmployeeMapper> implements GenericCrudService<Employee, EmployeeDto, EmployeeCreateDto, EmployeeUpdateDto,Long> {
    public EmployeeService(EmployeeRepository repository, EmployeeMapper mapper, SessionUser sessionUser) {
        super(repository, mapper);
        this.sessionUser = sessionUser;
    }
    private final SessionUser sessionUser;


    @Override
    public ResponseEntity<DataDto<Long>> create(EmployeeCreateDto createDto) {

        Employee employee = mapper.fromCreateDto(createDto);

        employee.setCreatedBy(sessionUser.getId());
        repository.save(employee);
        return new ResponseEntity<>(new DataDto<>(repository.save(employee).getId()), HttpStatus.OK);



    }

    @Override
    public ResponseEntity<DataDto<Void>> delete(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<DataDto<Long>> update(EmployeeUpdateDto updateDto) {
        return null;
    }

    @Override
    public ResponseEntity<DataDto<List<EmployeeDto>>> getAll() {
        List<Employee> employeeList = repository.findAllByDeletedFalse();
        List<EmployeeDto> employeeDtos = mapper.toDto(employeeList);

        return new ResponseEntity<>(new DataDto<>(employeeDtos), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DataDto<EmployeeDto>> get(Long id) {
        return null;
    }
}
