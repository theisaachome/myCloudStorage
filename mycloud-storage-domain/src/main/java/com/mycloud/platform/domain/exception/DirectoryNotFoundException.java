package com.mycloud.platform.domain.exception;

public class DirectoryNotFoundException extends StorageException {
    public DirectoryNotFoundException(String message) {
        super(message);
    }
}
