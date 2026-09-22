# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Commands

```bash
# Build
./mvnw clean package

# Run application
./mvnw spring-boot:run

# Run all tests
./mvnw test

# Run a single test class
./mvnw test -Dtest=StudentServiceTest

# Run a single test method
./mvnw test -Dtest=StudentServiceTest#findStudentByCode_WhenExists_ReturnsStudent
```

The H2 console is available at `http://localhost:8080/h2` when the app is running.

## Architecture

Educational Spring Boot project demonstrating a student-course enrollment system. Layers:

- **entity/** — JPA domain models: `Student`, `Course`, `Professor`, `Enrollment`, `User`, `Role`, `Permission`, `UserRole`. Composite keys live in `entity/keys/`.
- **repository/** — Spring Data JPA repositories. `StudentRepository` and others define custom query-derived methods (e.g., `findByNameContainingIgnoreCase`, deep nested navigation like `findByRolePermissions_Role_UserRoles_User_Username`).
- **service/** — Service interfaces (`StudentService`, `CourseService`, `EnrollmentService`, `PermissionService`, `ProfessorService`, `RoleService`, `RolePermissionService`, `UserService`, `UserRoleService`). No implementation logic lives here.
- **service/impl/** — `XxxServiceImpl` classes implementing each interface, wired via `@Service`. This is where all business logic lives. `StudentServiceImpl` still has TODO stubs for `findStudentByCode`, `getStudentsByCourseName`, `deleteStudentByCode`, `enrollStudentInCourse` and `unenrollStudentFromCourse` — the homework exercise.
- **controller/** — REST controllers (`CourseController`, `ProfessorController`, `StudentController`, `UserController`), injected against the service interfaces.

### Service layer convention
Every service is split into an interface in `service/` and a single `@Service`-annotated `XxxServiceImpl` in `service/impl/`. Controllers and tests depend on the interface type; only the interface + its impl need to change together when adding a new service.

## Testing

- **Unit tests** (`StudentServiceTest`, `CourseServiceTest`) use Mockito to mock repositories.
- **Integration tests** (`StudentServiceIntegrationTest`) hit a real H2 database with `create-drop` DDL.
- Test config in `src/test/resources/application.properties` disables `data.sql` initialization — tests set up their own data.
- Main app data seeded via `src/main/resources/data.sql`.
