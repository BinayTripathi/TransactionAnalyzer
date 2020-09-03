package com.me.relativebalance.service;

import com.me.relativebalance.dto.OutputReport;

public interface TransactionAnalyzer {
	
	OutputReport analyzeTransaction(String[] input);

}
