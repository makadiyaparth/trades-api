package com.pm.trades.dto.stock;

import com.pm.trades.dto.instrument.InstrumentDTO;
import com.pm.trades.enums.TransactionType;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class StockDTO {
    private Integer id;
    private InstrumentDTO instrumentDTO;
    private BigDecimal price;
    private Integer quantity;
    private LocalDate transactionDate;
    private String note;
    private TransactionType transactionType;
}
