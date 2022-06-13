package uz.bakhodirov.census.services.quarter;


import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.bakhodirov.census.criteria.GenericCriteria;
import uz.bakhodirov.census.dto.quarter.QuarterCreateDto;
import uz.bakhodirov.census.dto.quarter.QuarterDto;
import uz.bakhodirov.census.dto.quarter.QuarterUpdateDto;
import uz.bakhodirov.census.dto.responce.AppErrorDto;
import uz.bakhodirov.census.dto.responce.DataDto;
import uz.bakhodirov.census.entity.quarter.Quarter;
import uz.bakhodirov.census.mapper.quarter.QuarterMapper;
import uz.bakhodirov.census.repository.quarter.QuarterRepository;
import uz.bakhodirov.census.services.base.AbstractService;
import uz.bakhodirov.census.services.base.GenericCrudService;
import uz.bakhodirov.census.session.SessionUser;

import java.util.List;
import java.util.Optional;

@Service
public class QuarterServices extends AbstractService<QuarterRepository, QuarterMapper> implements GenericCrudService<Quarter, QuarterDto, QuarterCreateDto, QuarterUpdateDto,Long> {

    public QuarterServices(QuarterRepository repository, QuarterMapper mapper, SessionUser sessionUser) {
        super(repository, mapper);
        this.sessionUser = sessionUser;
    }
    private final SessionUser sessionUser;
    @Override
    public ResponseEntity<DataDto<Long>> create(QuarterCreateDto createDto) {
        boolean checkName = repository.existsByNameAndDeletedFalse(createDto.getName());
        if (checkName) {
            return new ResponseEntity<>(new DataDto<>(new AppErrorDto(HttpStatus.CONFLICT, "quarter already taken", "quarter")), HttpStatus.OK);
        }
        Quarter quarter = mapper.fromCreateDto(createDto);

        quarter.setCreatedBy(sessionUser.getId());
        repository.save(quarter);
        return new ResponseEntity<>(new DataDto<>(repository.save(quarter).getId()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DataDto<Void>> delete(Long id) {
        Optional<Quarter> checkId = repository.findByIdAndDeletedFalse(id);

        if (checkId.isEmpty()) {
            return new ResponseEntity<>(new DataDto<>(new AppErrorDto(HttpStatus.NOT_FOUND, "todo Not  found", "todo")), HttpStatus.OK);
        }
        repository.delete(id);


        return new ResponseEntity<>(new DataDto<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DataDto<Long>> update(QuarterUpdateDto updateDto) {
        return null;
    }

    @Override
    public ResponseEntity<DataDto<List<QuarterDto>>> getAll() {

            List<Quarter> quarterList = repository.findAllByDeletedFalse();
            List<QuarterDto> quarterDtos = mapper.toDto(quarterList);

            return new ResponseEntity<>(new DataDto<>(quarterDtos), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DataDto<QuarterDto>> get(Long id) {
        Optional<Quarter> quarterOptional = repository.findById(id);
        if (quarterOptional.isEmpty()) {

            return new ResponseEntity<>(new DataDto<>(new AppErrorDto(HttpStatus.NOT_FOUND, "quarter Not  found", "quarter")), HttpStatus.OK);
        }
        QuarterDto quarterDto = mapper.toDto(quarterOptional.get());

        return new ResponseEntity<>(new DataDto<>(quarterDto), HttpStatus.OK);
    }


    public ResponseEntity<DataDto<List<QuarterDto>>> getAllCriteria(GenericCriteria criteria) {
        PageRequest pageRequest = PageRequest.of( criteria.getPage(), criteria.getSize() );
        List<Quarter> quarters = repository.findAll(pageRequest).toList();
        return new ResponseEntity<>( new DataDto<>( mapper.toDto( quarters ), (long) quarters.size() ), HttpStatus.OK );
    }


}
