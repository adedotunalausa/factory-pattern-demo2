package com.pode.factorypatterndemo2.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentProviders {
    PAYSTACK("paystack"),
    STRIPE("stripe");

    private String providerAlias;
}
