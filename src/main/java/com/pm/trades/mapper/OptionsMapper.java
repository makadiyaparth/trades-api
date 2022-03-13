package com.pm.trades.mapper;

import com.pm.trades.dto.options.OptionsDTO;
import com.pm.trades.dto.options.OptionsInDTO;
import com.pm.trades.entity.OptionsEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = InstrumentMapper.class)
public interface OptionsMapper {
    @Mapping(target = "instrumentDTO", source = "instrumentEntity")
    OptionsDTO toDTO(OptionsEntity optionsEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "instrumentEntity", ignore = true)
    OptionsEntity toEntity(OptionsInDTO optionsInDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "instrumentEntity", ignore = true)
    void updateEntity(@MappingTarget OptionsEntity optionsEntity, OptionsInDTO optionsInDTO);
}
