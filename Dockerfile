# build stage
FROM amazoncorretto:17 AS build
COPY ./ /home/app
WORKDIR /home/app
RUN chmod +x ./gradlew

RUN ./gradlew build

# final stage
FROM amazoncorretto:17-alpine
COPY --from=build /home/app/build/libs/bulletinboard-0.0.1-SNAPSHOT.jar /usr/local/lib/bulletinboard.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "-Dfile.encoding=UTF-8", "/usr/local/lib/bulletinboard.jar"]
