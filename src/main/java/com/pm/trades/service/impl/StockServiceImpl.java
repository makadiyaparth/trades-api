package com.pm.trades.service.impl;

import com.pm.trades.dto.stock.StockDTO;
import com.pm.trades.dto.stock.StockInDTO;
import com.pm.trades.dto.stock.StockUpdateDTO;
import com.pm.trades.entity.InstrumentEntity;
import com.pm.trades.entity.StockEntity;
import com.pm.trades.exception.NotFoundException;
import com.pm.trades.mapper.StockMapper;
import com.pm.trades.repository.InstrumentRepository;
import com.pm.trades.repository.StockRepository;
import com.pm.trades.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockServiceImpl implements StockService
{
    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private StockMapper stockMapper;

    @Autowired
    private InstrumentRepository instrumentRepository;

    @Override
    public StockDTO save(StockInDTO stockInDTO) {
        var stockEntity = createStockEntity(stockInDTO);
        stockEntity = stockRepository.save(stockEntity);
        return stockMapper.toDTO(stockEntity);
    }

    @Override
    public List<StockDTO> findAll(String name) {
        List<StockEntity> stockEntities;

        if (name != null && !name.trim().equals("")) {
            stockEntities = stockRepository.findByInstrumentEntityNameContainingIgnoreCaseOrderByTransactionDateDesc(name);
        } else {
            stockEntities = stockRepository.findByOrderByTransactionDateDesc();
        }

        return stockEntities.stream().map(stockMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public StockDTO update(StockUpdateDTO stockUpdateDTO) {
        var stockEntity = findById(stockUpdateDTO.getId());
        updateStockEntity(stockEntity, stockUpdateDTO);
        stockEntity = stockRepository.save(stockEntity);
        return stockMapper.toDTO(stockEntity);
    }

    @Override
    public void delete(Integer id) {
        var stockEntity = findById(id);
        stockRepository.delete(stockEntity);
    }

    private StockEntity createStockEntity(StockInDTO stockInDTO) {
        var stockEntity = stockMapper.toEntity(stockInDTO);
        stockEntity.setInstrumentEntity(getInstrumentEntity(stockInDTO.getInstrumentName()));
        return stockEntity;
    }

    private void updateStockEntity(StockEntity stockEntity, StockUpdateDTO stockUpdateDTO) {
        stockMapper.updateEntity(stockEntity, stockUpdateDTO);
        stockEntity.setInstrumentEntity(getInstrumentEntity(stockUpdateDTO.getInstrumentName()));
    }

    private InstrumentEntity getInstrumentEntity(String name) {
        return instrumentRepository.findByName(name).orElseThrow(() -> new NotFoundException("Instrument not found with name " + name));
    }

    private StockEntity findById(Integer id) {
        return stockRepository.findById(id).orElseThrow(() -> new NotFoundException("Stock not found with id " + id));
    }
}
