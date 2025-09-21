package com.mycloud.platform;
import com.mycloud.platform.config.StorageInitializer;
import com.mycloud.platform.config.StorageProperties;
import com.mycloud.platform.service.StorageService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class App 
{
    public static void main( String[] args ) throws IOException {
        Properties props = new Properties();
        try (InputStream inputStream = App.class.getClassLoader().getResourceAsStream("config.properties")) {
            if(inputStream != null) {
                props.load(inputStream);
            }else {
                throw new FileNotFoundException("property file 'config.properties' not found in the classpath");
            }
        }

        StorageProperties storageProperties = new StorageProperties();
        storageProperties.setBaseDirectory(props.getProperty("storage.base-directory"));
        storageProperties.setUsers(props.getProperty("storage.users"));
        storageProperties.setShared(props.getProperty("storage.shared"));
        storageProperties.setTmp(props.getProperty("storage.tmp"));
        storageProperties.setArchive(props.getProperty("storage.archive"));


        var Sproperties = new StorageProperties();
        var storageService = new StorageService(Sproperties);
        var storageInit = new StorageInitializer(Sproperties);
        storageInit.init();

        storageService.createDirectory("john","movies");
        System.out.println( "Hello World!" );
    }
}
