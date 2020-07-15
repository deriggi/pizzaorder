# A Pizza order spring boot application
This application models a customer and pizza order system. 

## Startup
Run App.java to start the application

## Data Population 
On startup, data is populated into a local MySql database with the [Data Populator](src/main/java/com/sidecar/DataPopulator.java)

This class creates a user with username ```sidecar``` and ```password``` for the password. A  pizza order is created for the user

## Endpoints

```/authenticate``` is a ```POST``` request taking a username and password, returning a jwt token on success

```/pizzaorders``` is a ```GET``` request that takes a username and returns that user's pizza orders

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

To Create a pizza order, there is a simple service that takes a list of toppings and a username like
as a ```POST``` request to ```/pizzaorders``` :
```
{
  "toppings": [
    "string"
  ],
  "username": "string"
}
```
 

## Swagger
When running locally, Swagger UI is available at 
```http://localhost8080/swagger-ui.html``` 
