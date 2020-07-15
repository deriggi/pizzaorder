# A Pizza order spring boot application

## Startup
Run App.java to start the application

## Data Population 
On startup, data is populated into a local MySql database with the [Data Populator](src/main/java/com/sidecar/DataPopulator.java)

This class creates a user with username sidecar and a pizza order for the user

## Endpoints

```/authenticate``` is a POST request taking a username and password, returning a jwt token on success

```/pizzaorders``` is a GET request that takes a username and returns that user's pizza orders