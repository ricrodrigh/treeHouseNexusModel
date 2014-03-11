package com.hadron.treehousenexus.model.datavault.data;

import static org.junit.Assert.*;

import org.junit.Test;

public class WebsiteDataEntryTest {

	private static String ENTRY_NAME = "entry1";
	private static String ENTRY_PASSWORD = "password";
	private static String ENTRY_LOGIN = "login";
	private static String ENTRY_URL = "url";
	
	@Test
	public void createFullEntity() {
		WebsiteDataEntry dataEntry = new WebsiteDataEntry(ENTRY_NAME, ENTRY_LOGIN, ENTRY_PASSWORD, ENTRY_URL);
		
		assertTrue(dataEntry.getName().equals(ENTRY_NAME));
		assertTrue(dataEntry.getLogin().equals(ENTRY_LOGIN));
		assertTrue(dataEntry.getPassword().equals(ENTRY_PASSWORD));
		assertTrue(dataEntry.getUrl().equals(ENTRY_URL));	
	}
	
	@Test (expected=NullPointerException.class)
	public void createEntityNullEntityName() {
		new WebsiteDataEntry(null, ENTRY_LOGIN ,ENTRY_PASSWORD, null);		
	}
	
	@Test
	public void createEntityNullPassword() {
		WebsiteDataEntry dataEntry = new WebsiteDataEntry(ENTRY_NAME, ENTRY_LOGIN, null, null);
		
		assertTrue(dataEntry.getName().equals(ENTRY_NAME));
		assertTrue(dataEntry.getLogin().equals(ENTRY_LOGIN));
		assertNull(dataEntry.getPassword());
		
	}
	
	@Test (expected=NullPointerException.class)
	public void createEntityNullLogin() {
		new WebsiteDataEntry(ENTRY_NAME, null, ENTRY_PASSWORD, null);
	}
	
	@Test (expected=IllegalStateException.class)
	public void createEntityEmptyEntityName() {
		new WebsiteDataEntry("", ENTRY_LOGIN, ENTRY_PASSWORD, null);
	}
	
	@Test (expected=IllegalStateException.class)
	public void createEntityEmptyPasswordEmptyLogin() {
		new WebsiteDataEntry(ENTRY_NAME, "", "", null);
	}
	
	@Test(expected= IllegalStateException.class)
	public void createEntityEmptyLogin() {
		new WebsiteDataEntry(ENTRY_NAME, "", ENTRY_PASSWORD, null);
	}
	
	@Test
	public void compareEntities() {
		WebsiteDataEntry dataEntry = new WebsiteDataEntry(ENTRY_NAME, ENTRY_LOGIN, ENTRY_PASSWORD, null);
		WebsiteDataEntry dataEntry2 = new WebsiteDataEntry(ENTRY_NAME, ENTRY_LOGIN, ENTRY_PASSWORD, null);
		WebsiteDataEntry dataEntry3 = new WebsiteDataEntry("entryname3", ENTRY_LOGIN, ENTRY_PASSWORD, null);

		
		assertTrue(dataEntry.equals(dataEntry2));
		assertFalse(dataEntry.equals(dataEntry3));
		
	}

}
