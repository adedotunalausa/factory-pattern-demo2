package com.pode.factorypatterndemo2.providers;

import com.pode.factorypatterndemo2.dto.NameEnquiryDto;
import com.pode.factorypatterndemo2.dto.PaymentDto;

public interface PaymentProviderService {
    NameEnquiryDto verifyAccountNumber(NameEnquiryDto dto);
    String initiateTransfer(PaymentDto paymentDto);

}
