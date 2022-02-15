package com.me.relativebalance.service.impl;

import java.text.ParseException;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.me.relativebalance.dto.InputArgs;
import com.me.relativebalance.dto.OutputReport;
import com.me.relativebalance.service.DataParser;
import com.me.relativebalance.service.TransactionAnalyzer;
import com.me.relativebalance.service.TransactionFilter;
import com.me.relativebalance.util.CommandLineArgsUtil;

@Singleton
public class TransactionAnalyzerImpl implements TransactionAnalyzer {

	private final TransactionFilter transactionFilter;

	@Inject
	public TransactionAnalyzerImpl(TransactionFilter transactionFilter) {
		this.transactionFilter = transactionFilter;
	}

	@Override
	public OutputReport analyzeTransaction(String[] input) {

		try {

			InputArgs inputArgs = CommandLineArgsUtil.processCli(input);
			OutputReport relativeBalanceReport = transactionFilter.getRelativeBalance(inputArgs);

			return relativeBalanceReport;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}
