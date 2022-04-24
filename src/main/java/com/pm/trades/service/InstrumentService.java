package com.pm.trades.service;

import com.pm.trades.dto.instrument.InstrumentDTO;
import com.pm.trades.dto.instrument.InstrumentInDTO;

import java.util.List;

public interface InstrumentService {
    InstrumentDTO save(InstrumentInDTO instrumentInDTO);

    List<InstrumentDTO> findAll(String name);

    InstrumentDTO update(InstrumentDTO instrumentDTO);

    void delete(Integer id);
}
