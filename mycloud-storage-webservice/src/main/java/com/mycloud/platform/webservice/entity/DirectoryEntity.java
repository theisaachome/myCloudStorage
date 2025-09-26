package com.mycloud.platform.webservice.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "directories")
public class DirectoryEntity  extends BaseEntity {
    private String name;
    private String mimeType;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private DirectoryEntity parent;


    private String path;

    public String getPath() {
        return path;
    }

    public DirectoryEntity setPath(String path) {
        this.path = path;
        return this;
    }

    public String getName() {
        return name;
    }

    public DirectoryEntity setName(String name) {
        this.name = name;
        return this;
    }

    public DirectoryEntity getParent() {
        return parent;
    }

    public DirectoryEntity setParent(DirectoryEntity parent) {
        this.parent = parent;
        return this;
    }

    public String getMimeType() {
        return mimeType;
    }

    public DirectoryEntity setMimeType(String mimeType) {
        this.mimeType = mimeType;
        return this;
    }
}
