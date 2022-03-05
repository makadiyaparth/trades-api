package com.pm.trades.controller;

import com.pm.trades.dto.OptionsDTO;
import com.pm.trades.dto.OptionsInDTO;
import com.pm.trades.service.OptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/options")
public class OptionsController {
    @Autowired
    private OptionsService optionsService;

    @PostMapping
    public OptionsDTO save(@RequestBody @Valid OptionsInDTO optionsInDTO) {
        return optionsService.save(optionsInDTO);
    }

    @GetMapping
    public List<OptionsDTO> findAll(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return optionsService.findAll(date);
    }

    @PutMapping("/{id}")
    public OptionsDTO update(@PathVariable Integer id, @RequestBody @Valid OptionsInDTO optionsInDTO) {
        return optionsService.update(id, optionsInDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        optionsService.delete(id);
    }
}
