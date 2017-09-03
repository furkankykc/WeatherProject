package com.H2H.juniorProject;

import org.json.simple.JSONObject;

public class CurrentObservation {

	private DisplayLocation displayLocation;
	private ObservationLocation observationLocation;
	private String station_id;
	private String observationTime;
	private String observationTimeRfc;
	private String observationEpoch;
	private String localTimeRfc;
	private String localEpoch;
	private String localTzShort;
	private String localTzLong;
	private String localTzOffset;
	private String weather;
	private String temperatureString;
	private Double tempF;
	private Double tempC;
	private String relativeHumidity;
	private String windString;
	private String windDir;
	private Long windDegrees;
	private Double windMph;
	private Object windGustMph;
	private Object windKph;
	private Object windGustKph;
	private String pressureMb;
	private String pressureIn;
	private String pressureTrend;
	private String dewPointString;
	private Long dewPointF;
	private Long dewPointC;
	private String heatIndexString;
	private Object heatIndexF;
	private Object heatIndexC;
	private String windchillString;
	private String windchillF;
	private String windchillC;
	private String feelslikeString;
	private String feelslikeF;
	private String feelslikeC;
	private String visibilityMi;
	private String visibilityKm;
	private String solarRadiation;
	private String uv;
	private String precip1hrString;
	private String precip1hrIn;
	private String precip1hrMetric;
	private String precipTodayString;
	private String precipTodayIn;
	private String precipTodayMetric;
	private String icon;
	private String iconUrl;
	private String forecastUrl;
	private String historyUrl;
	private String obUrl;
	private String nowcast;
	
	public CurrentObservation(JSONObject js) {
		//if(js==null) return;
		//System.out.println(js.toJSONString());
		displayLocation = new DisplayLocation((JSONObject)js.get("display_location"));
		observationLocation = new ObservationLocation((JSONObject) js.get("observation_location"));
		station_id = (String) js.get("station_id");
		observationTime = (String) js.get("observation_time");
		observationTimeRfc = (String) js.get("observation_time_rfc822");
		observationEpoch = (String) js.get("observation_epoch");
		localTimeRfc = (String) js.get("local_time_rfc822");
		localEpoch = (String) js.get("local_epoch");
		localTzShort = (String) js.get("local_tz_short");
		localTzLong = (String) js.get("local_tz_long");
		localTzOffset = (String) js.get("local_tz_offset");
		weather = (String) js.get("weather");
		temperatureString = (String) js.get("temperature_string");
		tempF = (Double) js.get("temp_f");
		tempC = (Double) js.get("temp_c");
		relativeHumidity = (String) js.get("relative_humidity");
		windString = (String) js.get("wind_string");
		windDir = (String) js.get("wind_dir");
		windDegrees = (Long) js.get("wind_degrees");
		windMph = (Double) js.get("wind_mph");
		windGustMph =  js.get("wind_gust_mph");
		windKph =  js.get("wind_kph");
		windGustKph =  js.get("wind_gust_kph");
		pressureMb = (String) js.get("pressure_mb");
		pressureIn = (String) js.get("pressure_in");
		pressureTrend = (String) js.get("pressure_trend");
		dewPointString = (String) js.get("dewpoint_string");
		dewPointF = (Long) js.get("dewpoint_f");
		dewPointC = (Long) js.get("dewpoint_c");
		heatIndexString = (String) js.get("heat_index_string");
		heatIndexF =  js.get("heat_index_f");
		heatIndexC =  js.get("heat_index_c");
		windchillString = (String) js.get("windchill_string");
		windchillF = (String) js.get("windchill_f");
		windchillC = (String) js.get("windchill_c");
		feelslikeString = (String) js.get("feelslike_string");
		feelslikeF = (String) js.get("feelslike_f");
		feelslikeC = (String) js.get("feelslike_c");
		visibilityMi = (String) js.get("visibility_mi");
		visibilityKm = (String) js.get("visibility_km");
		solarRadiation = (String) js.get("solarradiation");
		uv = (String) js.get("UV");
		precip1hrString = (String) js.get("precip_1hr_string");
		precip1hrIn = (String) js.get("precip_1hr_in");
		precip1hrMetric = (String) js.get("precip_1hr_metric");
		precipTodayString = (String) js.get("precip_today_string");
		precipTodayIn = (String) js.get("precip_today_in");
		precipTodayMetric = (String) js.get("precip_today_metric");
		icon = (String) js.get("icon");
		iconUrl = (String) js.get("icon_url");
		forecastUrl = (String) js.get("forecast_url");
		historyUrl = (String) js.get("history_url");
		obUrl = (String) js.get("ob_url");
		nowcast = (String) js.get("nowcast");
	}



