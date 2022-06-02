FROM adoptopenjdk/openjdk11:latest AS base
ENV LANG C.UTF-8
WORKDIR /app

ADD target/biodiesel-third-washer-0.0.1-SNAPSHOT.jar app.jar

FROM adoptopenjdk/maven-openjdk AS build
WORKDIR /src
COPY ./ /src

RUN mvn -f /src/pom.xml clean install -U skipTests -DexcludedGroups="integration"

RUN rm -f /src/target/*soucers.jar
RUN ls -lah /src/target
RUN cp -a /src/target/biodiesel-third-washer*.jar /app.jar

FROM base as final

CMD java -jar /app/app.jar