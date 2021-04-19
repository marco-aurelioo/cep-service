package com.service.cep.service;

import com.service.cep.dto.CepDto;
import com.service.cep.entity.CepEntity;
import com.service.cep.repository.CepRepository;
import javassist.NotFoundException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CepServiceTest {

    @InjectMocks
    private CepService service;

    @Mock
    private CepRepository repository;

    @Test
    public void validaCepNotFound() throws NotFoundException {
        Mockito.when(repository.findByCep(Mockito.anyString())).thenReturn(Optional.empty());
        assertThrows(
                NotFoundException.class,() -> {
            service.findCep("99999999");
        });
    }

    @Test
    public void validaCepFound() throws NotFoundException {
        CepEntity entity = new CepEntity();
        entity.setCep("99999990");
        entity.setBairro("bairro");
        entity.setCidade("cidade");
        entity.setEstado("estado");
        entity.setRua("rua");

        Mockito.when(repository.findByCep("99999999")).thenReturn(
                Optional.empty());
        Mockito.when(repository.findByCep("99999990")).thenReturn(
                Optional.of(entity));

        CepDto cep = service.findCep("99999999");
        assertEquals("rua",cep.getRua());
        assertEquals("99999990",cep.getCep());
        assertEquals("bairro",cep.getBairro());
        assertEquals("cidade",cep.getCidade());
        assertEquals("estado",cep.getEstado());

    }

}