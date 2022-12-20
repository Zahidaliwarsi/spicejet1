package com.spicejet.genericUtility;


import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

/**
 * This class contains java resuable methods
 * @author qqqqqqqqqqqqqqqqqqqq
 *
 */
public class JavaUtility {
	/**
	 * This method is used to convert string to Long and int datatype
	 * @param s
	 * @param strategy
	 * @return
	 */
	public Object stringToAnyDataType(String s,String strategy)
	{
		Object convertedData = null;
		if(strategy.equals("int"))
		{
			convertedData = Integer.parseInt(s);
		}
		else if(strategy.equals("long"))
		{
			convertedData = Long.parseLong(s);
		}
		return convertedData;
	}
	/**
	 * this method is used to get the random number
	 * @param limit
	 * @return
	 */
	
	public int getRandomNumber(int limit)
	{
		int randomnumber = new Random().nextInt(limit);
		return randomnumber;
	}
	
	public int getMonthInMMFormat(String s)
	{
		return DateTimeFormatter.ofPattern("MMM")
				.withLocale(Locale.ENGLISH)
				.parse(s)
				.get(ChronoField.MONTH_OF_YEAR);
	}
	public String[] splitString(String currentmonthyrxpath,String space)
	{
		String[] monthYearArr = new String[2];
		monthYearArr[0]=currentmonthyrxpath.split(space)[0];
		monthYearArr[1]=currentmonthyrxpath.split(space)[1];
		return monthYearArr;
	}
	
	public String getDateTime()
	{
		Date date = new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_YYYY_HH_mm_sss");
		String d = sdf.format(date);
		return d;
	}

}
