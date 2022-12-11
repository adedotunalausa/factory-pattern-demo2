package com.pode.factorypatterndemo2.controller;

import com.pode.factorypatterndemo2.dto.BaseResponse;
import com.pode.factorypatterndemo2.dto.ConfigDto;
import com.pode.factorypatterndemo2.services.ConfigService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/config")
public class ConfigController extends BaseController {

    private final ConfigService configService;

    @PostMapping
    public BaseResponse<ConfigDto> addConfig(@Valid @RequestBody ConfigDto configDto) {
        return responseWithUpdatedHttpStatus(configService.addConfig(configDto));
    }

}
