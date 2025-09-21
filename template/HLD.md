
## Folder Structure

base.directory=${MYCLOUD_BASE_DIR:storage}
java -DMYCLOUD_BASE_DIR=/mnt/mycloud/storage -jar mycloud-storage-application.jar


``` 
/storage
│── users/            # Each user has a personal root directory
│    ├── john/
│    │    ├── Documents/
│    │    ├── Movies/
│    │    └── Pictures/
│    └── mary/
│         ├── Projects/
│         └── Music/
│
│── shared/           # Shared folders/files across users
│    ├── public/      # Publicly accessible (optional)
│    └── team/        # Team collaboration spaces
│
│── tmp/              # Temporary files (uploads, processing, incomplete transfers)
│
│── archive/          # Old or deleted files (soft delete / backups)
│

```

Core Actions

Typical directory/file management actions:

CREATE → create a new directory

RENAME → rename an existing directory

DELETE → delete directory and contents

COPY → copy directory (with or without contents)

MOVE → move directory to another parent

SHARE → share directory with users/roles

UNSHARE → revoke sharing permissions



# Create Directory
```json
{
  "name": "Movies",
  "action": "CREATE",
  "parentId": "root"
}
```



## Response Create Directory
```json
{
  "name": "Movies",
  "action": "CREATE",
  "parentId": "root",         
  "recursive": true,          
  "targetId": "1234-5678-ABCD", 
  "metadata": {
    "createdBy": "user123",
    "permissions": ["read", "write", "share"]
  }
}

```

# Copy Directory (with contents)
```json
{
  "action": "COPY",
  "directoryId": "abc123",
  "targetId": "xyz789",
  "recursive": true
}

```


# DELETE Directory (with contents)
```json
{
  "action": "DELETE",
  "directoryId": "abc123",
  "recursive": true
}

```



# DELETE Empty Directory
```json
{
  "action": "DELETE",
  "directoryId": "abc123",
  "recursive": false
}

```


# Share Directory
```json
{
  "action": "SHARE",
  "directoryId": "abc123",
  "sharedWith": ["user456", "user789"],
  "permissions": ["read", "download"]
}

```

## File JSON


1. Upload File (to root if no directory provided)
- /storage/users/mary/resume.pdf
```json
{
  "action": "UPLOAD",
  "fileName": "resume.pdf",
  "parentId": "root",              
  "contentType": "application/pdf",
  "size": 24567,                   
  "metadata": {
    "uploadedBy": "mary",
    "tags": ["cv", "important"]
  }
}
```
2. Upload File (to a target directory)
- /storage/users/john/Movies/photo.jpg
```json
{
  "action": "UPLOAD",
  "fileName": "photo.jpg",
  "parentId": "1234-5678-ABCD",   
  "contentType": "image/jpeg",
  "size": 582934,
  "metadata": {
    "uploadedBy": "john",
    "tags": ["vacation", "2025"]
  }
}
```
3. Copy File
```json
{
  "action": "COPY",
  "fileId": "file-001",
  "targetId": "dir-002",    
  "overwrite": false
}
```
4. Move File
```json
{
  "action": "MOVE",
  "fileId": "file-001",
  "targetId": "dir-003",
  "overwrite": true
}
```
5. Delete File
```json
{
  "action": "DELETE",
  "fileId": "file-001"
}

```
6. Share File
```json
{
  "action": "SHARE",
  "fileId": "file-001",
  "sharedWith": ["user456", "user789"],
  "permissions": ["read", "download"]
}

```
