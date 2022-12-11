package com.pode.factorypatterndemo2.providers;

import com.pode.factorypatterndemo2.dto.PaymentDto;

public interface PaymentProviderService {
    String makePayment(PaymentDto paymentDto);
}
