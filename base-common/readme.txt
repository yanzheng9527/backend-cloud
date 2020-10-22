#更新数据库命令
mvn clean package -Dmaven.test.skip
mvn liquibase:update