package com.pode.factorypatterndemo2.repository;

import com.pode.factorypatterndemo2.model.Config;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConfigRepository extends JpaRepository<Config, Long> {
    Optional<Config> findByConfigKey(String configKey);

}
