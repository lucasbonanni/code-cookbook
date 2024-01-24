FROM amazoncorretto:17-alpine

# RUN addgroup --system app
# RUN adduser --system app --ingroup app

EXPOSE 8080:8080
RUN mkdir /app
WORKDIR /app
COPY ./build/libs/fat.jar /app/fat.jar
ENTRYPOINT ["java","-jar","/app/fat.jar"]
