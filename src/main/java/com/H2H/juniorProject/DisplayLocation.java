package com.H2H.juniorProject;

import org.json.simple.JSONObject;

public class DisplayLocation {

	private String full;
	private String city;
	private String state;
	private String state_name;
	private String country;
	private String countryIso;
	private String zip;
	private String magic;
	private String wmo;
	private String latitude;
	private String longitude;
	private String elevation;
	
	public DisplayLocation(JSONObject js){
		full = (String) js.get("full");
		city = (String) js.get("city");
		state = (String) js.get("state");
		state_name = (String) js.get("state_name");
		country = (String) js.get("country");
		countryIso = (String) js.get("country_iso3166");
		zip = (String) js.get("zip");
		magic = (String) js.get("magic");
		wmo = (String) js.get("wmo");
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
	
	public String getState_name() {
		return state_name;
	}
	
	public void setState_name(String state_name) {
		this.state_name = state_name;
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
	
	public String getZip() {
		return zip;
	}
	
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	public String getMagic() {
		return magic;
	}
	
	public void setMagic(String magic) {
		this.magic = magic;
	}
	
	public String getWmo() {
		return wmo;
	}
	
	public void setWmo(String wmo) {
		this.wmo = wmo;
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
		return "DisplayLocation [full=" + full + ", city=" + city + ", state=" + state + ", state_name=" + state_name
				+ ", country=" + country + ", countryIso=" + countryIso + ", zip=" + zip + ", magic=" + magic + ", wmo="
				+ wmo + ", latitude=" + latitude + ", longitude=" + longitude + ", elevation=" + elevation + "]";
	}
	

}
