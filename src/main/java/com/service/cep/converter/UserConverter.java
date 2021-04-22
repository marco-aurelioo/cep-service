package com.service.cep.converter;

import com.service.cep.dto.UserDto;
import com.service.cep.entity.UserEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserEntity fromDto(UserDto dto){
        UserEntity entity = new UserEntity();
        BeanUtils.copyProperties( dto,entity);
        return entity;
    }

    public UserDto fromEntity(UserEntity entity) {
        UserDto dto = new UserDto();
        BeanUtils.copyProperties(entity,dto);
        return dto;
    }

}
