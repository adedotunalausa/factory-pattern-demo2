package com.pode.factorypatterndemo2.enums;

import com.pode.factorypatterndemo2.exceptions.ValidationException;
import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public enum ConfigEnum {
    CURRENT_PROVIDER("CP");

    private final String name;

    private static final Map<String, ConfigEnum> configMap = new HashMap<>();

    static {
        for (ConfigEnum configEnum : ConfigEnum.values()) {
            configMap.put(configEnum.name, configEnum);
        }
    }

    public static void validateConfig(String name) {
        Arrays.stream(values()).parallel().filter(value -> value.name.equals(name))
                .findFirst().orElseThrow(() -> new ValidationException("Invalid config"));
    }

}
