package com.ntgclarity.smartcompound.common.utils;

public class Utils {

	public static boolean isEmpty(Object obj) {
		return obj == null;
	}

	public static boolean isNotEmpty(Object obj) {
		return !isEmpty(obj);
	}
	
	public static boolean isNotEmpty(String str) {
		return !isEmpty(str) && str.trim().length()>0;
	}

	public static boolean isNumericValue(String string) {
		try
		{
			Double.parseDouble(string);
			return true;
		}catch(Exception ex)
		{
			return false;
		}
	}
}
