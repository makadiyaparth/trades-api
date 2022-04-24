package com.pm.trades.service.impl;

import com.pm.trades.dto.instrument.InstrumentDTO;
import com.pm.trades.dto.instrument.InstrumentInDTO;
import com.pm.trades.entity.InstrumentEntity;
import com.pm.trades.exception.NotFoundException;
import com.pm.trades.mapper.InstrumentMapper;
import com.pm.trades.repository.InstrumentRepository;
import com.pm.trades.service.InstrumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InstrumentServiceImpl implements InstrumentService
{
    @Autowired
    private InstrumentRepository instrumentRepository;

    @Autowired
    private InstrumentMapper instrumentMapper;

    @Override
    public InstrumentDTO save(InstrumentInDTO instrumentInDTO) {
        var instrumentEntity = instrumentMapper.toEntity(instrumentInDTO);
        instrumentEntity = instrumentRepository.save(instrumentEntity);
        return instrumentMapper.toDTO(instrumentEntity);
    }

    @Override
    public List<InstrumentDTO> findAll(String name) {
        List<InstrumentEntity> instrumentEntities;

        if (name != null && !name.trim().equals("")) {
            instrumentEntities = instrumentRepository.findByNameStartingWith(name);
        } else {
            instrumentEntities = instrumentRepository.findAll();
        }

        return instrumentEntities.stream().map(instrumentMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public InstrumentDTO update(InstrumentDTO instrumentDTO) {
        var instrumentEntity = findById(instrumentDTO.getId());
        instrumentMapper.updateEntity(instrumentEntity, instrumentDTO);
        instrumentEntity = instrumentRepository.save(instrumentEntity);
        return instrumentMapper.toDTO(instrumentEntity);
    }

    @Override
    public void delete(Integer id) {
        var instrumentEntity = findById(id);
        instrumentRepository.delete(instrumentEntity);
    }

    private InstrumentEntity findById(Integer id) {
        return instrumentRepository.findById(id).orElseThrow(() -> new NotFoundException("Instrument not found with id " + id));
    }
}
