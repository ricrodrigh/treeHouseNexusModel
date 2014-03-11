package com.hadron.treehousenexus.model.datavault.data;

import com.google.common.base.Preconditions;

public class WebsiteDataEntry extends DataEntry{
	
	private String url;
	
	public WebsiteDataEntry(String name, String login, String password, String description) {
		Preconditions.checkNotNull(name);		
		Preconditions.checkNotNull(login);
		
		this.name = name;
		this.login = login;
		this.password = password;
		this.description = description;
		this.url = null;
	}
	
	public WebsiteDataEntry(String name, String login, String password, String url, String description) {
		this(name, login, password, description);
		this.url = url;
	}
	
	private WebsiteDataEntry(){
		this.name = "";
		this.login = "";
		this.password = "";
		this.description = "";
		this.url = "";
	}
	
	public static WebsiteDataEntry getEntryImage(){
		return new WebsiteDataEntry();
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public String toString() {
		return "name: " + name + ", login:" + login + ", password:" + password + 
				", description:" + description + ", url:" + url;
	}

}
