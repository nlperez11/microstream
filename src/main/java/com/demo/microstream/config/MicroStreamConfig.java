package com.demo.microstream.config;

import one.microstream.storage.embedded.types.EmbeddedStorage;
import one.microstream.storage.embedded.types.EmbeddedStorageManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.file.Paths;

@Configuration
public class MicroStreamConfig {

    @Bean
    public EmbeddedStorageManager init(DataRoot root) {
        return EmbeddedStorage.start(root, Paths.get("data"));
    }

    @Bean
    public DataRoot root() {
        return new DataRoot();
    }


}
