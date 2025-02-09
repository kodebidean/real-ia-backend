# 🚀 Real IA Backend

Backend del proyecto **Real IA**, basado en **Spring Boot + PostgreSQL**.

## 📌 Características
- API REST desarrollada con **Spring Boot 3.2.2**.
- Base de datos **PostgreSQL** integrada con **Spring Data JPA**.
- Arquitectura **MRC (Modelo - Repositorio - Controlador)**.
- Configuración lista para producción y despliegue.

## 📂 Estructura del Proyecto
El código sigue un diseño modular y bien estructurado:

```
📂 src/main/java/com/real_ia/backend
│── 📂 controller    # Controladores REST
│── 📂 model         # Entidades JPA (Tablas de BD)
│── 📂 repository    # Interfaces JPA para BD
│── 📂 service       # Lógica de negocio
│── 📂 config        # Configuraciones del sistema
│── 📂 dto           # Clases DTO (Opcional)
│── 📜 BackendApplication.java  # Clase principal
```

## 🔧 Configuración de PostgreSQL
Asegúrate de configurar correctamente la base de datos en `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5433/real_ia_bd
spring.datasource.username=postgres
spring.datasource.password=tu_contraseña
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.database=postgresql
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

## 🚀 Ejecutar el Proyecto
Para compilar y ejecutar el backend, usa los siguientes comandos:

```sh
mvn clean install
mvn spring-boot:run
```

Si todo funciona correctamente, deberías ver:
```
Tomcat started on port 8080 (http) with context path '/'
Started BackendApplication in X seconds
```

## 📡 Endpoints de Prueba
Puedes probar el backend con herramientas como **Postman** o directamente en el navegador:

- **Verificar estado del backend**:
  ```http
  GET http://localhost:8080/api/test
  ```

---


