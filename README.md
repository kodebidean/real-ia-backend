# 📜 Spring Boot + PostgreSQL Template

Plantilla base para proyectos backend con **Spring Boot 3** y **PostgreSQL**, diseñada para facilitar el desarrollo de APIs REST escalables y mantenibles.

## 🔍 Propósito
Esta plantilla proporciona una configuración inicial optimizada para proyectos basados en **Spring Boot y PostgreSQL**, con una arquitectura modular y lista para producción.

## 📂 Arquitectura del Proyecto
El proyecto sigue el patrón **MRC (Modelo - Repositorio - Controlador)**, organizado de la siguiente manera:

```
📂 src/main/java/com/real_ia/backend
│── 📂 controller    # Controladores REST
│── 📂 model         # Entidades JPA (Tablas de BD)
│── 📂 repository    # Interfaces JPA para BD
│── 📂 service       # Lógica de negocio (opcional pero recomendado)
│── 📂 config        # Configuraciones de seguridad y bases de datos
│── 📂 dto           # Clases DTO (Opcional, para manejar datos específicos)
│── 📜 BackendApplication.java  # Clase principal de Spring Boot
```

## 🔧 Configuración del Proyecto

### 1️⃣ **Requisitos Previos**
- **Java 21**
- **Maven 3.x**
- **PostgreSQL** (instalado y corriendo)

### 2️⃣ **Configuración de PostgreSQL**
Asegúrate de actualizar el archivo `src/main/resources/application.properties` con tus credenciales de PostgreSQL:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5433/real_ia_bd
spring.datasource.username=postgres
spring.datasource.password=tu_contraseña
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.database=postgresql
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.properties.hibernate.format_sql=true
```

### 3️⃣ **Ejecutar el Proyecto**
Desde la terminal, navega hasta la raíz del proyecto y ejecuta:

```sh
mvn clean install
mvn spring-boot:run
```

Si la ejecución es exitosa, deberías ver:
```
Tomcat started on port 8080 (http) with context path '/'
Started BackendApplication in X seconds
```

## 📡 Endpoints de Prueba
Una vez que el servidor está en ejecución, puedes probar los endpoints con **Postman** o directamente en el navegador:

- **Verificar el estado del backend**:
  ```http
  GET http://localhost:8080/api/test
  ```

## 🛠 Dependencias Clave
El proyecto utiliza las siguientes tecnologías:

| Dependencia | Descripción |
|------------|-------------|
| `Spring Boot Web` | Para crear APIs REST |
| `Spring Data JPA` | Manejo de base de datos con Hibernate |
| `PostgreSQL Driver` | Conexión con PostgreSQL |
| `Lombok` | Reduce código repetitivo en las entidades |
| `Spring Boot DevTools` | Recarga automática en desarrollo |

## 🛡 Seguridad y Buenas Prácticas
### 1️⃣ **Archivos Ignorados por `.gitignore`**
Para proteger información sensible, aseguramos que archivos como credenciales y logs **no sean subidos a Git**.

### 2️⃣ **Manejo de Versionado**
Se recomienda utilizar **GitHub Actions** para CI/CD y establecer versiones de despliegue con **Maven**.

---

