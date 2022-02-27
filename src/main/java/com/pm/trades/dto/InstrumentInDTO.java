package com.pm.trades.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class InstrumentInDTO {
    @NotBlank
    private String name;
    private String description;
}
