package com.me.relativebalance;

import java.text.ParseException;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.me.relativebalance.configuration.AppInjector;
import com.me.relativebalance.dto.InputArgs;
import com.me.relativebalance.dto.OutputReport;
import com.me.relativebalance.service.TransactionFilter;
import com.me.relativebalance.service.impl.CsvDataParser;
import com.me.relativebalance.service.impl.TransactionFilterImpl;
import com.me.relativebalance.util.CommandLineArgsUtil;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		analyzeTransaction(args);
	}

	private static void analyzeTransaction(String[] input) {

		try {

			Injector injector = Guice.createInjector(new AppInjector());
			TransactionFilter instance = injector.getInstance(TransactionFilter.class);
			InputArgs inputArgs = CommandLineArgsUtil.processCli(input);
			OutputReport relativeBalanceReport = instance.getRelativeBalance(inputArgs.getAccountId(),
					inputArgs.getFromDate(), inputArgs.getToDate());
			
			relativeBalanceReport.printReport();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
