package com.H2H.juniorProject;

import org.json.simple.JSONObject;

public class Response {
private String version;
private String termsOfService;
private JSONObject features;
private Long conditions;

public Response(JSONObject js){
	version = (String) js.get("version");
	termsOfService = (String) js.get("termsOfService");
	features = (JSONObject) js.get("features");
	conditions = (Long) features.get("conditions");
}


public String getVersion() {
	return version;
}


public void setVersion(String version) {
	this.version = version;
}


public String getTermsOfService() {
	return termsOfService;
}


public void setTermsOfService(String termsOfService) {
	this.termsOfService = termsOfService;
}


public JSONObject getFeatures() {
	return features;
}


public void setFeatures(JSONObject features) {
	this.features = features;
}


public Long getConditions() {
	return conditions;
}


public void setConditions(Long conditions) {
	this.conditions = conditions;
}


@Override
public String toString() {
	return "Response [version=" + version + ", termsOfService=" + termsOfService + ", features=" + features
			+ ", conditions=" + conditions + "]";
}

}
