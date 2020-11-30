package com.vtanh1905.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateLibrary {
	public static Timestamp convertSimpleDayToTimestamp(String strDate) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			return new Timestamp ((dateFormat.parse(strDate)).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static String convertTimestampToSimpleDate(Timestamp timestamp) {
		Date date = new Date();
		date.setTime(timestamp.getTime());
		return new SimpleDateFormat("dd/MM/yyyy").format(date);
	
	}
}
