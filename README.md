# Kafka Microservices Demo

This project demonstrates a simple **event-driven architecture** using **Apache Kafka** with two Spring Boot microservices:

- **Order Producer Service** → exposes a REST API and publishes order events to Kafka.  
- **Order Consumer Service** → listens to the Kafka topic and processes incoming order events.  

Kafka and Zookeeper are provisioned locally using **Docker Compose**.

---

## 🚀 Tech Stack
- **Java 17**
- **Spring Boot 3**
- **Spring Kafka**
- **Apache Kafka**
- **Docker & Docker Compose**

---

## 📂 Project Structure
```

kafka-microservices-demo/
│── docker-compose.yml        # Kafka + Zookeeper + Kafka UI
│
├── order-producer/           # Producer microservice
│   ├── src/main/java/com/example/producer/
│   │   ├── controller/       # REST endpoints
│   │   ├── model/            # Data models
│   │   ├── service/          # Kafka producer logic
│   │   └── OrderProducerApplication.java
│   └── src/main/resources/application.yml
│
├── order-consumer/           # Consumer microservice
│   ├── src/main/java/com/example/consumer/
│   │   ├── service/          # Kafka consumer logic
│   │   └── OrderConsumerApplication.java
│   └── src/main/resources/application.yml
│
└── README.md

````

---

## 🛠️ Setup & Run

### 1. Start Kafka
Make sure you have **Docker** installed, then run:
```bash
docker-compose up -d
````

This starts:

* **Zookeeper** (port `2181`)
* **Kafka Broker** (port `9092`)
* **Kafka UI** (port `8082`) → optional web dashboard

Access Kafka UI at: 👉 [http://localhost:8082](http://localhost:8082)

---

### 2. Run Producer Service

In a new terminal:

```bash
cd order-producer
mvn spring-boot:run
```

Producer will start on **port 8080**.

Send an order:

```bash
curl -X POST http://localhost:8080/orders \
   -H "Content-Type: application/json" \
   -d '{"orderId":"101", "status":"CREATED"}'
```

---

### 3. Run Consumer Service

In another terminal:

```bash
cd order-consumer
mvn spring-boot:run
```

Consumer will start on **port 8081** and log messages received from Kafka.

Example output:

```
📩 Received: {"orderId":"101","status":"CREATED"}
```

---

## 🔍 Kafka UI (Optional)

You can explore:

* Topics (`orders`)
* Messages being published/consumed
* Consumer group lag

👉 Open [http://localhost:8082](http://localhost:8082)

---

## 📖 Next Steps

This demo can be extended with:

* JSON schema validation (Avro/Protobuf)
* Error handling & retries
* Multiple topics (e.g., payments, shipments)
* Dockerized microservices (so the whole system runs in Compose)

---

## 🏗️ Learn More

* [Apache Kafka Documentation](https://kafka.apache.org/documentation/)
* [Spring Kafka Reference](https://docs.spring.io/spring-kafka/reference/)

---

```


This README is **clean, step-by-step, and beginner-friendly**, while also showing future extension paths (which looks great on GitHub).  

👉 Do you want me to also **write the extended `docker-compose.yml` with Kafka UI included** so that your README instructions match exactly what devs can run?
```
