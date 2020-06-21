package com.example.weatherpredicter.models;


import java.net.URL;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.json.*;


public class LatLongFetcher {
	
	/*
	 * Fetched latitude and longitude of a given place using the mapbox api
	 */
	private String accessToken = <mapbox_api>
	
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
	
	
	public City getLatLong(String cityName){
		/*
		 * Fetches the latitude and longitude from mapbox using the URL encoder and http client class.
		 */
		
		try {
			
			Map<String, String> parameters = new HashMap<>();
			parameters.put("access_token", this.accessToken);
//			parameters.put("limit", "1");
			
			URL url = new URL("https://api.mapbox.com/geocoding/v5/mapbox.places/" + cityName + ".json?" + this.getParamsString(parameters));
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
	            
	            JSONArray jsonArray = jsonObject.getJSONArray("features");
	            
	            if(jsonObject.getJSONArray("features").length() > 0) {
		            
		            for (int i = 0; i < jsonArray.length(); i++) {
		                JSONObject featureJSON = jsonArray.getJSONObject(i);
		                JSONArray coordinateArray = featureJSON.getJSONArray("center");
		                City city = new City(cityName, (Double) coordinateArray.get(0), (Double) coordinateArray.get(1));
		                return city;
		            }
	            } else {
	            	return new City("Invalid", 0.0, 0.0);
	            }
			} 

		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return new City();
	}
	
}
