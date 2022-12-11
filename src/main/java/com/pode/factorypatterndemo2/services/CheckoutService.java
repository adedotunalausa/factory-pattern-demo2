package com.pode.factorypatterndemo2.services;

import com.pode.factorypatterndemo2.dto.BaseResponse;
import com.pode.factorypatterndemo2.dto.CheckoutDto;

public interface CheckoutService {
    BaseResponse<CheckoutDto> performCheckout(CheckoutDto checkoutDto);
}
