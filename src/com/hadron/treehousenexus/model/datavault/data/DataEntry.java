package com.hadron.treehousenexus.model.datavault.data;

import com.google.common.base.Preconditions;

public abstract class DataEntry {
	
	protected String id;
	
	protected String name;
	protected String login;
	protected String password;
	protected String description;

	public String getName() {
		return name;
	}

	public void setName(String entryName) {
		Preconditions.checkNotNull(entryName);
		this.name = entryName;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String version) {
		this.id = version;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public boolean equals(Object dataEntry) {
		if(dataEntry instanceof DataEntry){
			return ((DataEntry) dataEntry).getName().equals(this.name);
		}
		
		return false;
	}
	
}
