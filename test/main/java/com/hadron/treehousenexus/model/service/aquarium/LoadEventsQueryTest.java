package com.hadron.treehousenexus.model.service.aquarium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Type;
import java.util.Collection;

import org.json.JSONObject;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hadron.treehousenexus.model.home.sensors.LiquidLevelStrip;
import com.hadron.treehousenexus.model.home.util.SensorReading;
import com.hadron.treehousenexus.model.home.util.SensorUnits;

public class LoadEventsQueryTest {
	
	private static final String RESPONSE_LOAD_ONE_EVENT = "{ \"probeResistance\": { \"magnitude\": 10068.5, \"unit\": "
			+ "\"OHM\" }, \"depth\": { \"magnitude\": 0, \"unit\": \"INCH\" }, \"sensorId\": \"001DPS002\", "
			+ "\"timestmp\": 1393635483346, \"_id\": \"5311309b3cc8f2000000088a\" }";
	private static final Float LIQUID_LEVEL_MAGNITUDE = 0F;
	private static final String SENSOR_ID = "sensor1";
	private static final Gson gsonObject = new Gson();
	
	private static final String RESPONSE_LOAD_ONE_EVENT_ARRAY = "[{ \"probeResistance\": { \"magnitude\": 10068.5, \"unit\": "
			+ "\"OHM\" }, \"depth\": { \"magnitude\": 0, \"unit\": \"INCH\" }, \"sensorId\": \"001DPS002\", "
			+ "\"timestmp\": 1393635483346, \"_id\": \"5311309b3cc8f2000000088a\" }]";
	
	@Test
	public void testEmptyBean() {
		JSONObject bean = new JSONObject(new LoadEventsQuery());
		System.out.println(bean);
	}
	
	@Test
	public void testQueryConstructiorBean() {
		LoadEventsQuery bean = new LoadEventsQuery();
		
		LoadEventsQuery.Query query = bean.new Query();
		query.setSensorId(SENSOR_ID);
		bean.setQuery(query);
		
		JSONObject object = new JSONObject(bean);
		System.out.println(object);
	}
	
	@Test
	public void testFullBean() {
		LoadEventsQuery bean = new LoadEventsQuery();
		
		LoadEventsQuery.Query query = bean.new Query();
		query.setSensorId(SENSOR_ID);
		bean.setQuery(query);
		
		LoadEventsQuery.Projection projection = bean.new Projection();
		bean.setProjection(projection);
		
		JSONObject object = new JSONObject(bean);
		System.out.println(object);
	}
	
	@Test
	public void testMarshalJson() {
		LiquidLevelStrip responseBean = gsonObject.fromJson(RESPONSE_LOAD_ONE_EVENT, LiquidLevelStrip.class);
		SensorReading<Float, SensorUnits> sensorReading = responseBean.getDepth();
		assertEquals(SensorUnits.INCH, sensorReading.getUnit());
		assertEquals(LIQUID_LEVEL_MAGNITUDE, sensorReading.getMagnitude());
	}
	
	@Test
	public void testMarshalJsonArray() {
		Type collectionType = new TypeToken<Collection<LiquidLevelStrip>>(){}.getType();
		Collection<LiquidLevelStrip> responseArray = gsonObject.fromJson(RESPONSE_LOAD_ONE_EVENT_ARRAY, collectionType);
		
		assertTrue(responseArray.size() == 1);

		LiquidLevelStrip responseBean = responseArray.iterator().next();
		SensorReading<Float, SensorUnits> sensorReading = responseBean.getDepth();
		assertEquals(SensorUnits.INCH, sensorReading.getUnit());
		assertEquals(LIQUID_LEVEL_MAGNITUDE, sensorReading.getMagnitude());
	}	

}
