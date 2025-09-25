package com.mycloud.platform.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "directories")
public class DirectoryEntity  extends BaseEntity{
    private String name;
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
}
