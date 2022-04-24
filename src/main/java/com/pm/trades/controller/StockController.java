package com.pm.trades.controller;

import com.pm.trades.dto.stock.StockDTO;
import com.pm.trades.dto.stock.StockInDTO;
import com.pm.trades.dto.stock.StockUpdateDTO;
import com.pm.trades.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/stocks")
public class StockController {
    @Autowired
    private StockService stockService;

    @PostMapping
    public StockDTO save(@RequestBody @Valid StockInDTO stockInDTO) {
        return stockService.save(stockInDTO);
    }

    @GetMapping
    public List<StockDTO> findAll(@RequestParam(required = false) String name) {
        return stockService.findAll(name);
    }

    @PutMapping
    public StockDTO update(@RequestBody @Valid StockUpdateDTO stockUpdateDTO) {
        return stockService.update(stockUpdateDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        stockService.delete(id);
    }
}
