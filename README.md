# Solução de E-commerce com Microsserviços em Java

Neste projeto prático iremos desenvolver uma solução de e-commerce com a arquitetura de microsserviços e aplicar a integração entre eles orientada a eventos com Apache Kafka e garantir a compatibilidade entre da comunicação dos microsserviços com Schema Registry. Para isso, programaremos em Java utilizando a stack do Spring (Spring Boot, Spring Cloud Streams).

## Tecnologias backend

- Java 21
- Spring Framework / Spring Boot
- Spring Cloud Stream
- Apache Kafka
- Apache Avro
- Schema Registry
- PostgreSQL

### Testes

- Junit 5
- Cucumber
- TestContainers

## Atualizações de versões:

- Spring Boot 3.3
- Spring Cloud Stream 4.1
- ConfluentInc Kafka and Schema Registry 7.6.1

## Tecnologias frontend

- HTML
- Bootstrap
- Javascript

## Introdução ao projeto e suas tecnologias

[Slides de introdução](/intro.md)

## Garantindo a qualidade

[Slides sobre QA](/qa.md)

[Cucumber Website](https://cucumber.io/)

[TestContainers Website](https://testcontainers.com/)

[TestContainers for Java Website](https://java.testcontainers.org/)

## Guias

[Spring initializr: e-commerce-checkout-api](https://start.spring.io/#!type=gradle-project&language=java&platformVersion=3.3.1&packaging=jar&jvmVersion=21&groupId=me.dio.hiokdev&artifactId=e-commerce-checkout-api&name=e-commerce-checkout-api&description=E-commerce%20Checkout%20API%20Microservice&packageName=me.dio.hiokdev.e-commerce-checkout-api&dependencies=web,cloud-stream,distributed-tracing,kafka-streams,lombok,data-jpa,postgresql,validation,kafka)

[Spring Cloud Stream Reference Documentation](https://docs.spring.io/spring-cloud-stream/reference/spring-cloud-stream.html)

[Spring Cloud Stream Kafka Binder Reference Guide](https://docs.spring.io/spring-cloud-stream/docs/current/reference/html/spring-cloud-stream-binder-kafka.html)

[Spring initializr: e-commerce-payment-api](https://start.spring.io/#!type=gradle-project&language=java&platformVersion=3.3.1&packaging=jar&jvmVersion=21&groupId=me.dio.hiokdev&artifactId=e-commerce-payment-api&name=e-commerce-payment-api&description=E-commerce%20Checkout%20API%20Microservice&packageName=me.dio.hiokdev.e-commerce-payment-api&dependencies=web,cloud-stream,distributed-tracing,kafka-streams,lombok,data-jpa,postgresql,validation,kafka)
