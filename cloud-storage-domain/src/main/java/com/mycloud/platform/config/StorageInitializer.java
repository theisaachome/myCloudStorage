package com.mycloud.platform.config;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.nio.file.Files;

@Component
public class StorageInitializer {

    private final StorageProperties storageProperties;
    public StorageInitializer(StorageProperties storageProperties) {
        this.storageProperties = storageProperties;
    }
    @PostConstruct
    public void init() throws IOException {
        // create base directory
        Files.createDirectories(storageProperties.getUsersPath());
        Files.createDirectories(storageProperties.getSharedPath());
        Files.createDirectories(storageProperties.getTmpPath());
        Files.createDirectories(storageProperties.getArchivePath());
    }
}
