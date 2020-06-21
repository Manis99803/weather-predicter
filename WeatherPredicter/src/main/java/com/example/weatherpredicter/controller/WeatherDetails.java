/*
 * Returns weather details of a given place
 */
package com.example.weatherpredicter.controller;
import com.example.weatherpredicter.models.City;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.example.weatherpredicter.models.Weather;
import com.example.weatherpredicter.models.CityWeather;

@RestController
@RequestMapping("/api")
public class WeatherDetails {
	
	/*
	 * API which returns the weather details at a given place
	 * 
	 * Example: 
	 * Request : http://localhost:8080/api/weather-detail?cityName=Bengaluru
	 * Response : JSON 
	 * {
	 * 	"cityName" : "Bengaluru",
	 * 	"main" : "Cloud",
	 * 	"description" : "light rain",
	 *  "icon" : 10n,
	 *  "id" : 500
	 * }
	 * The weather details are fetched using the openweather api
	 * 
	 * 
	 */
	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/weather-detail")
	public @ResponseBody ResponseEntity<CityWeather> get(@RequestParam(required=true) String cityName) {
		try {
			Weather weather = new Weather();
//			City city = weather.getWeatherDetails(cityName);
			
			return new ResponseEntity<CityWeather>(weather.getWeatherDetails(cityName), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
