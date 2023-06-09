# respring-proyecto

Proyecto api rest usando springboot para la parte backend, javascript y html para el frontend y maven para las dependencias.

El programa se conecta con la base de datos usuarios en localhost:8080 en donde la persona se puede registrar y se pueden visualizar todos los usuarios y eliminar cada uno que queramos.

La contraseña en el momento de registro esta encriptada usando argon2 para hashearla, por lo que el campo contraseña en la base de datos debe tener como minimo 300 caracteres en varchar.
