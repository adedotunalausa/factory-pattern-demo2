package com.pode.factorypatterndemo2.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NameEnquiryDto {

    @NotNull
    private String accountNumber;

    private String accountName;

    @NotNull
    private String bankCode;

}
