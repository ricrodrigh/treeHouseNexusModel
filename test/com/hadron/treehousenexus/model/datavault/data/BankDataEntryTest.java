package com.hadron.treehousenexus.model.datavault.data;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BankDataEntryTest {

	private static String ENTRY_NAME = "entry1";
	private static String ENTRY_PASSWORD = "password";
	private static String ENTRY_LOGIN = "login";
	
	@Test
	public void createFullEntity() {
		BankDataEntry dataEntry = new BankDataEntry(ENTRY_NAME, ENTRY_LOGIN, ENTRY_PASSWORD);
		
		assertTrue(dataEntry.getName().equals(ENTRY_NAME));
		assertTrue(dataEntry.getLogin().equals(ENTRY_LOGIN));
		assertTrue(dataEntry.getPassword().equals(ENTRY_PASSWORD));
	}
	
	@Test (expected=NullPointerException.class)
	public void createEntityNullEntityName() {
		new BankDataEntry(null, ENTRY_PASSWORD);		
	}
	
	@Test
	public void createEntityNullPassword() {
		BankDataEntry dataEntry = new BankDataEntry(ENTRY_NAME, null);
		
		assertTrue(dataEntry.getName().equals(ENTRY_NAME));
		assertNull(dataEntry.getLogin());
		assertNull(dataEntry.getPassword());
	}
	
	@Test
	public void createEntityNullLogin() {
		BankDataEntry dataEntry = new BankDataEntry(ENTRY_NAME, null, ENTRY_PASSWORD);
		
		assertTrue(dataEntry.getName().equals(ENTRY_NAME));
		assertNull(dataEntry.getLogin());
		assertTrue(dataEntry.getPassword().equals(ENTRY_PASSWORD));
	}
	
	@Test (expected=IllegalStateException.class)
	public void createEntityEmptyEntityName() {
		new BankDataEntry("", ENTRY_PASSWORD);
	}
	
	@Test
	public void createEntityEmptyPassword() {
		BankDataEntry dataEntry = new BankDataEntry(ENTRY_NAME, "");
		
		assertTrue(dataEntry.getName().equals(ENTRY_NAME));
		assertNull(dataEntry.getLogin());
		assertTrue(dataEntry.getPassword().equals(""));
	}
	
	@Test
	public void createEntityEmptyLogin() {
		BankDataEntry dataEntry = new BankDataEntry(ENTRY_NAME, "", ENTRY_PASSWORD);
		
		assertTrue(dataEntry.getName().equals(ENTRY_NAME));
		assertTrue(dataEntry.getLogin().equals(""));
		assertTrue(dataEntry.getPassword().equals(ENTRY_PASSWORD));
		
	}
	
	@Test
	public void compareEntities() {
		BankDataEntry dataEntry = new BankDataEntry(ENTRY_NAME, ENTRY_LOGIN, ENTRY_PASSWORD);
		BankDataEntry dataEntry2 = new BankDataEntry(ENTRY_NAME, ENTRY_LOGIN, ENTRY_PASSWORD);
		BankDataEntry dataEntry3 = new BankDataEntry("entryname3", ENTRY_LOGIN, ENTRY_PASSWORD);

		
		assertTrue(dataEntry.equals(dataEntry2));
		assertFalse(dataEntry.equals(dataEntry3));
		
	}

}
