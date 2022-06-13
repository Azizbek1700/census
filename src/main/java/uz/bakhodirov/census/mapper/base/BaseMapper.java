package uz.bakhodirov.census.mapper.base;

import uz.bakhodirov.census.dto.base.BaseDto;
import uz.bakhodirov.census.dto.base.GenericDto;
import uz.bakhodirov.census.entity.base.BaseEntity;

import java.util.List;

/**
 * @param <E>  -> Entity
 * @param <D>  -> Dto
 * @param <CD> -> Create Dto
 * @param <UD> -> Update Dto
 */

public interface BaseMapper<
        E extends BaseEntity,
        D extends GenericDto,
        CD extends BaseDto,
        UD extends GenericDto>{

    D toDto(E e);

    List<D> toDto(List<E> e);

    E fromCreateDto(CD cd);

    E fromUpdateDto(UD ud);

}