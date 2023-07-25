FROM openjdk:8-jdk-alpine
EXPOSE 7979
COPY build/libs/notification-service-1.0-SNAPSHOT.jar .
RUN apk add  --no-cache bash
COPY wait-for.sh /wait-for.sh
RUN chmod +x /wait-for.sh
ENTRYPOINT ["/wait-for.sh", "deposit:9090", "--timeout=70", "--", "java", "-jar", "notification-service-1.0-SNAPSHOT.jar"]