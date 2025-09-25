package com.mycloud.platform.domain.service;

import com.mycloud.platform.domain.common.FileMetadata;
import com.mycloud.platform.domain.config.StorageProperties;
import com.mycloud.platform.domain.exception.InvalidPathException;
import com.mycloud.platform.domain.exception.StorageException;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

@Service
@Primary
public class FileSystemStorageProvider implements StorageProvider {
    private final Logger log = Logger.getLogger(FileSystemStorageProvider.class.getName());

    private final StorageProperties storageProperties;
    public FileSystemStorageProvider(StorageProperties storageProperties) {
        this.storageProperties = storageProperties;
    }
    public Path getUserHomeDirectory(){
        return storageProperties.getUsersPath();
    }
    @Override
    public void validatePath(String path) {
        if(path ==null || path.isEmpty()){
            throw new StorageException("Path cannot be null or empty");
        }
        Path normalizedPath = Paths.get(path).normalize();
        Path resolvedPath = storageProperties.getBasePath().resolve(normalizedPath).normalize();
        if(!resolvedPath.startsWith(storageProperties.getBasePath())){
            throw new InvalidPathException("Path attempts to access files outside storage root: " + path);
        }

        // check special characters in the paths
        String pathString = normalizedPath.toString();
        if( pathString.contains("..") || pathString.contains(".") ||
                pathString.contains("~") || pathString.matches(".*[<>:\"|?*].*")){
            throw new InvalidPathException("Path contains invalid characters: " + path);
        }

    }
    @Override
    public Path createDirectory(String directoryName){
        // get Users Home Directory
        Path userRoot = getUserHomeDirectory();
        Path newDir = userRoot.resolve(directoryName);
        try {
            Files.createDirectories(newDir);
            log.info("Directory created: {}" + newDir);
            return newDir;
        }catch (IOException e){
            throw  new RuntimeException( "Failed to create directory" + newDir ,e);
        }
    }

    @Override
    public void deleteDirectory(String targetPath, boolean recursive) {
        Path userRoot = getUserHomeDirectory();
        Path targetDir = userRoot.resolve(targetPath);
        if (Files.exists(targetDir)) {
            try {
                Files.walk(targetDir)
                        .sorted(Comparator.reverseOrder())
                        .forEach(path -> {
                            try {
                                Files.delete(path);
                            } catch (IOException e) {
                                throw new RuntimeException("Failed to delete file" + path, e);
                            }
                        });
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void copyDirectory(String sourcePath, String targetPath) {

    }

    @Override
    public void moveDirectory(String sourcePath, String targetPath) {

    }

    @Override
    public void saveFile(String path, InputStream content, long size) {

    }

    @Override
    public InputStream readFile(String path) {
        return null;
    }

    @Override
    public void deleteFile(String path) {

    }

    @Override
    public void copyFile(String sourcePath, String targetPath) {

    }

    @Override
    public void moveFile(String sourcePath, String targetPath) {

    }

    @Override
    public boolean exists(String path) {
        return false;
    }

    @Override
    public boolean isDirectory(String path) {
        return false;
    }

    @Override
    public boolean isFile(String path) {
        return false;
    }

    @Override
    public long getFileSize(String path) {
        return 0;
    }

    @Override
    public List<FileMetadata> listDirectory(String path) {
        return List.of();
    }

    @Override
    public long getDirectorySize(String path, boolean recursive) {
        return 0;
    }


    @Override
    public String getAbsolutePath(String relativePath) {
        validatePath(relativePath);
        return storageProperties.getUsersPath().resolve(relativePath).normalize().toString();
    }
}
