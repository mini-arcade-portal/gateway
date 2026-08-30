**English** | [Magyar](README.hu.md)

# gateway

API gateway for the Mini Arcade Portal. Routes incoming requests to
`auth-service` and `score-service`, and exposes metrics for Prometheus.

## Stack

- Java 21, Spring Boot 4
- Spring Cloud Gateway (WebFlux)
- Spring Boot Actuator + Micrometer (Prometheus registry)

## Running locally

Run the whole stack from [`infra`](../infra), which the gateway needs to
reach `auth-service` and `score-service`:

```bash
cd ../infra
docker compose up --build
```

The gateway is then available at `http://localhost:8080`.

Alternatively, run standalone:

```bash
./mvnw spring-boot:run
```

## Configuration

Upstream service URLs are configurable via environment variables:

- `AUTH_SERVICE_URI` (default `http://localhost:8081`)
- `SCORE_SERVICE_URI` (default `http://localhost:8082`)

## Tests

```bash
./mvnw test
```
