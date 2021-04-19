package com.service.cep.controller;

import com.service.cep.dto.CepDto;
import com.service.cep.service.CepService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;

@RestController
@Validated
public class CepController {

    public CepController(CepService service){
        this.service = service;
    }

    private CepService service;

    @GetMapping("/cep/{cep}")
    public ResponseEntity<CepDto> findCep(@Valid @PathVariable("cep") @Pattern( regexp = "^\\d{8}$") String cep) throws Exception {
        return ResponseEntity.ok(service.findCep(cep));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
        return new ResponseEntity<>("CEP inválido.", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ResponseEntity<String> handleNotFoundException(NotFoundException e) {
        return new ResponseEntity<>("CEP não encontrado.", HttpStatus.NOT_FOUND);
    }

}
