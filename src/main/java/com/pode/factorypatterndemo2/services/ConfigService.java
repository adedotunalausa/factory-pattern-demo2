package com.pode.factorypatterndemo2.services;

import com.pode.factorypatterndemo2.dto.BaseResponse;
import com.pode.factorypatterndemo2.dto.ConfigDto;
import com.pode.factorypatterndemo2.model.Config;

public interface ConfigService {
    BaseResponse<ConfigDto> addConfig(ConfigDto configDto);
    Config getConfigByKey(String configKey);
}
