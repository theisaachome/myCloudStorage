
### MyCloud Storage System

MyCloud Storage System is a modular cloud-based file storage platform built with Spring Boot (backend) and ReactJS (frontend).
The system provides:

- Secure file management – upload, download, and delete files.
- Directory management – create and organize directories for better file structuring. 
- File and directory sharing – share files and folders with other users securely. 
- REST APIs – to integrate seamlessly with client applications and third-party systems.


### Project Structure

This project is organized as a multi-module Maven project:
```psql
mycloud-storage-system/
│── cloud-storage-domain/                 # Core domain models and shared business logic
│── mycloud-storage-rest/                 # REST API layer (Spring Boot controllers, DTOs)
│── mycloud-storage-application/          # Application service layer (use cases, orchestration)

```

Tech Stack

- Java 21+ 
- Spring Boot 3+ 
- Maven (multi-module build)
- ReactJS (frontend UI)
- PostgreSQL (default persistence, configurable)




