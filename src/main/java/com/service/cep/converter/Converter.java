package com.service.cep.converter;

import java.util.function.Function;

public class Converter<T,D> {
    private final Function<T,D> fromEntity;
    private final Function<D,T> fromDto;


    public Converter(final Function<D, T> fromDto, final Function<T, D> fromEntity) {
        this.fromDto = fromDto;
        this.fromEntity = fromEntity;
    }

    public final T convertFromDto(final D dto) {
        return fromDto.apply(dto);
    }

    public final D convertFromEntity(final T entity) {
        return fromEntity.apply(entity);
    }

}
