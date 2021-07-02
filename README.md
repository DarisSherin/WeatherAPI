1.Task
This project is an REST API developed in Java using Spring boot.
This project retrieves data from https://openweathermap.org/api 

1.1 Retrieve Weather details
/weather returns the weather details like city’s local current temperature of the entered city name along with user local time.
Cache is used to clear the response every 24Hours

{
  "weather": [
    {
      "id": 804,
      "description": "overcast clouds",
      "icon": "04d"
    }
  ],
  "name": "London",
  "cod": 200,
  "main": {
    "temp": 287.72,
    "pressure": 1017,
    "humidity": 88,
    "temp_min": 284.69,
    "temp_max": 289.25
  },
  "wind": {
    "speed": 1.03,
    "deg": 0
  },
  "date": "2021-07-02 10:24:18.166"
}

1.2 Retrieve time difference between user local time and city local time
/time returns the time difference between user local time and city local time

{
  "lat": 33.44,
  "lon": -94.04,
  "timezone": "America/Chicago",
  "userTime": "2021-07-02 12:20:07.136",
  "cityTime": "2021-07-02 01:50:07.136",
  "time_difference": 37800000,
  "days_difference": 0,
  "hours_difference": 10,
  "minutes_difference": 30,
  "seconds_difference": 0
}

1.3 Save retrieve weather details and expose latest searches
/weather/lastsearches returns last 3 search performed in the application t retrieve weather details

[
  {
    "name": "Berlin",
    "cod": 200,
    "temp": 291.12,
    "pressure": 1011,
    "humidity": 90,
    "temp_min": 289.26,
    "temp_max": 292.53,
    "searchTimestamp": null
  },
  {
    "name": "London",
    "cod": 200,
    "temp": 289.53,
    "pressure": 1016,
    "humidity": 86,
    "temp_min": 287.11,
    "temp_max": 291.01,
    "searchTimestamp": null
  },
  {
    "name": "Chennai",
    "cod": 200,
    "temp": 308.14,
    "pressure": 1005,
    "humidity": 55,
    "temp_min": 308.14,
    "temp_max": 308.14,
    "searchTimestamp": null
  }

________________________________________

2. Technical Details:

2.1 Tools&Framework:
The below are the list of tools and framework used in the project!
•	SpringBoot - The framework used
•	Maven - for Dependency Management
•	Java - Java 8 as Programming language

2.2 Key Features to highlight:
1.Implemented cache to clear the stored response.
2.Added swagger implementation to document the REST endpoints
3.Junit test cases for both controller and service class 

2.3 Solution & Assumptions
1.	/weather api retrieves weather details for the given query param q and preserves in local cache for 24 hours(configurable), once after 24 hours the data gets cleared.
2.	/time api retrieves timezone of the requested city for the given query param lat and lon and calculates the time difference between user local time and city local time. 
3.	/weather/lastsearches api retrieves last search done in /weather api. This end point uses in memory database h2 for storing the searches done in /weather api. This is a additional task which is accomplished.
________________________________________

3.Swagger
If this application is being accessed locally, then swagger UI can be accessed at
http://localhost:8080/swagger-ui.html#/
________________________________________

4.Run Application
If the application has to be run locally, then below command is executed	
mvn spring-boot:run -Dspring-boot.run.arguments="--weather.api.key={{VALUE}}"
default user id is user default password is password
