package com.service.cep.service;

import com.service.cep.dto.CepDto;
import com.service.cep.entity.CepEntity;
import com.service.cep.repository.CepRepository;
import javassist.NotFoundException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CepService {

    public CepService(CepRepository cepRepository){
        this.repository = cepRepository;
    }

    private CepRepository repository;


    public CepDto findCep(String cep) throws NotFoundException {
        return recursiveFind(cep,0);
    }

    private CepDto recursiveFind(String cep, int zeros) throws NotFoundException {
        Optional<CepEntity> byCep = repository.findByCep(cep);
        if(byCep.isPresent()){
           return convertEntityToDto(byCep.get());
        }else{
            if(zeros == 8){
                throw new NotFoundException("cep: '"+cep+"'");
            }
            zeros++;
            String cepIni = cep.substring(0, 8 - zeros);
            String cepToFind =  StringUtils.rightPad(cepIni,8,"0");
            return recursiveFind(cepToFind,zeros);
        }
    }

    private CepDto convertEntityToDto(CepEntity cepEntity) {
        CepDto dto = new CepDto();
        BeanUtils.copyProperties(cepEntity,dto);
        return dto;
    }



}
