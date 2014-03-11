package com.hadron.treehousenexus.model.service.aquarium;

import org.json.JSONObject;
import org.junit.Test;

public class LoadEventsQueryTest {
	
	private static final String SENSOR_ID = "sensor1";
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

}
