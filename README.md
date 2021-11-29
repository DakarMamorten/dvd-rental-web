# dvd-rental-web

## Overview
The following repo contains code for Web application.

## Database
In general, we use PostgreSQL database. We should create database with name `dvd-rental-web`

1. Create database
```postgresql
CREATE DATABASE "dvd-rental-web";
```
2. Execute Flyway to migrate our database:
```shell
mvn flyway:migrate
```
