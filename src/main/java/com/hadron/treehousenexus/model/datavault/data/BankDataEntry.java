package com.hadron.treehousenexus.model.datavault.data;

import com.google.common.base.Preconditions;

public class BankDataEntry extends DataEntry {

	public BankDataEntry(String name, String password) {
		Preconditions.checkNotNull(name);
		Preconditions.checkState(name.trim().length() != 0);
		this.name = name;
		this.login = null;
		this.password = password;
	}
	
	public BankDataEntry(String entryName, String login, String password) {
		this(entryName, password);
		this.login = login;
	}

}
