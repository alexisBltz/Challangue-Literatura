### Challangue-Literatura

Challangue-Literatura es un proyecto desarrollado con JPA y Spring para gestionar libros y autores. Utiliza la API de Gutendex para obtener datos de libros y permite realizar diversas operaciones sobre los libros y autores registrados en la base de datos.

## Requisitos

- Java 11 o superior
- Maven 3.6.0 o superior
- Spring Boot 2.5.4 o superior
- Una base de datos compatible con JPA (por ejemplo, MySQL, PostgreSQL)

## Instalación

1. Clona el repositorio:
   
   ```bash
   git clone https://github.com/alexisBltz/challangue-literatura.git
   cd challangue-literatura
   ```

3. Configura la base de datos en `application.properties`:
   ```properties
    spring.application.name=literalura
    server.port=8081
    spring.datasource.url= jdbc:postgresql://${DB_HOST}/literaturadb
    spring.datasource.username=${DB_USER}
    spring.datasource.password=${DB_PASSWORD}
    spring.datasource.driver-class-name=org.postgresql.Driver
    hibernate.dialect=org.hibernate.dialect.HSQLDialect
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.format-sql = true
   ```

4. Compila y ejecuta el proyecto:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

## Funcionalidades

1. **Agregar libro por título**
   - Permite buscar un libro por su título a través de la API de Gutendex y agregarlo a la base de datos.
   - Uso:
     - Selecciona la opción `1` en el menú.
     - Ingresa el título del libro a buscar.
     - Si se encuentra, el libro se agregará a la base de datos.

2. **Listar libros registrados**
   - Muestra todos los libros registrados en la base de datos.
   - Uso:
     - Selecciona la opción `2` en el menú.
     - Se listarán todos los libros registrados.

3. **Listar autores registrados**
   - Muestra todos los autores registrados en la base de datos.
   - Uso:
     - Selecciona la opción `3` en el menú.
     - Se listarán todos los autores registrados.

4. **Listar autores vivos en un determinado año**
   - Permite listar los autores que estaban vivos en un año específico.
   - Uso:
     - Selecciona la opción `4` en el menú.
     - Ingresa el año de búsqueda.
     - Se listarán los autores vivos en ese año.

5. **Listar libros por idioma**
   - Permite listar libros registrados en la base de datos por su idioma.
   - Uso:
     - Selecciona la opción `5` en el menú.
     - Ingresa el idioma (español 'es' o inglés 'en').
     - Se listarán los libros en el idioma especificado.

## Uso

Ejecuta la aplicación y sigue las opciones del menú para interactuar con las funcionalidades disponibles. Cada opción te guiará a través del proceso correspondiente.

## Contribuciones

Las contribuciones son bienvenidas. Si deseas contribuir, por favor realiza un fork del repositorio, crea una rama con tus cambios y envía un pull request.

## Licencia

Este proyecto está licenciado bajo los términos de la licencia MIT. Consulta el archivo `LICENSE` para más detalles.
