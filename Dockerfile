# GlassFish 3.1.2 and spring boot guide jar to war deployment
#
# VERSION 0.1
# DOCKER-VERSION 1.0.0

# FROM ubuntu:22.04
FROM java:8-jdk-alpine
#FROM dockerfile/java

ARG PORT=8989
ARG ADMIN_PORT1=4848
ARG ADMIN_PORT2=8181

#RUN apt-get update -qq
#RUN apt-get install -qq maven git

# COPY etech-website /

WORKDIR /

COPY start.sh .

CMD cmod 777 /start.sh

COPY target/etech-website-0.0.1-SNAPSHOT.war .
#Downloading and unpacking GlassFish 312
#COPY glassfish-3.1.2.2.zip .
# COPY glassfish-5.0.1.zip .
RUN wget http://download.java.net/glassfish/5.0.1/release/glassfish-5.0.1.zip
RUN unzip glassfish-5.0.1.zip
RUN rm -f glassfish-5.0.1.zip
ENV PATH /glassfish5/glassfish/bin:$PATH
# RUN git clone https://github.com/spring-guides/gs-convert-jar-to-war-maven
#Package the war file
# WORKDIR /etech-website

# RUN ./mvnw clean package

RUN cp /etech-website-0.0.1-SNAPSHOT.war /glassfish5/glassfish/domains/domain1/autodeploy


EXPOSE ${PORT} ${ADMIN_PORT1} ${ADMIN_PORT2}

ENTRYPOINT ["/start.sh"]

WORKDIR /glassfish5/glassfish/domains/domain1/logs
