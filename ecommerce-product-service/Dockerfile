# Stage: 1
FROM gradle:jdk8 AS builder

WORKDIR /app

# 将源代码放入后编译、打包
ADD . /app

# use BuildKit
RUN --mount=type=cache,mode=755,target=/root/.gradle gradle :ecommerce-product-service:build

# Stage: 2
FROM openjdk:8-jre

COPY --from=builder /app/ecommerce-product-service/build/libs/ecommerce-product-service.jar /app.jar

ENV profile=dev

ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=${profile}", "/app.jar"]
