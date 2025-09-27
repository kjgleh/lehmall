# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a Spring Boot e-commerce application ("lehmall") built with Kotlin, using a domain-driven design approach with separate bounded contexts for Orders, Members, and Products.

## Tech Stack

- **Language**: Kotlin 1.9.25
- **Framework**: Spring Boot 3.5.6
- **Build Tool**: Gradle with Kotlin DSL
- **Database**: MySQL (port 53306)
- **JVM**: Java 21
- **Key Libraries**: Spring Data JPA, Spring Web, OpenFeign for internal service communication

## Commands

### Build & Run
```bash
./gradlew bootRun              # Run the application
./gradlew build                 # Build the project
./gradlew clean build           # Clean and build
./gradlew bootJar               # Create executable JAR
```

### Testing
```bash
./gradlew test                  # Run all tests
./gradlew test --tests "TestClassName"  # Run specific test class
./gradlew test --tests "TestClassName.testMethodName"  # Run specific test method
```

### Code Quality
```bash
./gradlew check                 # Run all verification tasks
./gradlew clean                 # Clean build directory
```

## Architecture

The application follows a layered architecture with clear separation of concerns:

### Package Structure
- **adapter**: External interfaces (web API controllers, internal service clients, schedulers)
  - `webapi`: REST controllers
  - `internal`: Feign clients for internal service communication
  - `scheduler`: Scheduled tasks
- **domain**: Core business entities and domain logic
  - JPA entities with auditing support (`AuditingDate` base class)
  - Domain DTOs for data transfer
- **service**: Business logic layer with service classes
- **repository**: Data access layer with Spring Data JPA repositories

### Bounded Contexts
1. **Order** (`org.example.lehmall.order`): Order management including creation, cancellation, and order items
2. **Member** (`org.example.lehmall.member`): Member/customer management
3. **Product** (`org.example.lehmall.product`): Product catalog management

### Key Design Patterns
- **Entity Factory Methods**: Entities use companion object factory methods (e.g., `OrderEntity.of()`)
- **Protected Setters**: Domain entities use protected setters to maintain encapsulation
- **Feign Clients**: Internal service communication via OpenFeign clients
- **Repository Extensions**: Custom repository functionality through extension functions

## Database Configuration

The application uses MySQL with Hibernate. Key settings:
- DDL Auto: `create-drop` (development mode - recreates schema on startup)
- Show SQL: enabled with formatting
- Batch fetching: configured with size 100
- Connection: `jdbc:mysql://localhost:53306/lehmall`

## Spring Boot Features

- **OpenFeign**: Enabled via `@EnableFeignClients` for declarative REST client support
- **JPA Auditing**: Base auditing support through `AuditingDate` class
- **REST Controllers**: Standard Spring MVC REST endpoints
- **Kotlin Support**: Full Kotlin integration with JPA plugin for proper entity handling