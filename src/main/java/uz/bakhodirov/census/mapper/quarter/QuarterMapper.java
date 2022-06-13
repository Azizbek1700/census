package uz.bakhodirov.census.mapper.quarter;


import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.bakhodirov.census.dto.quarter.QuarterCreateDto;
import uz.bakhodirov.census.dto.quarter.QuarterDto;
import uz.bakhodirov.census.dto.quarter.QuarterUpdateDto;
import uz.bakhodirov.census.entity.quarter.Quarter;
import uz.bakhodirov.census.mapper.base.BaseMapper;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface QuarterMapper extends BaseMapper<Quarter, QuarterDto, QuarterCreateDto, QuarterUpdateDto> {

    @Override
    QuarterDto toDto(Quarter quarter);

    @Override
    List<QuarterDto> toDto(List<Quarter> e);

    @Override
    Quarter fromCreateDto(QuarterCreateDto quarterCreateDto);

    @Override
    Quarter fromUpdateDto(QuarterUpdateDto quarterUpdateDto);
}
