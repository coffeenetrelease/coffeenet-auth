FROM frolvlad/alpine-oraclejdk8:slim

EXPOSE 9999

VOLUME /tmp
ADD /maven/${docker.finalName}.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]

