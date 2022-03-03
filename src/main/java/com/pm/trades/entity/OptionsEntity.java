package com.pm.trades.entity;

import com.pm.trades.enums.OptionsType;
import com.pm.trades.enums.TransactionType;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "options")
public class OptionsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "instrument_id")
    private InstrumentEntity instrumentEntity;

    @NotNull
    private LocalDate expiryDate;

    @NotNull
    private Integer strikePrice;

    @NotNull
    private Integer lots;

    @NotNull
    private BigDecimal price;

    @Size(max = 1024)
    private String note;

    @Enumerated(EnumType.STRING)
    private OptionsType optionsType;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
}

