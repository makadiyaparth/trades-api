package com.pm.trades.mapper;

import com.pm.trades.dto.stock.StockDTO;
import com.pm.trades.dto.stock.StockInDTO;
import com.pm.trades.dto.stock.StockUpdateDTO;
import com.pm.trades.entity.StockEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = InstrumentMapper.class)
public interface StockMapper {
    @Mapping(target = "instrumentDTO", source = "instrumentEntity")
    StockDTO toDTO(StockEntity stockEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "instrumentEntity", ignore = true)
    StockEntity toEntity(StockInDTO stockInDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "instrumentEntity", ignore = true)
    void updateEntity(@MappingTarget StockEntity stockEntity, StockUpdateDTO stockUpdateDTO);
}
