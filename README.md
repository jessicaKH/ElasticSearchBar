This project is a full-stack application that allows users to search for job offers using a search bar with fuzzy search and autocomplete functionality. The backend is built with Spring Boot, which connects to an Elasticsearch service and a PostgreSQL database. The frontend is developed using Angular.

## Prerequisites
Before you begin, ensure you have the following installed:

Java 17
Node.js & npm
PostgreSQL
Elasticsearch 7.10+
Angular CLI

## Getting the project up and running

# Step 1: ElasticSearch configuration

Download ElasticSearch for free from the [official website](https://www.elastic.co/fr/downloads/past-releases/elasticsearch-7-10-0).
Start ElasticSearch by running the following command in a terminal :
```./bin/elasticsearch```
Elasticsearch should now be running on http://localhost:9200.

# Step 2: Set up a database with a table and insert your data
Create your database using PostGreSQL.
```CREATE DATABASE job_offers;```

Create a table in the database.
``` CREATE TABLE job_offers (
    id INT PRIMARY KEY,
    expiration_date DATE,
    is_active BOOLEAN,
    job_description TEXT,
    locality VARCHAR(255),
    required_skills TEXT,
    title VARCHAR(255),
    company_desc TEXT,
    postal_code VARCHAR(10),
    region VARCHAR(255),
    city VARCHAR(255),
    manager_id INT
);
```
After setting up the table, you can insert your data!

# Step 3: running the backend Spring Boot application
Navigate to the backend directory at ```./elasticsearchengine``` in a terminal.

Set your PostgreSQL and Elasticsearch configurations:
```spring.datasource.url=jdbc:postgresql://localhost:5432/job_search
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password

spring.elasticsearch.rest.uris=http://localhost:9200
```

You can then build and run the backend : 

```mvn clean install
mvn spring-boot:run
```

# Step 4: running the frontend Angular application
Navigate to the frontend directory at ```./elasticfront``` in a new terminal.

Install the dependencies :

```npm install```

Run the frontend : 

```ng serve```

# Step 5: access the application 
Open your browser and navigate to http://localhost:4200. You can use the search bar to search for job offers. The search functionality supports fuzzy search and autocomplete.

# Debugging

- Elasticsearch logs are available in the Elasticsearch installation directory.
- Spring Boot logs can be viewed in the terminal where the application is running.
- Angular logs can be viewed in the browser's developer console or terminal.


This project is a good starting point, but don’t hesitate to customize it to fit your needs. Whether you want to add new features, tweak the design, or improve the functionality, go ahead and make it your own :)

If you run into any issues, have questions, or just want to chat about the project, please feel free to reach out. I’m always happy to help and would love to hear your thoughts and feedback!


