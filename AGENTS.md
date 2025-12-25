# Repository Guidelines

## Project Structure & Module Organization
This is a Kotlin/Spring Boot monolith with bounded contexts under `src/main/kotlin/org/example/lehmall`. Key areas include `order`, `member`, `product`, and `discountpolicy`, each using layered packages like `adapter`, `app/service`, `domain`, and `app/repository`. Shared utilities live in `common`. Configuration and entry points are in `src/main/kotlin/org/example/lehmall/config` and `src/main/kotlin/org/example/lehmall/LehmallApplication.kt`. Tests live in `src/test/kotlin` with shared test support under `src/test/kotlin/org/example/lehmall/testsupport`. Runtime configuration is in `src/main/resources/application.yml` and test config in `src/test/resources/application-test.yml`.

## Build, Test, and Development Commands
- `./gradlew bootRun` runs the application locally.
- `./gradlew build` builds the project and runs verification tasks.
- `./gradlew clean build` cleans and rebuilds from scratch.
- `./gradlew test` runs the full test suite.
- `./gradlew test --tests "ClassName"` runs a single test class.
- `./gradlew test --tests "ClassName.testName"` runs a single test method.
- `./gradlew check` executes all verification tasks (tests, lint if configured).

## Coding Style & Naming Conventions
Use Kotlin idioms and keep entity mutability controlled (protected setters, factory methods). Follow package conventions under `org.example.lehmall`. Class names are PascalCase, functions and properties are camelCase. Keep files aligned with their bounded context directories (e.g., order services in `src/main/kotlin/org/example/lehmall/order/app/service`). Indentation should be 4 spaces.

## Testing Guidelines
Tests use JUnit via Gradle. Test classes should mirror production packages (e.g., `order/domain` tests in `src/test/kotlin/org/example/lehmall/order/domain`). Naming follows `*Test` and `*Fixture` patterns, with reusable fixtures in `src/test/kotlin/org/example/lehmall/order/domain` and shared support in `src/test/kotlin/org/example/lehmall/testsupport`. Run focused tests with `./gradlew test --tests "FullyQualifiedTestName"`.

## Commit & Pull Request Guidelines
Recent commit history uses short `wip` messages; prefer clearer messages going forward (e.g., `feat(order): add cancel flow` or `fix(member): handle null email`). For pull requests, include a concise description, link related issues, and add API screenshots or request/response samples when changing controllers. Mention test commands run and any migration or config updates.

## Configuration & Runtime Notes
Local MySQL is expected (see `src/main/resources/application.yml`). Default schema settings in development use `create-drop`, so be cautious with local data. Internal service calls use OpenFeign; keep DTOs in the context-specific `domain/dto` or `app/service/provided/dto` packages.
