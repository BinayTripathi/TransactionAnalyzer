package com.me.relativebalance;

import java.text.ParseException;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.me.relativebalance.configuration.AppInjector;
import com.me.relativebalance.dto.InputArgs;
import com.me.relativebalance.service.TransactionFilter;
import com.me.relativebalance.service.impl.CsvDataParser;
import com.me.relativebalance.service.impl.TransactionFilterImpl;
import com.me.relativebalance.util.CommandLineArgsUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       
    	Injector injector = Guice.createInjector(new AppInjector());	
    	TransactionFilter instance = injector.getInstance(TransactionFilter.class);
    	
    	try {
			InputArgs inputArgs = CommandLineArgsUtil.processCli(args);
			instance.getRelativeBalance(inputArgs.getAccountId(), inputArgs.getFromDate(), inputArgs.getToDate());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
}
