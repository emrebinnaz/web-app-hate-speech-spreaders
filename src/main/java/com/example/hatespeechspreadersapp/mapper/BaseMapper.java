package com.example.hatespeechspreadersapp.mapper;

import org.mapstruct.MapperConfig;

import java.util.List;

@MapperConfig
public interface BaseMapper<D, E> {

    E mapToEntity(D dto);

    D mapToDto(E entity);

    List<E> mapToEntity(List<D> dtoList);

    List<D> mapToDto(List<E> entityList);
}
