# 📚 Sistema de Gestión de Biblioteca

## Descripción

Proyecto desarrollado con **Spring Boot, JPA, Thymeleaf y PostgreSQL**, que permite la gestión completa de una biblioteca mediante operaciones CRUD.

El sistema administra:

- Libros
- Autores
- Categorías
- Editoriales
- Usuarios
- Préstamos

Incluye relaciones entre entidades y persistencia de datos.

---

## Tecnologías

- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- Thymeleaf
- Bootstrap 5
- Maven

---

## Arquitectura

El proyecto sigue el patrón **MVC**:

- Model: Entidades JPA
- View: Thymeleaf + Bootstrap
- Controller: Spring MVC
- Service: Lógica de negocio
- Repository: Acceso a datos

---

## Relaciones

- Autor → Libro (1:N)
- Categoría → Libro (1:N)
- Editorial → Libro (1:N)
- Usuario → Préstamo (1:N)
- Libro → DetallePréstamo (1:N)

---

## Configuración

### Base de datos PostgreSQL

```properties
spring.application.name=taller02

spring.datasource.url=jdbc:postgresql://localhost:5432/taller02
spring.datasource.username=postgres
spring.datasource.password=Vega6489
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
