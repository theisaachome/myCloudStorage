package com.mycloud.platform.webservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "files")
public class FileEntity extends BaseEntity{
    private String name;
    private String mimeType;
    private long size;
    private String storagePath;
    private String directoryPath;

    @ManyToOne(fetch = FetchType.LAZY)
    private DirectoryEntity parentDirectory;
    @ManyToOne(fetch = FetchType.LAZY)
    private User owner;
}
