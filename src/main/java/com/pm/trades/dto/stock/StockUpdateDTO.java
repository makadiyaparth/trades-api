package com.pm.trades.dto.stock;

import com.pm.trades.enums.TransactionType;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class StockUpdateDTO {
    @NotNull
    private Integer id;
    @NotBlank
    private String instrumentName;
    @NotNull
    private BigDecimal price;
    @NotNull
    private Integer quantity;
    @NotNull
    private LocalDate transactionDate;
    private String note;
    @NotNull
    private TransactionType transactionType;
}
