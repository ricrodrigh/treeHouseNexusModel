package com.hadron.treehousenexus.model.service.aquarium;

public class LoadEventsQuery {
	private Query query;
	private Projection projection;
	private Integer count;

	public LoadEventsQuery(){
		this.projection = new Projection();
		this.query = new Query();
	}
	
	public Projection getProjection() {
		return projection;
	}
	public void setProjection(Projection projection) {
		this.projection = projection;
	}

	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}

	public Query getQuery() {
		return query;
	}
	public void setQuery(Query query) {
		this.query = query;
	}

	public class Query {
		private String sensorId;

		public String getSensorId() {
			return sensorId;
		}

		public void setSensorId(String sensorId) {
			this.sensorId = sensorId;
		}
	}
	
	public class Projection {
		
	}
}
