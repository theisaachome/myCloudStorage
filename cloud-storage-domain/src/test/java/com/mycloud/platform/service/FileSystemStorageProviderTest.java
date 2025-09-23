package com.mycloud.platform.service;
import com.mycloud.platform.BaseServiceTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class FileSystemStorageProviderTest extends BaseServiceTest {


    @Test
    @DisplayName("should create a new directory and its nested subdirectory when names are provided")
    void testCreateDirectory() throws IOException {
        // Given
        String parentDirName = "parentDir";
        String subDirName = "subDir";


        // When
        Path parentDir = fileSystemStorageProvider.createDirectory(parentDirName);
        Path subPath = parentDir.resolve(subDirName);
        Path childDir = fileSystemStorageProvider.createDirectory(subPath.toString());


        // Then
        assertTrue(Files.exists(parentDir), "Parent directory should be created");
        assertEquals(storageProperties.getUsersPath().resolve(parentDirName), parentDir,
                "Created directory path should match expected location");
        assertEquals(storageProperties.getUsersPath().resolve(parentDirName).resolve(subDirName), childDir,
                "Nested directory path should match expected location");

        // Cleanup
        Files.deleteIfExists(childDir);
        Files.deleteIfExists(parentDir);
    }
    @Test
    @DisplayName("should delete an empty directory when directory name is provided")
    void deleteDirectory() throws IOException {
        // Given
        String dirName = "Movies";
        Path createdDir = fileSystemStorageProvider.createDirectory(dirName);

        // When
        fileSystemStorageProvider.deleteDirectory(dirName, false);

        // Then
        assertFalse(Files.exists(createdDir), "Directory should be deleted");
    }

    @Test
    @DisplayName("should delete non-empty along with its subdirectories")
    void deleteSubDirectories(){
        // Given
        String dirName = "Movies";
        String subDirName = "actions";

        Path parentDir = fileSystemStorageProvider.createDirectory(dirName);
        Path subDir = parentDir.resolve(subDirName);
        Path nestedDir = fileSystemStorageProvider.createDirectory(subDir.toString());

        // When
        fileSystemStorageProvider.deleteDirectory(dirName, true);
        // Then
        assertFalse(Files.exists(parentDir), "Parent directory should be deleted");
        assertFalse(Files.exists(nestedDir), "Nested subdirectory should also be deleted");

    }

}
