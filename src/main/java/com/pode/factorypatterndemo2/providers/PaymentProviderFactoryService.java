package com.pode.factorypatterndemo2.providers;

import com.pode.factorypatterndemo2.enums.PaymentProviders;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentProviderFactoryService {

    private final Map<String, PaymentProviderService> paymentProviderServiceMap = new HashMap<>();

    public PaymentProviderFactoryService(
            @Qualifier("paystackImpl") PaymentProviderService paystackImpl,
            @Qualifier("stripeImpl") PaymentProviderService stripeImpl
    ) {
        addPaymentProvider(PaymentProviders.PAYSTACK.getProviderAlias(), paystackImpl);
        addPaymentProvider(PaymentProviders.STRIPE.getProviderAlias(), stripeImpl);
    }

    public PaymentProviderService getPaymentProvider(String providerName) {
        return paymentProviderServiceMap.get(providerName);
    }

    private void addPaymentProvider(String providerName, PaymentProviderService providerService) {
        paymentProviderServiceMap.put(providerName, providerService);
    }

}
