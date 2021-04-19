package com.service.cep.controller;

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

    @GetMapping("/cep/{cep}")
    public ResponseEntity<String> findCep(@Valid @PathVariable("cep") @Pattern( regexp = "^\\d{8}$") String cep){
        return ResponseEntity.ok(cep);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
        return new ResponseEntity<>("invalid request: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
