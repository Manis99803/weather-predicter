/*
 * Returns the latitude and longitude of a given place
 */
package com.example.weatherpredicter.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.HttpStatus;
import com.example.weatherpredicter.models.LatLongFetcher;
import com.example.weatherpredicter.models.City;

@RestController
@RequestMapping("/api")
public class Location {

	/*
	 * Returns the latitude and longitude of a given place
	 * Example: 
	 * Request : http://localhost:8080/api/lat-lon?cityName=Bengaluru
	 * Response : JSON 
	 * {
	 * 	"cityName" : "Bengaluru",
	 * 	"longitude" : 77.32,
	 * 	"latitude": 15.90,
	 * }
	 * 
	 * The latitude and longitude details are fetched from mapbox api.
	 */
	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/lat-lon")
	public @ResponseBody ResponseEntity<City> get(@RequestParam(required=true) String cityName) {
		try {
			LatLongFetcher latLongFetcher = new LatLongFetcher();
			City city = latLongFetcher.getLatLong(cityName);
			if (city.getCityName().equals((String)"Invalid")) {
				return new ResponseEntity<City>(city, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<City>(city, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
