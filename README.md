## Java Classes for testing the MySQL server connection and executing some queries.

### Environment
* OS: Ubuntu 20.04 (WSL2)
* Java: openjdk 11.0.7 2020-04-14
* JDBC driver: mysql-connector-java-8.0.20

### Usage
##### Clone
```
git clone git@github.com:HayataSato/java-mysql-test.git mySqlTest
```

##### Create gradle project
```
gradle init
```

##### Modify .env
* Rename ".env.example" file to ".env"
* Add environment-variables to .env

##### Create db
```
mysql -u DB_USER -p
source ./sql/testdb.sql
```

##### Build & Run
```
gradle build
gradle run
```