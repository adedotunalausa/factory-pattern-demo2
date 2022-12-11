package com.pode.factorypatterndemo2.services.implementation;

import com.pode.factorypatterndemo2.dto.BaseResponse;
import com.pode.factorypatterndemo2.dto.ConfigDto;
import com.pode.factorypatterndemo2.enums.ConfigEnum;
import com.pode.factorypatterndemo2.exceptions.ResourceNotFoundException;
import com.pode.factorypatterndemo2.model.Config;
import com.pode.factorypatterndemo2.repository.ConfigRepository;
import com.pode.factorypatterndemo2.services.ConfigService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ConfigServiceImpl implements ConfigService {

    private final ConfigRepository configRepository;

    @Override
    public BaseResponse<ConfigDto> addConfig(ConfigDto configDto) {
        try {
            ConfigEnum.validateConfig(configDto.getConfigKey());
            Config config = new Config();
            config.setConfigKey(configDto.getConfigKey());
            config.setConfigValue(configDto.getConfigValue());
            configRepository.save(config);
            return new BaseResponse<>(true, HttpStatus.CREATED, "Config created successfully", configDto);
        } catch (Exception e) {
            log.error("There was an error while creating config::: {}", e.getMessage());
            return new BaseResponse<>(false, HttpStatus.BAD_REQUEST, Objects.nonNull(e.getMessage())? e.getMessage()
                    : "Service unavailable at the moment, please try again later!", null);
        }
    }

    @Override
    public Config getConfigByKey(String configKey) {
        return configRepository.findByConfigKey(configKey).orElseThrow(() -> new ResourceNotFoundException("Config not found!"));
    }

}
