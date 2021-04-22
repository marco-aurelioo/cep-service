package com.service.cep.controller;

import com.service.cep.conf.ApplicationSecurityConfiguration;
import com.service.cep.converter.CepConverter;
import com.service.cep.repository.CepRepository;
import com.service.cep.service.CepService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
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

    @Test
    public void invalidRequest() throws Exception {
        String uri = "/cep/123456789";
        mockMvc.perform(MockMvcRequestBuilders.get(uri))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void validRequestNotFound() throws Exception {
        String uri = "/cep/12345678";
        mockMvc.perform(MockMvcRequestBuilders.get(uri))
                .andExpect(status().isNotFound());
    }

}