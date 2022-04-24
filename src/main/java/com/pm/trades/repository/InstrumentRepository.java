package com.pm.trades.repository;

import com.pm.trades.entity.InstrumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InstrumentRepository extends JpaRepository<InstrumentEntity, Integer> {
    List<InstrumentEntity> findByNameStartingWith(String name);

    Optional<InstrumentEntity> findByName(String name);
}
