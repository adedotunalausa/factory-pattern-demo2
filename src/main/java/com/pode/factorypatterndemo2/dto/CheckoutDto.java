package com.pode.factorypatterndemo2.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CheckoutDto {

    @NotNull
    private String productId;

    @NotNull
    private Double amount;

    private String paymentResponse;

}
