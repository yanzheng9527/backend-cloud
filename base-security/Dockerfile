FROM openjdk:8u212-jre-slim
VOLUME /tmp
ADD /backend-web.jar app.jar
ADD /ssl_client.crt ssl_client.crt
RUN keytool -import -alias cas -storepass changeit -keystore "$JAVA_HOME/lib/security/cacerts" -file ssl_client.crt -storepass changeit -noprompt
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]