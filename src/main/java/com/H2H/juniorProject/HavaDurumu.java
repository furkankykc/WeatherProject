package com.H2H.juniorProject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class HavaDurumu {
// api key 50413050ddf06cd5

private CurrentObservation currentObservation;
private Response response;
private Boolean result=true;
	public HavaDurumu (String sehir) {
	
//		String	path2 = "http://api.wunderground.com/api/50413050ddf06cd5/conditions/q/CA/"+sehir+".json";
		String pathString ="http://api.wunderground.com/api/50413050ddf06cd5/conditions/q/CA/"+sehir+".json";
		String aa = 	 	"http://api.wunderground.com/api/50413050ddf06cd5/conditions/q/CA/San_Francisco.json";
				 try {    
		
			URL path2 = new URL(pathString);
			System.out.println(path2.getPath());
			HttpURLConnection weather_url_con = (HttpURLConnection) path2.openConnection();
            InputStreamReader inputStreamReader = new InputStreamReader(weather_url_con.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(bufferedReader);
			response = new Response((JSONObject)jsonObject.get("response"));
			currentObservation = new CurrentObservation((JSONObject)jsonObject.get("current_observation"));
			

		}catch (ParseException ex) {
			ex.printStackTrace();
			result = false;
		} catch (NullPointerException ex) {
			ex.printStackTrace();
			result = false;
		} catch (IOException ex) {
			ex.printStackTrace();
			result = false;
		}
	
	}

	public CurrentObservation getCurrentObservation() {
		return currentObservation;
	}

	public void setCurrentObservation(CurrentObservation current_observation) {
		this.currentObservation = current_observation;
	}

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

	public Boolean getResult() {
		return result;
	}

	public void setResult(Boolean result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "HavaDurumu [current_observation=" + currentObservation + ", response=" + response + "]";
	}



}
