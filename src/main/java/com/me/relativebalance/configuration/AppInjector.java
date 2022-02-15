package com.me.relativebalance.configuration;

import com.google.inject.AbstractModule;
import com.me.relativebalance.service.DataParser;
import com.me.relativebalance.service.TransactionAnalyzer;
import com.me.relativebalance.service.TransactionFilter;
import com.me.relativebalance.service.impl.CsvDataParser;
import com.me.relativebalance.service.impl.TransactionAnalyzerImpl;
import com.me.relativebalance.service.impl.TransactionFilterImpl;

public class AppInjector extends AbstractModule{

	@Override
	protected void configure() {
		// TODO Auto-generated method stub
		bind(DataParser.class).to(CsvDataParser.class);
		bind(TransactionFilter.class).to(TransactionFilterImpl.class);
		bind(TransactionAnalyzer.class).to(TransactionAnalyzerImpl.class);
	}

}
