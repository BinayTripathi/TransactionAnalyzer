package com.me.relativebalance;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.me.relativebalance.configuration.AppInjector;
import com.me.relativebalance.dto.OutputReport;
import com.me.relativebalance.service.TransactionAnalyzer;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		
		
		Injector injector = Guice.createInjector(new AppInjector());
		TransactionAnalyzer transactionAnalyser = injector.getInstance(TransactionAnalyzer.class);
		OutputReport transactionReport = transactionAnalyser.analyzeTransaction(args);		
		transactionReport.printReport();

	}

}
