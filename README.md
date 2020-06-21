# weather-predicter

Weather Predicter App helps the user get the coordinates of a given location. Besides, this it also helps in fetching the weather details at a given place. To do so user will have to input the location names at the appropriate places in the UI.
The UI is developed using JavaScript, Jquery, Ajax, HTML and CSS. Ajax is used in the frontend to make a request to the server for fetching data like latitude, longitude and weather details.
The app is build following the REST paradigm.

## Two apis are defined:
### 1. /api/lat-lon
  * Helpsingettingthelatitudeandlongitudeofagivenplace b. Ex:
    * http://localhost:8080/api/lat-lon?cityName=Bengaluru
    * Method: GET
    * Response: {“cityName”: “Bengaluru”, “latitude”:’12.23, “longitude”:77.45}
    * HTTP status code: 200, 400
  * Depending on the input the api might return one or more
response
    * In case of having multiple entries in the response. The
       coordinates of first city present in the array is taken
    * In case of having zero entry in the response. User is asked
        to re-enter the city name.
  
### 2. /api/weather-detail
  * Helpsingettingthedetailsabouttheweatheratagivenplace b. Ex:
    * http://localhost:8080/api/weather- detail?cityName=Bengaluru
    * Method: GET
    * Response: {"cityName": "Bengaluru", "main": "Cloud",
        "description": "light rain","icon": 10n,"id": 500}
    * HTTP status code: 200, 400

Apache Tomcat server 9.0 version is used ans the same is setup in the Eclipse IDE as well.

To run this application, following API are required:
### 1. MapBox
 * To get latitude and longitude of a place
### 2. OpenWeather
 * To get weather details for a particular place
