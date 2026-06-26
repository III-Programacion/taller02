# 📚 Sistema de Gestión de Biblioteca

## 📌 Descripción

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

## 🚀 Tecnologías

- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- Thymeleaf
- Bootstrap 5
- Maven

---

## 🧩 Arquitectura

El proyecto sigue el patrón **MVC**:

- Model: Entidades JPA
- View: Thymeleaf + Bootstrap
- Controller: Spring MVC
- Service: Lógica de negocio
- Repository: Acceso a datos

---

## 🔗 Relaciones

- Autor → Libro (1:N)
- Categoría → Libro (1:N)
- Editorial → Libro (1:N)
- Usuario → Préstamo (1:N)
- Libro → DetallePréstamo (1:N)

---

## ⚙️ Configuración

### Base de datos PostgreSQL

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/biblioteca
spring.datasource.username=postgres
spring.datasource.password=admin

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
