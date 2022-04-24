package com.pm.trades.service;

import com.pm.trades.dto.stock.StockDTO;
import com.pm.trades.dto.stock.StockInDTO;
import com.pm.trades.dto.stock.StockUpdateDTO;

import java.util.List;

public interface StockService {
    StockDTO save(StockInDTO stockInDTO);

    List<StockDTO> findAll(String name);

    StockDTO update(StockUpdateDTO stockUpdateDTO);

    void delete(Integer id);
}
