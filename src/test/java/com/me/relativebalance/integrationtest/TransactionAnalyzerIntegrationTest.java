package com.me.relativebalance.integrationtest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.me.relativebalance.dto.OutputReport;
import com.me.relativebalance.service.DataParser;
import com.me.relativebalance.service.TransactionAnalyzer;
import com.me.relativebalance.service.TransactionFilter;
import com.me.relativebalance.service.impl.CsvDataParser;
import com.me.relativebalance.service.impl.TransactionAnalyzerImpl;
import com.me.relativebalance.service.impl.TransactionFilterImpl;

public class TransactionAnalyzerIntegrationTest {
	
	

	private Injector injector;
	TransactionAnalyzer ta;

	@Before
	public void setUp() throws Exception {
		injector = Guice.createInjector(new AbstractModule() {

			@Override
			protected void configure() {
				bind(DataParser.class).to(CsvDataParser.class);
				bind(TransactionFilter.class).to(TransactionFilterImpl.class);
				bind(TransactionAnalyzer.class).to(TransactionAnalyzerImpl.class);
			}
		});
		
		
	}
	

	@Test
	public void givenCaseTest() {
		
		String[] args = new String[]{"accountId:ACC334455" , "from:20/10/2018", "12:00:00" ,   "to: 20/10/2018", "19:00:00"};
		
		ta = injector.getInstance(TransactionAnalyzer.class);
		OutputReport transactionReport = ta.analyzeTransaction(args);
		assertTrue(transactionReport.getRelativeBalance() == -25.0);
		assertTrue(transactionReport.getTransactionCount() == 1);
	}
	
	@Test
	public void testCase_to_ignore_transaction_with_reversal_outside_transaction_window() {
		
		String[] args = new String[]{"accountId:ACC998877" , "from:20/10/2018", "17:33:40" ,   "to: 20/10/2018", "18:00:01"};
		
		ta = injector.getInstance(TransactionAnalyzer.class);
		OutputReport transactionReport = ta.analyzeTransaction(args);
		assertTrue(transactionReport.getRelativeBalance() == -5.0);
		assertTrue(transactionReport.getTransactionCount() == 1);
	}
	
	@Test
	public void testCase_to_ignore_transaction_with_reversal_inside_transaction_window() {
		
		String[] args = new String[]{"accountId:ACC998877" , "from:20/10/2018", "17:33:40" ,   "to: 20/10/2018", "19:45:01"};
		
		ta = injector.getInstance(TransactionAnalyzer.class);
		OutputReport transactionReport = ta.analyzeTransaction(args);
		assertTrue(transactionReport.getRelativeBalance() == -5.0);
		assertTrue(transactionReport.getTransactionCount() == 1);
	}


}
