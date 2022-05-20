package com.cg.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="AirPollutionData")
public class AirPollution {
	//Attributes
	private String country;
	private String state;
	private String city;
	@Id
	private int postCode;
	private int aqi;
	private float pm25;
	private float pm10;
	private float no2;
	private float o3;
	
	//default constructor 
	public AirPollution() {
		super();
	}
    
	//parameterized constructor
	public AirPollution(String country, String state, String city, int postCode, int aqi, float pm25, float pm10,
			float no2, float o3) {
		super();
		this.country = country;
		this.state = state;
		this.city = city;
		this.postCode = postCode;
		this.aqi = aqi;
		this.pm25 = pm25;
		this.pm10 = pm10;
		this.no2 = no2;
		this.o3 = o3;
	}

	//get country
	public String getCountry() {
		return country;
	}

//	public void setCountry(String country) {
//		this.country = country;
//	}
//  
	//get state
	public String getState() {
		return state;
	}
//
//	public void setState(String state) {
//		this.state = state;
//	}

	//get city
	public String getCity() {
		return city;
	}

//	public void setCity(String city) {
//		this.city = city;
//	}
//
//	public int getPostCode() {
//		return postCode;
//	}
//
//	public void setPostCode(int postCode) {
//		this.postCode = postCode;
//	}
//
//	public int getAqi() {
//		return aqi;
//	}
//
//	public void setAqi(int aqi) {
//		this.aqi = aqi;
//	}
//
//	public float getPm25() {
//		return pm25;
//	}
//
//	public void setPm25(float pm25) {
//		this.pm25 = pm25;
//	}
//
//	public float getPm10() {
//		return pm10;
//	}
//
//	public void setPm10(float pm10) {
//		this.pm10 = pm10;
//	}
//
//	public float getNo2() {
//		return no2;
//	}
//
//	public void setNo2(float no2) {
//		this.no2 = no2;
//	}
//
//	public float getO3() {
//		return o3;
//	}
//
//	public void setO3(float o3) {
//		this.o3 = o3;
//	}
//
//	@Override
//	public String toString() {
//		return "AirPollution [country=" + country + ", state=" + state + ", city=" + city + ", postCode=" + postCode
//				+ ", aqi=" + aqi + ", pm25=" + pm25 + ", pm10=" + pm10 + ", no2=" + no2 + ", o3=" + o3 + "]";
//	}
//	
//	

}
