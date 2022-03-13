package com.pm.trades.dto.instrument;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class InstrumentInDTO {
    @NotBlank
    private String name;
    private String description;
}
