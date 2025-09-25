package com.mycloud.platform.mapper;

import com.mycloud.platform.api.dto.DirectoryRequest;
import com.mycloud.platform.api.dto.DirectoryResponse;
import com.mycloud.platform.api.dto.Metadata;
import com.mycloud.platform.domain.entity.DirectoryEntity;
import org.springframework.stereotype.Component;

@Component
public class DirectoryMapper  {
    public DirectoryEntity mapToEntity(DirectoryRequest dto) {
        return new DirectoryEntity()
                .setName(dto.directoryName());
    }

    public DirectoryResponse mapToRes(DirectoryEntity entity) {
        return new DirectoryResponse(entity.getId(),entity.getName(),entity.getPath(),
                new Metadata(entity.getCreatedTime(),entity.getUpdatedTime())
        );
    }
}
