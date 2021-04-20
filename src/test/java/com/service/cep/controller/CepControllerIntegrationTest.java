package com.service.cep.controller;

import com.service.cep.converter.CepConverter;
import com.service.cep.repository.CepRepository;
import com.service.cep.service.CepService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class CepControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CepService service;

    @Autowired
    private CepRepository repository;

    @Autowired
    private CepConverter converter;

    @Test
    public void validRequest() throws Exception {
        String uri = "/cep/88888888";
        mockMvc.perform(MockMvcRequestBuilders.get(uri))
                .andExpect(status().is2xxSuccessful());
    }

}