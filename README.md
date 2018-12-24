** Aplicación de red social HeadBook**

La aplicación fue desarollada con Eclipse 2018-2019, Spring Boot, Hibernate, Thymeleaf y con la base de datos PostgreSQL versión 10.

---

## Crear la Base de Datos

Para crear la base de datos se deben usar los archivos en el directorio resources/static/bd en el proyecto.

1. Se debe crear un role headbook con password 12345.
2. La base de datos se debe llamar headbook.
3. Se debe crear un schema llamado headbook.
4. Ahora se podrán correr las instrucciones que están en el archivo headbook.sql 

---

## Usuarios

Los usuarios para trabajar con la aplicación son:

1. usuario: user1  contraseña: password.
2. usuario: user1  contraseña: password.
3. No fue un requerimiento de la prueba, pero se creo el login para los usuarios.
4. Se creo el login, para que las funcionalidades de hacer like y crear post trabajaran con dicho usuario.
5. Se agregaron los campos username y password en la tabla usuario

---

## Otros

Comentarios varios acerca de la aplicación

1. El enlace de agregar post está bajo el listado inicial de post, si la pantalla no se abre completa a lo mejor quede oculto.
2. La aplicación fue probada en Google Chrome y en Mozilla Firefox
3. Cualquier problema con la aplicación, favor escribir al email luisnarvaez@gmail.com
4. Por cuestiones de estética se mostraron 75 caracteres del contenido en vez de 50.