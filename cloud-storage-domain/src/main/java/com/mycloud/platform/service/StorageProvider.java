package com.mycloud.platform.service;
import com.mycloud.platform.common.FileMetadata;

import java.io.InputStream;
import java.nio.file.Path;
import java.util.List;

public interface StorageProvider {
    Path createDirectory(String path);
    void deleteDirectory(String path, boolean recursive);
    void copyDirectory(String sourcePath, String targetPath);
    void moveDirectory(String sourcePath, String targetPath);

    void saveFile(String path, InputStream content, long size);
    InputStream readFile(String path);
    void deleteFile(String path);
    void copyFile(String sourcePath, String targetPath);
    void moveFile(String sourcePath, String targetPath);

    boolean exists(String path);
    boolean isDirectory(String path);
    boolean isFile(String path);
    long getFileSize(String path);
    List<FileMetadata> listDirectory(String path);
    long getDirectorySize(String path, boolean recursive);

    void validatePath(String path);
    String getAbsolutePath(String relativePath);
}
