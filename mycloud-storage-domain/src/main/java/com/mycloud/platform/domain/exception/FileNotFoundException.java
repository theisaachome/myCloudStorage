package com.mycloud.platform.domain.exception;

public class FileNotFoundException extends StorageException {
    public FileNotFoundException(String message) {
        super(message);
    }
}
