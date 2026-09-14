# Stage 1: Build file WAR bằng Maven
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copy pom.xml và tải các thư viện (để tận dụng Docker cache)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy toàn bộ mã nguồn và build project
COPY src ./src
RUN mvn clean package

# Stage 2: Chạy ứng dụng trên server Tomcat
FROM tomcat:9.0-jdk17
WORKDIR /usr/local/tomcat

# Xóa các ứng dụng mặc định của Tomcat để tránh xung đột
RUN rm -rf webapps/*

# Copy file WAR từ bước build sang thư mục webapps của Tomcat
# Đổi tên thành ROOT.war để ứng dụng chạy ở đường dẫn gốc (/) thay vì /CH07ListMusic/
COPY --from=build /app/target/CH07ListMusic.war webapps/ROOT.war

# Khai báo port 8080 cho Tomcat
EXPOSE 8080

# Chạy Tomcat
CMD ["catalina.sh", "run"]
