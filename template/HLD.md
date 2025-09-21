
## Folder Structure

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
# Create Directory
```json
{
  "name": "Movies",
  "action": "CREATE",
  "parentId": "root"
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

# Share Directory
```json
{
  "action": "SHARE",
  "directoryId": "abc123",
  "sharedWith": ["user456", "user789"],
  "permissions": ["read", "download"]
}

```
