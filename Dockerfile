FROM frolvlad/alpine-oraclejdk8:slim
MAINTAINER xiunai78 <154707516@qq.com>
 
# Add the service itself
ARG JAR_FILE
ADD ${JAR_FILE} /usr/local/adminapi/myapp.jar
 
EXPOSE 8080
 
ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/local/adminapi/myapp.jar"]