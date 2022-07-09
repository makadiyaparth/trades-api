package com.pm.trades.repository;

import com.pm.trades.entity.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<StockEntity, Integer> {
    List<StockEntity> findByInstrumentEntityNameContainingIgnoreCaseOrderByTransactionDateDesc(String name);

    List<StockEntity> findByOrderByTransactionDateDesc();
}
