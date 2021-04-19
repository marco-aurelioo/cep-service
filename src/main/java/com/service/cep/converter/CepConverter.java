package com.service.cep.converter;

import com.service.cep.dto.CepDto;
import com.service.cep.entity.CepEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CepConverter extends Converter<CepEntity, CepDto> {

    public CepConverter(Function<CepDto, CepEntity> fromDto, Function<CepEntity, CepDto> fromEntity) {
        super(CepConverter::fromDto, CepConverter::fromEntity);
    }

    public static CepEntity fromDto(CepDto dto){
        CepEntity entity = new CepEntity();
        BeanUtils.copyProperties( dto,entity);
        return entity;
    }

    public static CepDto fromEntity(CepEntity entity) {
        CepDto dto = new CepDto();
        BeanUtils.copyProperties(entity,dto);
        return dto;
    }

}
