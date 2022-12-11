package com.pode.factorypatterndemo2.controller;

import com.pode.factorypatterndemo2.dto.BaseResponse;
import com.pode.factorypatterndemo2.dto.CheckoutDto;
import com.pode.factorypatterndemo2.services.CheckoutService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/checkout")
@RequiredArgsConstructor
public class CheckoutController extends BaseController {

    private final CheckoutService checkoutService;

    @PostMapping
    public BaseResponse<CheckoutDto> performCheckout(@Valid @RequestBody CheckoutDto checkoutDto) {
        return responseWithUpdatedHttpStatus(checkoutService.performCheckout(checkoutDto));
    }

}
