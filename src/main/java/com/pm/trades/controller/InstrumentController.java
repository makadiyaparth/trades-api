package com.pm.trades.controller;

import com.pm.trades.dto.InstrumentDTO;
import com.pm.trades.dto.InstrumentInDTO;
import com.pm.trades.service.InstrumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/instruments")
public class InstrumentController {
    @Autowired
    private InstrumentService instrumentService;

    @PostMapping
    public InstrumentDTO save(@RequestBody @Valid InstrumentInDTO instrumentInDTO) {
        return instrumentService.save(instrumentInDTO);
    }

    @GetMapping
    public List<InstrumentDTO> findAll(@RequestParam(required = false) String name) {
        return instrumentService.findAll(name);
    }

    @PutMapping
    public InstrumentDTO update(@RequestBody InstrumentDTO instrumentDTO) {
        return instrumentService.update(instrumentDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        instrumentService.delete(id);
    }
}
