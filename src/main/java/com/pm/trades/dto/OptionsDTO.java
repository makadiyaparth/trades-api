package com.pm.trades.dto;

import com.pm.trades.enums.OptionsType;
import com.pm.trades.enums.TransactionType;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class OptionsDTO {
    private Integer id;
    private InstrumentDTO instrumentDTO;
    private LocalDate expiryDate;
    private Integer strikePrice;
    private Integer lots;
    private BigDecimal price;
    private OptionsType optionsType;
    private TransactionType transactionType;
    private String note;
}
