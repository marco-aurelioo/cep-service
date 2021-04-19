package com.service.cep.controller;


import com.service.cep.service.CepService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = CepController.class)
class CepControllerTest {


    @Autowired
    private MockMvc mvc;

    @MockBean
    private CepService service;

    @Test
    public void invalidRequest() throws Exception {
        String uri = "/cep/123456789";
        mvc.perform(MockMvcRequestBuilders.get(uri))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void validRequest() throws Exception {
        String uri = "/cep/12345678";
        mvc.perform(MockMvcRequestBuilders.get(uri))
                .andExpect(status().is2xxSuccessful());
    }




}