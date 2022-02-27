package com.pm.trades.mapper;

import com.pm.trades.dto.InstrumentDTO;
import com.pm.trades.dto.InstrumentInDTO;
import com.pm.trades.entity.InstrumentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface InstrumentMapper {
    InstrumentDTO toDTO(InstrumentEntity instrumentEntity);

    @Mapping(target = "id", ignore = true)
    InstrumentEntity toEntity(InstrumentInDTO instrumentInDTO);

    void updateEntity(@MappingTarget InstrumentEntity instrumentEntity, InstrumentDTO instrumentDTO);
}
