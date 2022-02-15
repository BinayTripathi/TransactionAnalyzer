package com.me.relativebalance.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.me.relativebalance.dto.InputArgs;

public class CommandLineArgsUtil {
	
	private static String ACCOUNT_ID = "accountId";
	private static String FROM_DATE = "from";
	private static String TO_DATE = "to";
	private static String delimiter = ":";
	private static String datePattern = "dd/MM/yyyy hh:mm:ss";
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern);
	
	public static InputArgs processCli(String[] input) throws ParseException {
		
		if(null == input || input.length < 3) {
			System.out.println("Please provid input");
			return null;
		}
		
		InputArgs inputArgs = new InputArgs();
		
		for(int index =0; index < input.length; index++) {
			
			if(input[index].contains(delimiter)) {
				
				String[] argsToken = input[index].split(delimiter);
				
				if(argsToken[0].trim().compareToIgnoreCase(ACCOUNT_ID) == 0) {
					inputArgs.setAccountId(argsToken[1].trim());
				} else if(argsToken[0].trim().compareToIgnoreCase(FROM_DATE) == 0) {
					String date = argsToken[1];
					String time = input[++index];
					String dateTime = date + " " + time;
					Date fromDate = simpleDateFormat.parse(dateTime);
					inputArgs.setFromDate(fromDate);
				} else if(argsToken[0].trim().compareToIgnoreCase(TO_DATE) == 0) {
					String date = argsToken[1];
					String time = input[++index];
					String dateTime = date + " " + time;
					Date toDate = simpleDateFormat.parse(dateTime);
					inputArgs.setToDate(toDate);
				}
				
			}
			
		}
		
		return inputArgs;
	}

}
