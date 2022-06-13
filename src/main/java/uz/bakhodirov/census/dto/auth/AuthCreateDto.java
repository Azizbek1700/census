package uz.bakhodirov.census.dto.auth;

import lombok.*;
import uz.bakhodirov.census.dto.base.BaseDto;

import javax.validation.constraints.NotBlank;

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



}
