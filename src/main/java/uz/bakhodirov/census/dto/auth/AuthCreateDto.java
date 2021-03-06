package uz.bakhodirov.census.dto.auth;

import lombok.*;
import uz.bakhodirov.census.dto.base.BaseDto;
import uz.bakhodirov.census.entity.employmentStatus.*;
import uz.bakhodirov.census.entity.quarter.Quarter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthCreateDto implements BaseDto {

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

    private Quarter quarter;

    private EmploymentStatus employmentStatus;

    private Educationalnfo educationalnfo;

    private HealthStatus healthStatus;

    private YouthNotebook youthNotebook;

    private List<SocialStatus> socialStatus;






}
