FROM openjdk:17

VOLUME /tmp

COPY target/factory-pattern-demo2-1.0.0.jar factory-pattern-demo2.jar

EXPOSE 7785

ENTRYPOINT ["java", "-jar", "factory-pattern-demo2.jar"]