package com.mycloud.platform.exception;

public class FileNotFoundException extends StorageException {
    public FileNotFoundException(String message) {
        super(message);
    }
}
