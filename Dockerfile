FROM maven:3.8.4 AS builder
WORKDIR /usr/src/myapp
COPY . .
RUN mvn clean install

FROM openjdk
WORKDIR /usr/src/myapp
COPY --from=builder /usr/src/myapp/target/product.jar .
CMD ["java", "-jar", "product.jar"]
EXPOSE 8080
