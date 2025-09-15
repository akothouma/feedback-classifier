# feedback-classifier
This project creates a service that takes customer feedback and passes it through an AI that classifies the feedback.

I decided to do an incremental build from monolith to microservices to aid my learning and developmental journey.

So far with this monolith what I have learnt includes:

PHASE 1:MONOLITHIC FOUNDATION
## A Professional Project Setup:
Choose Gradle, a modern and powerful build tool, over the more traditional Maven.

Configured the project to use Java 21, the latest Long-Term Support (LTS) version.

Environment Configuration: Fixed complex JAVA_HOME issues.
## A Containerized Development Environment with Docker:
Used the Docker Engine on Linux, the native environment for containers.

Pulled the official PostgreSQL image and ran it as a container, isolating the database from the host machine. I correctly configured port mapping (-p 5432:5432) to allow the application to communicate with the database inside the container.

Implemented a persistent named volume (-v pgdata...) to ensure your database's data survives container restarts, a critical step for stateful services.

## A Version-Controlled Database Schema:
Integrated Flyway  for database migrations.

Used DBeaver, a professional database client to connect to the containerized PostgreSQL 
instance, run the initial CREATE DATABASE command, and later verified that Flyway migrations were working correctly.

Managed schema changes by creating new versioned SQL scripts (V1, V2) proving I can handle the evolution of a database over time.

Used Hibernate's validate feature as a safety net to detect when  code and database were out of sync.

 ## A Robust Persistence Layer:
I created JPA Entities (Customer, Feedback) to model your database tables.

I used Lombok to keep your model classes clean and free of boilerplate.

Created a Repository Layer using JpaRepository interfaces, leveraging the power of Spring Data JPA to handle database operations.

## A Well-Structured Application Core:
I implemented the standard three-layer architecture (Controller -> Service -> Repository), which demonstrates a clear separation of concerns.

I used Dependency Injection (@Autowired) to wire your components together, creating a loosely coupled and testable application.

## A Live, Documented API:
Built a functioning REST API endpoint (POST /api/v1/feedback).

Integrated Springdoc-openapi (Swagger) to automatically generate a live, interactive documentation page for my API. 

