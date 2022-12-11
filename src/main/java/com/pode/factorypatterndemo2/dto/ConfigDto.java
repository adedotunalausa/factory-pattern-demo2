package com.pode.factorypatterndemo2.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ConfigDto {

    @NotNull
    private String configKey;

    @NotNull
    private String configValue;

}
