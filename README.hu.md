[English](README.md) | **Magyar**

# gateway

A Mini Arcade Portal API gateway-je. A beérkező kéréseket az auth-service és
a score-service felé irányítja, valamint metrikákat biztosít a Prometheus
számára.

## Stack

- Java 21, Spring Boot 4
- Spring Cloud Gateway (WebFlux)
- Spring Boot Actuator + Micrometer (Prometheus registry)

## Futtatás lokálisan

Az egész stacket az [`infra`](../infra) mappából érdemes elindítani, mivel a
gateway-nek el kell érnie az auth-service-t és a score-service-t:

```bash
cd ../infra
docker compose up --build
```

Ezután a gateway a `http://localhost:8080` címen érhető el.

Alternatívaként önállóan is futtatható:

```bash
./mvnw spring-boot:run
```

## Konfiguráció

A backend szolgáltatások URL-je környezeti változókkal állítható:

- `AUTH_SERVICE_URI` (alapértelmezett `http://localhost:8081`)
- `SCORE_SERVICE_URI` (alapértelmezett `http://localhost:8082`)

## Tesztek

```bash
./mvnw test
```