	public ObservationLocation getObservationLocation() {
		return observationLocation;
	}

	public void setObservationLocation(ObservationLocation observation_location) {
		this.observationLocation = observation_location;
	}


	public String getStation_id() {
		return station_id;
	}

	public void setStation_id(String station_id) {
		this.station_id = station_id;
	}

	public String getObservationTime() {
		return observationTime;
	}

	public void setObservationTime(String observationTime) {
		this.observationTime = observationTime;
	}

	public String getObservationTimeRfc() {
		return observationTimeRfc;
	}

	public void setObservationTimeRfc(String observationTimeRfc) {
		this.observationTimeRfc = observationTimeRfc;
	}

	public String getObservationEpoch() {
		return observationEpoch;
	}

	public void setObservationEpoch(String observationEpoch) {
		this.observationEpoch = observationEpoch;
	}

	public String getLocalTimeRfc() {
		return localTimeRfc;
	}

	public void setLocalTimeRfc(String localTimeRfc) {
		this.localTimeRfc = localTimeRfc;
	}

	public String getLocalEpoch() {
		return localEpoch;
	}

	public void setLocalEpoch(String localEpoch) {
		this.localEpoch = localEpoch;
	}

	public String getLocalTzShort() {
		return localTzShort;
	}

	public void setLocalTzShort(String localTzShort) {
		this.localTzShort = localTzShort;
	}

	public String getLocalTzLong() {
		return localTzLong;
	}

	public void setLocalTzLong(String localTzLong) {
		this.localTzLong = localTzLong;
	}

	public String getLocalTzOffset() {
		return localTzOffset;
	}

