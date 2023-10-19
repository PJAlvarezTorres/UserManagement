# User Management

Microservicio que se encarga del manejo básico de usuarios. 

# Operaciones

- Obtener usuario (A partir de ID)
- Insertar usuario en BBDD (H2)
- Obtener todos los usuarios
- Añadir usuario al sistema

# Tecnologías aplicadas

-   Spring Boot
-   Mapstruct
-   Feign Client (Api externa, llamada a fake API)
-   JPA/Crudrepository
-   Openapi
-   BBDD H2

## Operación "Extraer usuario".

1 - Extraer usuario:

GET:  [http://localhost:8181/getUsersInfo/user](http://localhost:8181/getUsersInfo/user)
Body (JSON):
```bash
{
   "idUser": "5"
}
```
Resultado:

Resultado:
```bash
{
   "first_name": "JOSHUAH"
}
```
Además se realiza la inserción en **BBDD** del usuario. Accediendo a la consola H2:

[http://localhost:8181/h2-console/](http://localhost:8181/h2-console/)

Y lanzando la query, tendremos el ID recién insertado.

**SELECT * FROM USERS**
> **Nota:** La base de datos es una base de datos H2 (Tiempo de ejecución). Se puede modificar por una base de datos SQL

## Operación "Extraer todos los usuarios".

2 - Extraer usuarios(GetUsers):

GET:  [http://localhost:8181/getUsersInfo/user](http://localhost:8181/getUsersInfo/user)

Resultado:
```bash
{
"users": [
		{
			"first_name": "Alyosha",
			"id": 1
		},
		{
			"first_name": "Danyelle",
			"id": 2
		},
		{
			"first_name": "Raimund",
			"id": 3
		}
	]
}
```

## Operación "Extraer todos los usuarios".

3 - Añadir usuario (AddUser):

POST:  [http://localhost:8181/getUsersInfo/addUser](http://localhost:8181/getUsersInfo/user)
Body (JSON)
```bash
{
	"id": 25,
	"address": [
			{
				"street": "4973 Green Way",
				"street_name": "Hermina",
				"city": "Corona",
				"state": "California",
				"country": "United States",
				"country_code": "US",
				"postal_code": "92878"
	}
	],
	"phone": "+48 (803) 182-9995"
}
```
Resultado:
```bash
{
	"userData": {
		"id": "25",
		"address": [
				{
					"street": "4973 Green Way",
					"street_name": null,
					"city": "Corona",
					"state": "California",
					"country": "United States",
					"country_code": null,
					"postal_code": null
				}
		],
		"phone": "+48 (803) 182-9995"
		},
	"createdAt": null,
	"updatedAt": null
}
```
