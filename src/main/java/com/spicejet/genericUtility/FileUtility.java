package com.spicejet.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	private FileInputStream fis=null;
	private Properties property = null;
	/**
	 * This method is used to fetch data from property file
	 * @param filePath
	 * @param key
	 * @return
	 */
	public void propertyFilePath(String filePath)
	{
		try {
			fis = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		property = new Properties();
		try {
			property.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public  String getPropertyData(String key)
	{
		
		String data=null;
			
			data = property.getProperty(key).trim();
		
			
			
			
		return data;
	}
	public void closePropertyFile()
	{
		try {
			fis.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}



}
