package com.grupo7.proyectoda.rest;

import com.grupo7.proyectoda.converter.TareaConverter;
import com.grupo7.proyectoda.dto.TareaDto;
import com.grupo7.proyectoda.entity.Tarea;
import com.grupo7.proyectoda.service.TareaService;
import com.grupo7.proyectoda.util.WrapperResponse;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:9000")
@RestController
@RequestMapping("/api/v1/tareas")
public class TareaController {
    @Autowired
    private TareaService service;

    @Autowired
    private TareaConverter converter;

    @GetMapping
    public ResponseEntity<List<TareaDto>> findAll(
            @RequestParam(value = "offset", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(value = "limit", required = false, defaultValue = "5") int pageSize
    ) {
        List<TareaDto> registros = converter.fromEntities(service.findAll());
        return new WrapperResponse(true, "success", registros).createResponse(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TareaDto> findById (@PathVariable("id") int id) {
        TareaDto dto = converter.fromEntity(service.findById(id));

        return new WrapperResponse(true, "success", dto).createResponse(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TareaDto> create(@RequestBody TareaDto registro) {
        Tarea entity = converter.fromDto(registro);
        TareaDto dto = converter.fromEntity(service.save(entity));
        return new WrapperResponse(true, "success", dto).createResponse(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TareaDto> update(@PathVariable("id") int id, @RequestBody TareaDto registro) {
        Tarea entity = converter.fromDto(registro);
        TareaDto dto = converter.fromEntity(service.save(entity));
        return new WrapperResponse(true, "success", dto).createResponse(HttpStatus.OK);
    }
}
