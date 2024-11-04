# Используем официальный образ OpenJDK с JDK 18
FROM eclipse-temurin:18-jdk-alpine

# Устанавливаем рабочую директорию внутри контейнера
WORKDIR /app

# Копируем файл с билдом приложения (JAR-файл) в контейнер
COPY build/libs/Reserve-1.0-SNAPSHOT.jar reserve-app.jar

# Открываем порт, который будет использовать Spring Boot
EXPOSE 8084

# Команда для запуска приложения
ENTRYPOINT ["java", "-jar", "reserve-app.jar"]
