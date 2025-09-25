package com.mycloud.platform.domain.exception;

public class InsufficientStorageException extends StorageException {
    public InsufficientStorageException(String message) {
        super(message);
    }
}
