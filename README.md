# HookDB API 🕹️

#

## Tecnologías Utilizadas 💻

Esta API ha sido desarrollada utilizando las siguientes tecnologías:

- **Java**: Lenguaje de programación de alto nivel utilizado para el desarrollo del backend.
- **Spring**: Framework de Java utilizado para simplificar la infraestructura de desarrollo.
- **Spring Security**: Framework de seguridad que proporciona autenticación y autorización a aplicaciones Java.
- **Swagger**: Herramienta de software de código abierto utilizada para diseñar, construir y documentar servicios web RESTful.
- **MySQL**: Sistema de gestión de bases de datos relacional utilizado para almacenar los datos de la aplicación.
- **Lombok**: Biblioteca de Java que se utiliza para reducir el código repetitivo.
- **JSON Web Token (JWT)**: Estándar de la industria para la creación de tokens de acceso que permiten la propagación de identidades y privilegios.
- **BCrypt**: Algoritmo de hashing para contraseñas.

## Arquitectura 🏗️

La API sigue el patrón de diseño **Modelo-Servicio-Controlador (MSC)**. Este es un patrón de arquitectura de software que divide la lógica de la aplicación en tres componentes interconectados. Esto permite un desarrollo más organizado y modular.

- **Modelo**: Representa los datos y las reglas de negocio de la aplicación.
- **Servicio**: Encapsula la lógica de negocio y controla las transacciones.
- **Controlador**: Maneja las solicitudes del usuario y devuelve una respuesta.

## Seguridad 🔒

La API implementa medidas de seguridad para proteger los datos y garantizar que sólo los usuarios autorizados tengan acceso a ciertas funcionalidades. Utiliza **Spring Security** para la autenticación y autorización, **JWT** para la creación de tokens de acceso, y **BCrypt** para el hashing de contraseñas.

## Autor 🖋️

Esta API ha sido desarrollada por **David Portillo Hoyos**.