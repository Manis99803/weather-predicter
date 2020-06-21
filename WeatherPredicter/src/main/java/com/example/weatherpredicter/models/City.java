package com.example.weatherpredicter.models;

public class City {
	/*
	 * City class having cityName, latitude and longitude as a member 
	 */
	String cityName;
	
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	Double longitude;
	Double latitude;
	
	City(String cityName, Double longitude, Double latitude){
		this.cityName = cityName;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	City(){}
	
}
