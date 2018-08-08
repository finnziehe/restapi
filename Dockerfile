FROM tomcat:latest

RUN apt-get -y update && apt-get -y upgrade
RUN apt-get -y install net-tools sudo vim software-properties-common 
RUN  apt-get install -y  mariadb-server rsync 
RUN apt-get -y install default-jre
RUN apt-get -y install default-jdk
RUN apt-get -y update && apt-get -y upgrade
COPY context.xml /usr/local/tomcat/webapps/manager/META-INF/context.xml
COPY tomcat-users.xml /usr/local/tomcat/conf/tomcat-users.xml


 
COPY ./demorest/target/demorest.war /usr/local/tomcat/webapps/
COPY start.sh /usr/local
COPY people.sql /usr/local
EXPOSE 3306:3306

ENTRYPOINT  bash /usr/local/start.sh

 





