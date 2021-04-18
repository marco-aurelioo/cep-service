package com.service.cep.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class CepController {

    @GetMapping("/cep/{cep}")
    public ResponseEntity<String> findCep(@PathParam("cep")String cep){
        return ResponseEntity.ok(cep);
    }
}
