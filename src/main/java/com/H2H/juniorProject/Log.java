package com.H2H.juniorProject;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Log {

	private int id;
	private int userId;
	private int locationId;
	private Timestamp time;
	private String ip;
	private long queryTime;
	private Boolean resultStatus;
	private String timeString;
	public Log(){
		this.userId = 0;
		this.locationId = 0;
		this.time = null;
		this.ip = "";
		this.queryTime = 0;
		this.resultStatus = null;
	}

	public Log(int id,int userId, int locationId, Timestamp time, String ip, long queryTime, Boolean resultStatus) {
		this.id = id;
		this.userId = userId;
		this.locationId = locationId;
		this.time = time;
		this.ip = ip;
		this.queryTime = queryTime;
		this.resultStatus = resultStatus;
	}
	public Log(int userId, int locationId, Timestamp time, String ip, long queryTime, Boolean resultStatus) {

		this.userId = userId;
		this.locationId = locationId;
		this.time = time;
		this.ip = ip;
		this.queryTime = queryTime;
		this.resultStatus = resultStatus;
	}
	public Log(int userId,int locationId,String timeString){
		this.userId = userId;
		this.locationId = locationId;
		this.timeString = timeString;
		this.time =stringToTimeStamp(timeString);
	}
public Timestamp stringToTimeStamp(String string){
	
	 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    java.util.Date parsedDate = null;
		try {
			parsedDate = dateFormat.parse(string);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(parsedDate!=null)
			return new java.sql.Timestamp(parsedDate.getTime());
	    return null;
}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public Timestamp getTime() {
		if(time==null && timeString!=null && timeString!="") time = stringToTimeStamp(timeString);
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public long getQueryTime() {
		return queryTime;
	}

	public void setQueryTime(long queryTime) {
		this.queryTime = queryTime;
	}

	public Boolean getResultStatus() {
		return resultStatus;
	}

	public void setResultStatus(Boolean resultStatus) {
		this.resultStatus = resultStatus;
	}

	public String getTimeString() {
		return timeString;
	}

	public void setTimeString(String timeString) {
		this.timeString = timeString;
	}

	@Override
	public String toString() {
		return "Log [userId=" + userId + ", locationId=" + locationId + ", time=" + time + ", ip=" + ip + ", queryTime="
				+ queryTime + ", resultStatus=" + resultStatus + "]";
	}
	
	
}
