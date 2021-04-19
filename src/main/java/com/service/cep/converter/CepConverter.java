package com.service.cep.converter;

import com.service.cep.dto.CepDto;
import com.service.cep.entity.CepEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CepConverter {

    public CepEntity fromDto(CepDto dto){
        CepEntity entity = new CepEntity();
        BeanUtils.copyProperties( dto,entity);
        return entity;
    }

    public CepDto fromEntity(CepEntity entity) {
        CepDto dto = new CepDto();
        BeanUtils.copyProperties(entity,dto);
        return dto;
    }

}
