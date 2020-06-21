package com.example.weatherpredicter.models;

public class CityWeather {

	/*
	 * City weather Details
	 */
	private String cityName;
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getMain() {
		return main;
	}
	public void setMain(String main) {
		this.main = main;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	private String main;
	private String description;
	private Integer id;
	private String icon;
	
	public CityWeather(String icon,   String description, String main, Integer id, String cityName){
		this.icon = icon;
		this.description  = description;
		this.main = main;
		this.id = id;
		this.cityName = cityName;
			
	}
	
	public CityWeather(){}
}
