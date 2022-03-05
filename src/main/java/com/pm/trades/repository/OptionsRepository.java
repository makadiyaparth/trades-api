package com.pm.trades.repository;

import com.pm.trades.entity.OptionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OptionsRepository extends JpaRepository<OptionsEntity, Integer> {
    List<OptionsEntity> findByCreatedDateTimeBetween(LocalDateTime startDateTime, LocalDateTime endDateTime);
}
