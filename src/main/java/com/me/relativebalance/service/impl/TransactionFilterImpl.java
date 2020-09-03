package com.me.relativebalance.service.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.me.relativebalance.dto.InputArgs;
import com.me.relativebalance.dto.OutputReport;
import com.me.relativebalance.dto.TransactionDetails;
import com.me.relativebalance.service.DataParser;
import com.me.relativebalance.service.TransactionFilter;

@Singleton
public class TransactionFilterImpl implements TransactionFilter {

	private final DataParser dataParser;

	private Set<String> allReversalTransactions;

	@Inject
	public TransactionFilterImpl(DataParser dataParser) {
		this.dataParser = dataParser;

		List<TransactionDetails> allTransaction = this.dataParser.getAllTransaction();
		allReversalTransactions = allTransaction.stream()
				.filter(txn -> txn.getTransactionType().compareTo(" REVERSAL") == 0)
				.map(txn -> txn.getRelatedTransaction().trim()).collect(Collectors.toSet());

	}

	@Override
	public OutputReport getRelativeBalance(InputArgs input) {

		OutputReport report = new OutputReport(0.0, 0);
		
		String account = input.getAccountId();
		Date fromDate = input.getFromDate(); 
		Date toDate = input.getToDate();
		
		List<TransactionDetails> transactionList = dataParser.getAllTransaction().stream()
				.takeWhile(txn -> txn.getCreatedAt().before(toDate))
				.filter(txn -> txn.getCreatedAt().after(fromDate))
				.filter(txn -> txn.getTransactionType().trim().compareToIgnoreCase("REVERSAL") != 0)
				.filter(txn -> txn.getFromAccountId().trim().compareTo(account) == 0
						|| txn.getToAccountId().trim().compareTo(account) == 0)
				.filter(txn -> !allReversalTransactions.contains(txn.getTransactionId().trim()))
				.collect(Collectors.toList());

		if(transactionList.isEmpty())
			return report;
		
		Double accBalance = transactionList.parallelStream().map(txn -> {
			if (txn.getFromAccountId().trim().compareTo(account) == 0)
				return -txn.getAmount();
			else
				return txn.getAmount();
		}).reduce(0.0, (amt1, amt2) -> amt1 + amt2);
		
		report.setRelativeBalance(accBalance);
		report.setTransactionCount(transactionList.size());
		return report;


		

	}
}
