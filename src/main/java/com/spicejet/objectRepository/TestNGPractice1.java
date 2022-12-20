package com.spicejet.objectRepository;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGPractice1 {
	
	@Test(dataProvider = "getData")
	public void dataTest(String username,String password)
	{
		System.out.println("username ===> "+username+"----- password is =====> "+password);
	}
	@DataProvider
	public String[][] getData() throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/DataProvider.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("Sheet1");
		int lastRowNum = sheet.getLastRowNum();
		short lastCellNum = sheet.getRow(0).getLastCellNum();
		String[][] arr = new String[lastRowNum][lastCellNum];
		DataFormatter df = new DataFormatter();
		for(int i =0;i<lastRowNum;i++)
		{
			for(int j =0;j<lastCellNum;j++)
			{
				arr[i][j] = df.formatCellValue(sheet.getRow(i+1).getCell(j));
			}
		}
		return arr;
	}

}
