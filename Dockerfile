# Sử dụng hình ảnh của OpenJDK làm base image
FROM openjdk:17-jdk-slim

# Cài đặt thư mục làm việc trong container
WORKDIR /app

# Sao chép file JAR của ứng dụng vào container
COPY target/*.jar app.jar

# Chạy ứng dụng Spring Boot
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

# Cổng mà ứng dụng sẽ lắng nghe
EXPOSE 8080
