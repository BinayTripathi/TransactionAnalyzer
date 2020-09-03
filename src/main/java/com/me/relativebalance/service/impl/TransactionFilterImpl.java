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
				.map(txn -> txn.getRelatedTransaction()).collect(Collectors.toSet());

	}

	@Override
	public double getRelativeBalance(String account, Date fromDate, Date toDate) {

		List<TransactionDetails> transactionList = dataParser.getAllTransaction().stream().parallel()
				.takeWhile(txn -> txn.getCreatedAt().before(toDate)).filter(txn -> txn.getCreatedAt().after(fromDate))
				.filter(txn -> txn.getFromAccountId().trim().compareTo(account) == 0
						|| txn.getToAccountId().trim().compareTo(account) == 0)
				.filter(txn -> !allReversalTransactions.contains(txn.getTransactionId())).collect(Collectors.toList());

		Double reduce = transactionList.parallelStream().map(txn -> {
			if (txn.getFromAccountId().compareTo(account) == 0)
				return txn.getAmount();
			else
				return -txn.getAmount();
		}).reduce(0.0, (amt1, amt2) -> amt1 + amt2);

		return reduce;

	}
}