	public void setLocalTzOffset(String localTzOffset) {
		this.localTzOffset = localTzOffset;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public String getTemperatureString() {
		return temperatureString;
	}

	public void setTemperatureString(String temperatureString) {
		this.temperatureString = temperatureString;
	}


	public String getRelativeHumidity() {
		return relativeHumidity;
	}

	public void setRelativeHumidity(String relativeHumidity) {
		this.relativeHumidity = relativeHumidity;
	}

	public String getWindString() {
		return windString;
	}

	public void setWindString(String windString) {
		this.windString = windString;
	}

	public String getWindDir() {
		return windDir;
	}

	public DisplayLocation getDisplayLocation() {
		return displayLocation;
	}

	public void setDisplayLocation(DisplayLocation displayLocation) {
		this.displayLocation = displayLocation;
	}

	public String getPressureMb() {
		return pressureMb;
	}

	public void setPressureMb(String pressureMb) {
		this.pressureMb = pressureMb;
	}

	public String getPressureIn() {
		return pressureIn;
	}

	public void setPressureIn(String pressureIn) {
		this.pressureIn = pressureIn;
	}

	public String getPressureTrend() {
		return pressureTrend;
	}

	public void setPressureTrend(String pressureTrend) {
		this.pressureTrend = pressureTrend;
	}

	public String getDewPointString() {
		return dewPointString;
	}

	public void setDewPointString(String dewPointString) {
		this.dewPointString = dewPointString;
	}

	public String getHeatIndexString() {
		return heatIndexString;
	}

	public void setHeatIndexString(String heatIndexString) {
		this.heatIndexString = heatIndexString;
	}

	public String getWindchillString() {
		return windchillString;
	}

	public void setWindchillString(String windchillString) {
		this.windchillString = windchillString;
	}

	public String getWindchillF() {
		return windchillF;
	}

	public void setWindchillF(String windchillF) {
		this.windchillF = windchillF;
	}

	public String getWindchillC() {
		return windchillC;
	}

	public void setWindchillC(String windchillC) {
		this.windchillC = windchillC;
	}

	public String getFeelslikeString() {
		return feelslikeString;
	}

	public void setFeelslikeString(String feelslikeString) {
		this.feelslikeString = feelslikeString;
	}

	public String getFeelslikeF() {
		return feelslikeF;
	}

	public void setFeelslikeF(String feelslikeF) {
		this.feelslikeF = feelslikeF;
	}

	public String getFeelslikeC() {
		return feelslikeC;
	}

	public void setFeelslikeC(String feelslikeC) {
		this.feelslikeC = feelslikeC;
	}

	public String getVisibilityMi() {
		return visibilityMi;
	}

	public void setVisibilityMi(String visibilityMi) {
		this.visibilityMi = visibilityMi;
	}

	public String getVisibilityKm() {
		return visibilityKm;
	}

	public void setVisibilityKm(String visibilityKm) {
		this.visibilityKm = visibilityKm;
	}

	public String getSolarRadiation() {
		return solarRadiation;
	}

	public void setSolarRadiation(String solarRadiation) {
		this.solarRadiation = solarRadiation;
	}

	public String getUv() {
		return uv;
	}

	public void setUv(String uv) {
		this.uv = uv;
	}

	public String getPrecip1hrString() {
		return precip1hrString;
	}

	public void setPrecip1hrString(String precip1hrString) {
		this.precip1hrString = precip1hrString;
	}

	public String getPrecip1hrIn() {
		return precip1hrIn;
	}

	public void setPrecip1hrIn(String precip1hrIn) {
		this.precip1hrIn = precip1hrIn;
	}

	public String getPrecip1hrMetric() {
		return precip1hrMetric;
	}

	public void setPrecip1hrMetric(String precip1hrMetric) {
		this.precip1hrMetric = precip1hrMetric;
	}

	public String getPrecipTodayString() {
		return precipTodayString;
	}

	public void setPrecipTodayString(String precipTodayString) {
		this.precipTodayString = precipTodayString;
	}

	public String getPrecipTodayIn() {
		return precipTodayIn;
	}

	public void setPrecipTodayIn(String precipTodayIn) {
		this.precipTodayIn = precipTodayIn;
	}

	public String getPrecipTodayMetric() {
		return precipTodayMetric;
	}

	public void setPrecipTodayMetric(String precipTodayMetric) {
		this.precipTodayMetric = precipTodayMetric;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public String getForecastUrl() {
		return forecastUrl;
	}

	public void setForecastUrl(String forecastUrl) {
		this.forecastUrl = forecastUrl;
	}

	public String getHistoryUrl() {
		return historyUrl;
	}

	public void setHistoryUrl(String historyUrl) {
		this.historyUrl = historyUrl;
	}

	public String getObUrl() {
		return obUrl;
	}

	public void setObUrl(String obUrl) {
		this.obUrl = obUrl;
	}

	public String getNowcast() {
		return nowcast;
	}

	public void setNowcast(String nowcast) {
		this.nowcast = nowcast;
	}

	public Double getTempF() {
		return tempF;
	}

	public void setTempF(Double tempF) {
		this.tempF = tempF;
	}

	public Double getTempC() {
		return tempC;
	}

	public void setTempC(Double tempC) {
		this.tempC = tempC;
	}

	public Long getWindDegrees() {
		return windDegrees;
	}

	public void setWindDegrees(Long windDegrees) {
		this.windDegrees = windDegrees;
	}

	public Double getWindMph() {
		return windMph;
	}

	public void setWindMph(Double windMph) {
		this.windMph = windMph;
	}

	public Long getDewPointF() {
		return dewPointF;
	}

	public void setDewPointF(Long dewPointF) {
		this.dewPointF = dewPointF;
	}

	public Long getDewPointC() {
		return dewPointC;
	}

	public void setDewPointC(Long dewPointC) {
		this.dewPointC = dewPointC;
	}

	public void setWindDir(String windDir) {
		this.windDir = windDir;
	}



	public Object getWindGustMph() {
		return windGustMph;
	}



	public void setWindGustMph(Object windGustMph) {
		this.windGustMph = windGustMph;
	}



	public Object getWindKph() {
		return windKph;
	}



	public void setWindKph(Object windKph) {
		this.windKph = windKph;
	}



	public Object getWindGustKph() {
		return windGustKph;
	}



	public void setWindGustKph(Object windGustKph) {
		this.windGustKph = windGustKph;
	}



	public Object getHeatIndexF() {
		return heatIndexF;
	}



	public void setHeatIndexF(Object heatIndexF) {
		this.heatIndexF = heatIndexF;
	}



	public Object getHeatIndexC() {
		return heatIndexC;
	}



	public void setHeatIndexC(Object heatIndexC) {
		this.heatIndexC = heatIndexC;
	}



	@Override
	public String toString() {
		return "CurrentObservation [displayLocation=" + displayLocation + ", observationLocation=" + observationLocation
				+ ", station_id=" + station_id + ", observationTime=" + observationTime + ", observationTimeRfc="
				+ observationTimeRfc + ", observationEpoch=" + observationEpoch + ", localTimeRfc=" + localTimeRfc
				+ ", localEpoch=" + localEpoch + ", localTzShort=" + localTzShort + ", localTzLong=" + localTzLong
				+ ", localTzOffset=" + localTzOffset + ", weather=" + weather + ", temperatureString="
				+ temperatureString + ", tempF=" + tempF + ", tempC=" + tempC + ", relativeHumidity=" + relativeHumidity
				+ ", windString=" + windString + ", windDir=" + windDir + ", windDegrees=" + windDegrees + ", windMph="
				+ windMph + ", windGustMph=" + windGustMph + ", windKph=" + windKph + ", windGustKph=" + windGustKph
				+ ", pressureMb=" + pressureMb + ", pressureIn=" + pressureIn + ", pressureTrend=" + pressureTrend
				+ ", dewPointString=" + dewPointString + ", dewPointF=" + dewPointF + ", dewPointC=" + dewPointC
				+ ", heatIndexString=" + heatIndexString + ", heatIndexF=" + heatIndexF + ", heatIndexC=" + heatIndexC
				+ ", windchillString=" + windchillString + ", windchillF=" + windchillF + ", windchillC=" + windchillC
				+ ", feelslikeString=" + feelslikeString + ", feelslikeF=" + feelslikeF + ", feelslikeC=" + feelslikeC
				+ ", visibilityMi=" + visibilityMi + ", visibilityKm=" + visibilityKm + ", solarRadiation="
				+ solarRadiation + ", uv=" + uv + ", precip1hrString=" + precip1hrString + ", precip1hrIn="
				+ precip1hrIn + ", precip1hrMetric=" + precip1hrMetric + ", precipTodayString=" + precipTodayString
				+ ", precipTodayIn=" + precipTodayIn + ", precipTodayMetric=" + precipTodayMetric + ", icon=" + icon
				+ ", iconUrl=" + iconUrl + ", forecastUrl=" + forecastUrl + ", historyUrl=" + historyUrl + ", obUrl="
				+ obUrl + ", nowcast=" + nowcast + "]";
	}



	
	
}
