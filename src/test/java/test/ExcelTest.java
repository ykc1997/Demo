package test;

import org.testng.annotations.Test;

import library.Base;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;

public class ExcelTest extends Base
{

	@DataProvider(name="testData")
	public String[][] testDataProvider() throws EncryptedDocumentException, IOException 
	{
		String[][] data = readData();
		
		return data;
	}
	
	
	@Test(dataProvider = "testData")
	public void test1(String uid, String pass) 
	{
		System.out.println(uid+" "+pass);
	}
}