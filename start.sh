#!/bin/sh

# /usr/local/glassfish4/bin/asadmin start-domain
/glassfish5/glassfish/bin/asadmin start-domain

# /usr/local/glassfish4/bin/asadmin create-jdbc-connection-pool --datasourceclassname=com.mysql.jdbc.jdbc2.optional.MysqlDataSource --restype=javax.sql.DataSource --property user=root:serverName=localhost:portNumber=3306:databaseName=etech_website:useSSL=false mysql_etech_website_rootPool

# /usr/local/glassfish4/bin/asadmin create-jdbc-resource --connectionpoolid mysql_etech_website_rootPool app/etech_mysql
# /usr/local/glassfish3/bin/asadmin -u admin deploy /etech-website-0.0.1-SNAPSHOT.war
/glassfish5/glassfish/bin/asadmin -u admin deploy /etech-website-0.0.1-SNAPSHOT.war
#/usr/local/glassfish3/bin/asadmin stop-domain
/glassfish5/glassfish/bin/asadmin stop-domain
cp -R /etech-website-0.0.1-SNAPSHOT.war glassfish5/domains/domain1/autodeploy/
# cp -R tmp/etech-website-0.0.1-SNAPSHOT.war /
# /usr/local/glassfish4/bin/asadmin start-domain --verbose
/glassfish5/glassfish/bin/asadmin start-domain --verbose
