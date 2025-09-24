package com.mycloud.platform.mapper;

import com.mycloud.platform.dto.DirectoryRequest;
import com.mycloud.platform.entity.DirectoryEntity;
import org.springframework.stereotype.Component;

@Component
public class DirectoryMapper {

    public DirectoryEntity mapToEntity(DirectoryRequest request){
        return  new DirectoryEntity()
                .setName(request.name());
    }
}
