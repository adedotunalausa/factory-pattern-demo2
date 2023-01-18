package com.pode.factorypatterndemo2.services.implementation;

import com.pode.factorypatterndemo2.dto.BaseResponse;
import com.pode.factorypatterndemo2.dto.CheckoutDto;
import com.pode.factorypatterndemo2.dto.PaymentDto;
import com.pode.factorypatterndemo2.enums.ConfigEnum;
import com.pode.factorypatterndemo2.model.Config;
import com.pode.factorypatterndemo2.providers.PaymentProviderFactoryService;
import com.pode.factorypatterndemo2.providers.PaymentProviderService;
import com.pode.factorypatterndemo2.services.CheckoutService;
import com.pode.factorypatterndemo2.services.ConfigService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CheckoutServiceImpl implements CheckoutService {

    private final PaymentProviderFactoryService paymentProviderFactoryService;
    private final ConfigService configService;

    @Override
    public BaseResponse<CheckoutDto> performCheckout(CheckoutDto checkoutDto) {
        try {
            // TODO:  Save the order in the database
            String paymentResponse = processCheckoutPayment(checkoutDto);
            checkoutDto.setPaymentResponse(paymentResponse);
            return new BaseResponse<>(true, HttpStatus.OK, "Checkout processed successfully", checkoutDto);
        } catch (Exception e) {
            log.error("There was an error while processing checkout::: {}", e.getMessage());
            return new BaseResponse<>(false, HttpStatus.BAD_REQUEST, "Service unavailable, please try again later!", null);
        }
    }

    private String processCheckoutPayment(CheckoutDto checkoutDto) {
        Config currentProviderConfig = configService.getConfigByKey(ConfigEnum.CURRENT_PROVIDER.getConfigName());
        String currentProvider = currentProviderConfig.getConfigValue();
        PaymentProviderService paymentProviderService = paymentProviderFactoryService.getPaymentProvider(currentProvider);
        PaymentDto paymentDto = new PaymentDto(checkoutDto.getAmount());
        return paymentProviderService.initiateTransfer(paymentDto);
    }

}
