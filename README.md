# Servicio Zuul Server

### Introducción

El microservicio representa la puerta de acceso principal a todo el ecosistema de microservicios registrados en Eureka Server.

### Caracteristicas:

- Se encarga del acceso a los servicios registrados en Eureka-Server (API Gateway).
- Enrutamiento dinámico.
- Integración con balanceadores de carga (Ribbon).
- Conjunto de filtros para dar seguridad al acceso.
- Manejo de error.
- Monitorización de métricas.
- Registros de logs.

### Dependencias

- spring-boot-starter-web
- spring-cloud-starter-netflix-eureka-client
- spring-cloud-starter-netflix-zuul
- spring-boot-devtools