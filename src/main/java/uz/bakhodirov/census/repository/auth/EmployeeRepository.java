package uz.bakhodirov.census.repository.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import uz.bakhodirov.census.entity.auth.AuthUser;
import uz.bakhodirov.census.entity.auth.Employee;
import uz.bakhodirov.census.entity.quarter.Quarter;
import uz.bakhodirov.census.entity.todo.Todo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findAllByDeletedFalse();


}
