package com.mycloud.platform.webservice.mapper;

import com.mycloud.platform.webservice.dto.DirectoryRequest;
import com.mycloud.platform.webservice.dto.DirectoryResponse;
import com.mycloud.platform.webservice.dto.Metadata;
import com.mycloud.platform.webservice.entity.DirectoryEntity;
import org.springframework.stereotype.Component;

@Component
public class DirectoryMapper {

    public DirectoryEntity mapToEntity(DirectoryRequest dto) {
        var entity = new DirectoryEntity()
                .setName(dto.name())
                .setMimeType(dto.mimeType());
        return entity;
    }
    public DirectoryResponse mapToDto(DirectoryEntity entity) {
        return new DirectoryResponse(
                 entity.getId(),
                entity.getName(),
                "success",
                new Metadata(entity.getCreatedBy(),
                        entity.getUpdatedBy(),
                        entity.getCreatedAt(),
                        entity.getLastUpdatedAt()));
    }
}
