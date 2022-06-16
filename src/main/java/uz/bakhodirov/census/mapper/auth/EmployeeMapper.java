package uz.bakhodirov.census.mapper.auth;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.bakhodirov.census.dto.auth.AuthCreateDto;
import uz.bakhodirov.census.dto.auth.AuthDto;
import uz.bakhodirov.census.dto.auth.AuthUpdateDto;
import uz.bakhodirov.census.dto.employee.EmployeeCreateDto;
import uz.bakhodirov.census.dto.employee.EmployeeDto;
import uz.bakhodirov.census.dto.employee.EmployeeUpdateDto;
import uz.bakhodirov.census.entity.auth.AuthUser;
import uz.bakhodirov.census.entity.auth.Employee;
import uz.bakhodirov.census.mapper.base.BaseMapper;

import java.util.List;


@Component
@Mapper(componentModel = "spring")
public interface EmployeeMapper extends BaseMapper<Employee, EmployeeDto, EmployeeCreateDto, EmployeeUpdateDto> {

    @Override
    EmployeeDto toDto(Employee employee);

    @Override
    List<EmployeeDto> toDto(List<Employee> e);

    @Override
    Employee fromCreateDto(EmployeeCreateDto employeeCreateDto);

    @Override
    Employee fromUpdateDto(EmployeeUpdateDto employeeUpdateDto);
}
