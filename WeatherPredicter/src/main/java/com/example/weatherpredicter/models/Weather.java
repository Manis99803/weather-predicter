package com.example.weatherpredicter.models;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class Weather {
	private String apiKey = <open_weather_api>;
	
	public String getParamsString(Map<String, String> params) throws UnsupportedEncodingException{
		/*
		 * Builds the URL string
		 * Example:
		 * 	lat=12.12&lon=77.0
		 */
        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, String> entry : params.entrySet()) {
          result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
          result.append("=");
          result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
          result.append("&");
        }
 
        String resultString = result.toString();
        return resultString.length() > 0
          ? resultString.substring(0, resultString.length() - 1)
          : resultString;
	}
	
	public CityWeather getWeatherDetails(String cityName) {
		/*
		 * Fetches weather details from openweather api
		 */
		try {
			
			LatLongFetcher latLongFetcher = new LatLongFetcher();
			City city = latLongFetcher.getLatLong(cityName);
			
			
			Map<String, String> parameters = new HashMap<>();
			parameters.put("lat", Double.toString(city.getLatitude()));
			parameters.put("lon", Double.toString(city.getLongitude()));
			parameters.put("appid", this.apiKey);
	
			
			URL url = new URL("https://api.openweathermap.org/data/2.5/weather?" + this.getParamsString(parameters));
			HttpURLConnection con = (HttpURLConnection) url.openConnection();			
			
			con.setDoOutput(true);
			con.setRequestProperty("Content-Type", "application/json");
			
			try (BufferedReader in = new BufferedReader(
	                new InputStreamReader(con.getInputStream()))) {
	
	            StringBuilder response = new StringBuilder();
	            String line;
	
	            while ((line = in.readLine()) != null) {
	                response.append(line);
	            }
	            
	            JSONObject jsonObject = new JSONObject(response.toString());
	            
	            JSONObject weatherDetail = jsonObject.getJSONArray("weather").getJSONObject(0);
	            
	            return new CityWeather(weatherDetail.getString("icon"), weatherDetail.getString("description"), weatherDetail.getString("main"),
	            		(int) weatherDetail.get("id"), cityName);
			} 

		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return new CityWeather();
	}
}
