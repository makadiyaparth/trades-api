package com.pm.trades.repository;

import com.pm.trades.entity.InstrumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstrumentRepository extends JpaRepository<InstrumentEntity, Integer> {
    List<InstrumentEntity> findByNameStartingWith(String name);
}
