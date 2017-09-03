package com.H2H.juniorProject;

import org.json.simple.JSONObject;

public class ObservationLocation {

	private String full;
	private String city;
	private String state;
	private String country;
	private String countryIso;
	private String latitude;
	private String longitude;
	private String elevation;
	
	public ObservationLocation(JSONObject js){
		full = (String) js.get("full");
		city = (String) js.get("city");
		state = (String) js.get("state");
		country = (String) js.get("country");
		countryIso = (String) js.get("country_iso3166");
		latitude = (String) js.get("latitude");
		longitude = (String) js.get("longitude");
		elevation = (String) js.get("elevation");
	}

	public String getFull() {
		return full;
	}

	public void setFull(String full) {
		this.full = full;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountryIso() {
		return countryIso;
	}

	public void setCountryIso(String countryIso) {
		this.countryIso = countryIso;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getElevation() {
		return elevation;
	}

	public void setElevation(String elevation) {
		this.elevation = elevation;
	}

	@Override
	public String toString() {
		return "ObservationLocation [full=" + full + ", city=" + city + ", state=" + state + ", country=" + country
				+ ", countryIso=" + countryIso + ", latitude=" + latitude + ", longitude=" + longitude + ", elevation="
				+ elevation + "]";
	}
	
	
}
