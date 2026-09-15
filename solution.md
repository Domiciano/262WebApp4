# Solución — Laboratorio de Query Methods

## 1. `StudentRepository` — estudiante por su código único

```java
Optional<Student> findByCode(String code);
```

## 2. `ProfessorRepository` — profesores cuyo nombre contenga una cadena (ignorando mayúsculas/minúsculas)

```java
List<Professor> findByNameContainingIgnoreCase(String name);
```

## 3. `CourseRepository` — cursos con un número específico de créditos

```java
List<Course> findByCreditsEquals(int credits);
```

## 4. `StudentRepository` — estudiantes de un programa académico

```java
List<Student> findByProgram(String program);
```

## 5. `CourseRepository` — curso por nombre exacto, ignorando mayúsculas/minúsculas

```java
Optional<Course> findByNameIgnoreCase(String name);
```

## 6. `CourseRepository` — cursos de un profesor (por nombre), ordenados alfabéticamente

```java
List<Course> findByProfessor_NameOrderByNameAsc(String name);
```

## 7. `StudentRepository` — estudiantes de un programa cuyo código empiece por un prefijo dado

```java
List<Student> findByProgramAndCodeStartingWith(String program, String prefix);
```

## 8. `CourseRepository` — cursos con créditos entre dos valores

```java
List<Course> findByCreditsBetween(int minCredits, int maxCredits);
```

## 9. `StudentRepository` — estudiantes que cursan materias con un profesor específico

Navega `Student → studentCourses → course → professor → name`.

```java
List<Student> findDistinctByStudentCourses_Course_Professor_Name(String professorName);
```

## 10. `ProfessorRepository` — profesores (sin duplicados) que enseñan a estudiantes de un programa específico

Navega `Professor → courses → enrollments → student → program`.

```java
List<Professor> findDistinctByCourses_Enrollments_Student_Program(String program);
```

## 11. `UserRepository` — usuario por su nombre de usuario

```java
Optional<User> findByUsername(String username);
```

## 12. `UserRepository` — usuarios que tengan un rol específico (por nombre)

Navega `User → userRoles → role → name`.

```java
List<User> findByUserRoles_Role_Name(String roleName);
```

## 13. `RoleRepository` — roles cuyo nombre contenga una cadena, ignorando mayúsculas/minúsculas

```java
List<Role> findByNameContainingIgnoreCase(String name);
```

## 14. `UserRepository` — usuarios que tengan un permiso específico

Navega `User → userRoles → role → rolePermissions → permission → name`.

```java
List<User> findDistinctByUserRoles_Role_RolePermissions_Permission_Name(String permissionName);
```

## 15. `PermissionRepository` — permisos asignados a un usuario por username

Navega `Permission → rolePermissions → role → userRoles → user → username`.

```java
List<Permission> findDistinctByRolePermissions_Role_UserRoles_User_Username(String username);
```

---

## Reto: navegación avanzada

### 16. `ProfessorRepository` — profesores que dictan un curso cuyo nombre contenga cierto texto (ignorando mayúsculas), y que en ese mismo curso haya al menos un estudiante cuyo código contenga cierto texto

Navega `Professor → courses → name` y, por separado, `Professor → courses → enrollments → student → code`.

```java
List<Professor> findDistinctByCourses_NameContainingIgnoreCaseAndCourses_Enrollments_Student_CodeContaining(
        String courseName, String code);
```

### 17. `StudentRepository` — estudiantes inscritos en un curso con créditos entre dos valores, dictado por un profesor cuyo nombre contenga cierto texto (ignorando mayúsculas)

Ambas condiciones tienen que cumplirse sobre la misma inscripción — navega el mismo camino dos veces:
`studentCourses → course → credits` y `studentCourses → course → professor → name`.

```java
List<Student> findDistinctByStudentCourses_Course_CreditsBetweenAndStudentCourses_Course_Professor_NameContainingIgnoreCase(
        int minCredits, int maxCredits, String professorName);
```

### 18. `UserRepository` — usuarios que tengan un rol con un nombre específico, y que ese mismo rol tenga asignado al menos un permiso cuyo nombre contenga cierto texto

Navega `User → userRoles → role → name` y `User → userRoles → role → rolePermissions → permission → name`.

```java
List<User> findDistinctByUserRoles_Role_NameAndUserRoles_Role_RolePermissions_Permission_NameContainingIgnoreCase(
        String roleName, String permissionText);
```
