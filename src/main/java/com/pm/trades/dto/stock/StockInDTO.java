package com.pm.trades.dto.stock;

import com.pm.trades.enums.TransactionType;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class StockInDTO {
    @NotBlank
    private String instrumentName;

    @NotNull
    private BigDecimal price;

    @NotNull
    private Integer quantity;

    @NotNull
    private TransactionType transactionType;

    @NotNull
    private LocalDate transactionDate;

    private String note;
}
