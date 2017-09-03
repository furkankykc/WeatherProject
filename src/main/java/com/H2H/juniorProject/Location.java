package com.H2H.juniorProject;

public class Location {
	
	private int id;
	private String locationName;
	
	public Location(String locationName){
		this.locationName = locationName;
	}
	public Location(){}
	
	public Location(int id,String locationName){
		this(locationName);
		this.id = id;
		
	}
	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", locationName=" + locationName + "]";
	}
	
}

