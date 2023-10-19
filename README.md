# User Management MS
Manejo de usuarios (Genérico) WIP.

Tecnologías aplicadas:
- Spring Boot
- Mapstruct
- Feign Client (Api externa, llamada a fake API)
- JPA/Crudrepository
- BBDD H2

Se han realizado tres endPoints para realizar el manejo de usuarios, todos ellos apuntando a un mock.

1 - Añadir Usuario (Add User):

Url:  http://localhost:8181/getUsersInfo/user

Body (JSON):

{
  "idUser":"5"
}

Resultado:

{
    "first_name": "JOSHUAH",
}

Además se realiza la inserción en BBDD del usuario. Accediendo a la consola H2:

http://localhost:8181/h2-console/

Y lanzando la query, tendremos el ID recién insertado.

SELECT * FROM USERS 
