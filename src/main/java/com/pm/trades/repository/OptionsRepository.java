package com.pm.trades.repository;

import com.pm.trades.entity.OptionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionsRepository extends JpaRepository<OptionsEntity, Integer> {
}
