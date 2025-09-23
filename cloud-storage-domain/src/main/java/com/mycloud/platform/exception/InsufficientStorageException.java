package com.mycloud.platform.exception;

public class InsufficientStorageException extends StorageException {
    public InsufficientStorageException(String message) {
        super(message);
    }
}
