package com.pm.trades.service;

import com.pm.trades.dto.InstrumentDTO;
import com.pm.trades.dto.InstrumentInDTO;

import java.util.List;

public interface InstrumentService {
    InstrumentDTO save(InstrumentInDTO instrumentInDTO);

    List<InstrumentDTO> findAll(String name);

    InstrumentDTO update(InstrumentDTO instrumentDTO);

    void delete(Integer id);
}
