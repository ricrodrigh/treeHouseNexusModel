package com.hadron.treehousenexus.model.home.sensors;

import com.google.gson.Gson;
import com.hadron.treehousenexus.model.home.util.SensorReading;
import com.hadron.treehousenexus.model.home.util.SensorUnits;


public class TemperatureProbe extends Sensor<String> implements Termometer {
	
	private static final String SENSOR_PREFIX = "TP";
	
	private SensorReading<Float, SensorUnits> temperature;
	private Gson gson = new Gson();
	
	public TemperatureProbe(String sensorId) {
		super(sensorId);
		// Define new temperature probe with a initial value of 0 and Celsius
		temperature = new SensorReading<Float, SensorUnits>(new Float(0f), SensorUnits.CELSIUS);
	}

	public boolean doHealthCheck() {
		// Get a Temp reading and verify it's in valid ranges
		return true;
	}

	@Override
	public void setReading(String reading) {
		temperature.setMagnitude(new Float(reading));
	}

	@Override
	public SensorReading<Float, SensorUnits> getReading() {
		return getTemperature();
	}

	public SensorReading<Float, SensorUnits> getTemperature() {
		return temperature;
	}

	@Override
	public String toJson() {
		return gson.toJson(this);
	}

	public static String getSensorPrefix() {
		return SENSOR_PREFIX;
	}

}
