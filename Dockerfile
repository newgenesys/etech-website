# GlassFish 3.1.2 and spring boot guide jar to war deployment
#
# VERSION 0.1
# DOCKER-VERSION 1.0.0

FROM ubuntu:22.04
FROM java:8-jdk-alpine
#FROM dockerfile/java


#RUN apt-get update -qq
#RUN apt-get install -qq maven git

# COPY etech-website /

WORKDIR /
COPY target/etech-website-0.0.1-SNAPSHOT.war .
#Downloading and unpacking GlassFish 312
COPY glassfish-3.1.2.2.zip .
#RUN wget http://download.java.net/glassfish/3.1.2.2/release/glassfish-3.1.2.2.zip
RUN unzip glassfish-3.1.2.2.zip
RUN rm -f glassfish-3.1.2.2.zip
ENV PATH /glassfish3/glassfish/bin:$PATH
# RUN git clone https://github.com/spring-guides/gs-convert-jar-to-war-maven
#Package the war file
# WORKDIR /etech-website

# RUN ./mvnw clean package

RUN cp /etech-website-0.0.1-SNAPSHOT.war /glassfish3/glassfish/domains/domain1/autodeploy

EXPOSE 8080 4848 8181
WORKDIR /glassfish3/glassfish/domains/domain1/logs
