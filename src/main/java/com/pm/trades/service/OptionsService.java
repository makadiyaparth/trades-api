package com.pm.trades.service;

import com.pm.trades.dto.OptionsDTO;
import com.pm.trades.dto.OptionsInDTO;

import java.time.LocalDate;
import java.util.List;

public interface OptionsService {
    OptionsDTO save(OptionsInDTO optionsInDTO);

    List<OptionsDTO> findAll(LocalDate date);

    OptionsDTO update(Integer id, OptionsInDTO optionsInDTO);

    void delete(Integer id);
}
