package uz.bakhodirov.census.dto.employee;

import lombok.Getter;
import lombok.Setter;
import uz.bakhodirov.census.dto.base.GenericDto;
import uz.bakhodirov.census.entity.employmentStatus.*;
import uz.bakhodirov.census.entity.quarter.Quarter;
import uz.bakhodirov.census.enums.Role;

import javax.validation.constraints.NotBlank;
import java.util.List;


@Getter
@Setter
public class EmployeeDto extends GenericDto {

    @NotBlank
    private String fullName;

    @NotBlank
    private String passportInfo;


    @NotBlank
    private String username;


    @NotBlank
    private String address;

    @NotBlank
    private String phoneNumber;

    @NotBlank
    private String password;

    @NotBlank
    private String role;

    @NotBlank
    private String gender;

    @NotBlank
    private String familyStatus;

    private Quarter quarter;

    private EmploymentStatus employmentStatus;

    private Educationalnfo educationalnfo;

    private HealthStatus healthStatus;

    private YouthNotebook youthNotebook;

    private List<SocialStatus> socialStatus;

}
