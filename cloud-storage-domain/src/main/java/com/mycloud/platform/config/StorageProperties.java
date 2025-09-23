package com.mycloud.platform.config;

import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class StorageProperties {
    @Value("${storage.base-directory}")
    private String baseDirectory="storage";

    @Value("${storage.users}")
    private String users;

    @Value("${storage.shared}")
    private String shared;

    @Value("${storage.tmp}")
    private String tmp;

    @Value("${storage.archive}")
    private String archive;

    @Min(1)
    private long maxFileSize = 100 * 1024 * 1024; // 100MB default

    @Min(1)
    private long maxStoragePerUser = 5L * 1024 * 1024 * 1024; // 5GB default

    public Path getBasePath(){
        Path path = Paths.get(baseDirectory);
        if(!path.isAbsolute()){
            return Paths.get(System.getProperty("user.dir")).resolve(path).normalize();
        }
        return path.normalize();
    }

    public Path  getUsersPath(){
       return this.getBasePath().resolve(users);
    }
    public Path getSharedPath(){
        return this.getBasePath().resolve(shared);
    }
    public Path getTmpPath(){
        return this. getBasePath().resolve(tmp);
   }

   public Path getArchivePath(){
        return  this.getBasePath().resolve(archive);
   }

    public long getMaxFileSize() {
        return maxFileSize;
    }

    public long getMaxStoragePerUser() {
        return maxStoragePerUser;
    }

    public String getBaseDirectory() {
        return baseDirectory;
    }

    public void setBaseDirectory(String baseDirectory) {
        this.baseDirectory = baseDirectory;
    }

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    }

    public String getShared() {
        return shared;
    }

    public void setShared(String shared) {
        this.shared = shared;
    }

    public String getTmp() {
        return tmp;
    }

    public void setTmp(String tmp) {
        this.tmp = tmp;
    }

    public String getArchive() {
        return archive;
    }

    public void setArchive(String archive) {
        this.archive = archive;
    }
}
