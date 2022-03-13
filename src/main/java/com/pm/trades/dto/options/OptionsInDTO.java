package com.pm.trades.dto.options;

import com.pm.trades.enums.OptionsType;
import com.pm.trades.enums.TransactionType;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class OptionsInDTO {
    @NotBlank
    private String instrumentName;
    @NotNull
    private LocalDate expiryDate;
    @NotNull
    private Integer strikePrice;
    @NotNull
    private Integer lots;
    @NotNull
    private BigDecimal price;
    @NotNull
    private OptionsType optionsType;
    @NotNull
    private TransactionType transactionType;
    private String note;
}
