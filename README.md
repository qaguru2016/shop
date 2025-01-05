# shop
## Setup
* Install MySQL Server and Workbench
## Create a new user in MySQL
Execute the following in MySQL WorkBench
*  CREATE USER 'auto'@'localhost' IDENTIFIED BY 'auto123';
*  GRANT ALL PRIVILEGES ON *.* TO 'auto'@'localhost' WITH GRANT OPTION;
*  FLUSH PRIVILEGES;
## Create DB MySQL
Execute the following in MySQL WorkBench
* CREATE DATABASE shop;
### Update the root password in file
* src/main/resources/application.properties

## How to build fat jar file
mvn package
## How to execute the app
* option1 - java -jar shop.jar
* option2 - Double click the jar file
## How to kill the server
* Find the process id by - ps -ef | grep java
* Kill the process with - kill -9 <id>
* In Window, kill javaw.exe from task manager

## Product Endpoints
* POST "/api/v1/products/" - Save a new product
* PUT  "/api/v1/products/" - Update a product
* GET "/api/v1/products/" - Find all products
* GET "/api/v1/products/{id}" - Find a product
* DELETE "/api/v1/products/{id}" - Delete a product

## How to query data based on UUID
select * from product where id = UNHEX('d84643a93b7f4752a189df7b03126b75');

[![CircleCI](https://circleci.com/gh/pradeepparambil/shop.svg?style=svg)](https://circleci.com/gh/pradeepparambil/shop)




