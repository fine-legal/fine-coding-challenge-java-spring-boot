package so.fine.codingchallenge.endpoints.dto;

import org.modelmapper.ModelMapper;

public class EntityToDTOConverter<E, D> {
    private final ModelMapper modelMapper;

    public EntityToDTOConverter() {
        this.modelMapper = new ModelMapper();
    }

    public D convertToDto(E entity, Class<D> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }

    public E convertToEntity(D dto, Class<E> entityClass) {
        return modelMapper.map(dto, entityClass);
    }
}