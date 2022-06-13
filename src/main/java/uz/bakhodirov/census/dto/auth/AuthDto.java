package uz.bakhodirov.census.dto.auth;

import lombok.Getter;
import lombok.Setter;
import uz.bakhodirov.census.dto.base.GenericDto;
import uz.bakhodirov.census.enums.Role;


@Getter
@Setter
public class AuthDto extends GenericDto {

    private String fullName;

    private String username;

    private String phoneNumber;

    private Long organizationId;

    private String picturePath;

    private Role role;

}
