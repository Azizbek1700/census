package uz.bakhodirov.census.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.bakhodirov.census.controller.base.AbstractController;
import uz.bakhodirov.census.criteria.GenericCriteria;
import uz.bakhodirov.census.dto.quarter.QuarterCreateDto;
import uz.bakhodirov.census.dto.quarter.QuarterDto;
import uz.bakhodirov.census.dto.quarter.QuarterUpdateDto;
import uz.bakhodirov.census.dto.responce.DataDto;
import uz.bakhodirov.census.services.quarter.QuarterServices;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class QuarterController extends AbstractController {

    private final QuarterServices quarterServices;

    @PostMapping(PATH + "/quarter/create")
    public ResponseEntity<DataDto<Long>> create(@RequestBody QuarterCreateDto dto) {
        return quarterServices.create(dto);
    }

    @PatchMapping(PATH+"/quarter/update")
    public  ResponseEntity<DataDto<Long>>update(@RequestBody QuarterUpdateDto dto){
        return quarterServices.update(dto);
    }

    @GetMapping(PATH + "/quarter/list")
    public ResponseEntity<DataDto<List<QuarterDto>>> getAll() {
        return quarterServices.getAll();
    }

    @GetMapping(PATH + "/quarter/get/{id}")
    public ResponseEntity<DataDto<QuarterDto>> get(@PathVariable Long id) {
        return quarterServices.get(id);
    }

    @DeleteMapping(PATH+ "/quarter/delete/{id}")
    public ResponseEntity<DataDto<Void>> delete(@PathVariable Long id) {
        return quarterServices.delete(id);
    }

    @GetMapping(PATH+"/quarter/listCriteria")
    public ResponseEntity<DataDto<List<QuarterDto>>> getAllCriteria(GenericCriteria criteria) {
        return quarterServices.getAllCriteria( criteria );
    }

}
