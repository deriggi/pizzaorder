# A Pizza order spring boot application
This application models a customer and pizza order system. 

## Startup
Run App.java to start the application

## Data Population 
On startup, data is populated into a local MySql database with the [Data Populator](src/main/java/com/sidecar/DataPopulator.java)

This class creates a user with username sidecar and a pizza order for the user

## Endpoints

```/authenticate``` is a POST request taking a username and password, returning a jwt token on success

```/pizzaorders``` is a GET request that takes a username and returns that user's pizza orders

A response from the pizza orders request will look like this:

```{
        "pizza": [
            {
                "toppings": [
                    {
                        "name": "anchovy"
                    }
                ]
            }
        ],
        "createdAt": 1594826772000
    }
```