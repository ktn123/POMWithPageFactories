package com.org.rough;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.w2a.utilities.TestUtil;

public class DataProviderTest extends TestUtil {
	@Test(dataProvider ="dp")
	public void flightSearchTestCase(Hashtable<String,String> table){
		System.out.println(table.get("from")+" "+table.get("to"));
	}
	
}
