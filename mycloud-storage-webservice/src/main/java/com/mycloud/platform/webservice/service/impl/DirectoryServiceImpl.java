package com.mycloud.platform.webservice.service.impl;
import com.mycloud.platform.webservice.dto.DirectoryRequest;
import com.mycloud.platform.webservice.dto.DirectoryResponse;
import com.mycloud.platform.webservice.dto.Metadata;
import com.mycloud.platform.webservice.exception.DirectoryNotFoundException;
import com.mycloud.platform.webservice.exception.StorageException;
import com.mycloud.platform.webservice.mapper.DirectoryMapper;
import com.mycloud.platform.webservice.repository.DirectoryRepository;
import com.mycloud.platform.webservice.service.DirectoryService;
import com.mycloud.platform.webservice.storage.StorageService;
import org.springframework.stereotype.Service;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class DirectoryServiceImpl implements DirectoryService {

    private final DirectoryRepository directoryRepository;
    private final DirectoryMapper directoryMapper;
    private final StorageService storageService;
    public DirectoryServiceImpl(DirectoryRepository directoryRepository, DirectoryMapper directoryMapper, StorageService storageService) {
        this.directoryRepository = directoryRepository;
        this.directoryMapper = directoryMapper;
        this.storageService = storageService;
    }
    @Override
    public DirectoryResponse createDirectory(DirectoryRequest directoryRequest) {
        Objects.nonNull(directoryRequest);
        var directoryEntity = directoryMapper.mapToEntity(directoryRequest);

        String path="";
        // check if it has parent
        if(directoryRequest.parentId() != null){
            var parent  = directoryRepository.findById(directoryRequest.parentId())
                    .orElseThrow(()-> new StorageException("No Such Directory Parent Id"));
                directoryEntity.setParent(parent);
                path=parent.getPath() +"/"+ directoryEntity.getName();
        }else {
            path=directoryEntity.getName();
        }

        // create directory with given name
        Path newDirPath = storageService.createDirectory(path);
        // save directory metadata in db (saved relative-path only)
        directoryEntity.setPath(newDirPath.toString());
        var savedEntity=directoryRepository.save(directoryEntity);
        return directoryMapper.mapToDto(savedEntity);
    }

    @Override
    public DirectoryResponse updateDirectory(UUID directoryId, DirectoryRequest request) {
        var directory = directoryRepository.findById(directoryId).
                orElseThrow(()-> new DirectoryNotFoundException("No Such Directory for provided id"));
        directory.setName(directory.getName());
        var savedDirectory = directoryRepository.save(directory);
        return new DirectoryResponse(savedDirectory.getId(),
                savedDirectory.getName(),
                "success",
                new Metadata(savedDirectory.getCreatedBy(),
                        savedDirectory.getUpdatedBy(),
                        savedDirectory.getCreatedAt(),
                        savedDirectory.getLastUpdatedAt()));
    }

    public DirectoryResponse copyDirectory(UUID sourceId, UUID destinationId) {
        return null;
    }

    public List<DirectoryResponse> listDirectory() {
        return List.of();
    }

    @Override
    public DirectoryResponse deleteDirectory(UUID id) {
        return null;
    }
}
