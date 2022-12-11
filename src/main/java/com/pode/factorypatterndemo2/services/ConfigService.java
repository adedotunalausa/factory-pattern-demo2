package com.pode.factorypatterndemo2.services;

import com.pode.factorypatterndemo2.dto.BaseResponse;
import com.pode.factorypatterndemo2.dto.ConfigDto;

public interface ConfigService {
    BaseResponse<ConfigDto> addConfig(ConfigDto configDto);
}
