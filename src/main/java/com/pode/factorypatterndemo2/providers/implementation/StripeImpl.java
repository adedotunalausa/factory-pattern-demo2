package com.pode.factorypatterndemo2.providers.implementation;

import com.pode.factorypatterndemo2.dto.PaymentDto;
import com.pode.factorypatterndemo2.providers.PaymentProviderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StripeImpl implements PaymentProviderService {

    @Override
    public String makePayment(PaymentDto paymentDto) {
        log.debug("Payment processed with Stripe");
        return paymentDto.getAmount() + " has been processed using Stripe";
    }

}
