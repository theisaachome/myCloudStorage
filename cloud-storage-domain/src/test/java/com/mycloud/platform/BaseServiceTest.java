package com.mycloud.platform;

import com.mycloud.platform.config.StorageProperties;
import com.mycloud.platform.service.FileSystemStorageProvider;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Properties;

public class BaseServiceTest {

        protected StorageProperties storageProperties;
        protected FileSystemStorageProvider fileSystemStorageProvider;

        @BeforeEach
        protected void setup() throws IOException {
            Properties props = new Properties();
            try (InputStream in = getClass().getClassLoader().getResourceAsStream("config.properties")) {
                props.load(in);
            }

            storageProperties = new StorageProperties();
            storageProperties.setBaseDirectory(props.getProperty("storage.base-directory"));
            storageProperties.setBaseDirectory("storage");
            storageProperties.setUsers(props.getProperty("storage.users"));
            storageProperties.setShared(props.getProperty("storage.shared"));
            storageProperties.setTmp(props.getProperty("storage.tmp"));
            storageProperties.setArchive(props.getProperty("storage.archive"));

            fileSystemStorageProvider = new FileSystemStorageProvider(storageProperties);

            // ensure base directories exist for tests
            Path basePath = storageProperties.getBasePath();
            java.nio.file.Files.createDirectories(basePath);
        }

}
