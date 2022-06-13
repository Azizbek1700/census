package uz.bakhodirov.census.mapper.auth;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.bakhodirov.census.dto.auth.AuthCreateDto;
import uz.bakhodirov.census.dto.auth.AuthDto;
import uz.bakhodirov.census.dto.auth.AuthUpdateDto;
import uz.bakhodirov.census.entity.auth.AuthUser;
import uz.bakhodirov.census.mapper.base.BaseMapper;


@Component
@Mapper(componentModel = "spring")
public interface AuthUserMapper extends BaseMapper<AuthUser, AuthDto, AuthCreateDto, AuthUpdateDto> {
}
