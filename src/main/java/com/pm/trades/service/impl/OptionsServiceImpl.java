package com.pm.trades.service.impl;

import com.pm.trades.dto.options.OptionsDTO;
import com.pm.trades.dto.options.OptionsInDTO;
import com.pm.trades.entity.OptionsEntity;
import com.pm.trades.exception.NotFoundException;
import com.pm.trades.mapper.OptionsMapper;
import com.pm.trades.repository.InstrumentRepository;
import com.pm.trades.repository.OptionsRepository;
import com.pm.trades.service.OptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OptionsServiceImpl implements OptionsService
{
    @Autowired
    private OptionsRepository optionsRepository;

    @Autowired
    private OptionsMapper optionsMapper;

    @Autowired
    private InstrumentRepository instrumentRepository;

    @Override
    public OptionsDTO save(OptionsInDTO optionsInDTO) {
        var optionsEntity = optionsMapper.toEntity(optionsInDTO);
        setInstrumentEntity(optionsEntity, optionsInDTO.getInstrumentName());
        optionsEntity = optionsRepository.save(optionsEntity);
        return optionsMapper.toDTO(optionsEntity);
    }

    @Override
    public List<OptionsDTO> findAll(LocalDate date) {
        List<OptionsEntity> optionsEntities = optionsRepository.findByCreatedDateTimeBetween(date.atStartOfDay(), date.plusDays(1).atStartOfDay());
        return optionsEntities.stream().map(optionsMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public OptionsDTO update(Integer id, OptionsInDTO optionsInDTO) {
        var optionsEntity = findById(id);
        optionsMapper.updateEntity(optionsEntity, optionsInDTO);
        setInstrumentEntity(optionsEntity, optionsInDTO.getInstrumentName());
        optionsEntity = optionsRepository.save(optionsEntity);
        return optionsMapper.toDTO(optionsEntity);
    }

    @Override
    public void delete(Integer id) {
        var optionsEntity = findById(id);
        optionsRepository.delete(optionsEntity);
    }

    private void setInstrumentEntity(OptionsEntity optionsEntity, String name) {
        var instrumentEntity = instrumentRepository.findByName(name).orElseThrow(() -> new NotFoundException("Instrument not found with name " + name));
        optionsEntity.setInstrumentEntity(instrumentEntity);
    }

    private OptionsEntity findById(Integer id) {
        return optionsRepository.findById(id).orElseThrow(() -> new NotFoundException("Options not found with id " + id));
    }
}
