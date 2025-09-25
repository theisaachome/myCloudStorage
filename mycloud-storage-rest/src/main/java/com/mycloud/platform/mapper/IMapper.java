package com.mycloud.platform.mapper;

public interface IMapper<Req,Res,Entity> {
    Entity mapToEntity(Req req);
    Res mapToRes(Req req);
}
