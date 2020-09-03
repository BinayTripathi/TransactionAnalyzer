package com.me.relativebalance.service;

import java.util.Date;

import com.me.relativebalance.dto.OutputReport;

public interface TransactionFilter {
	
	OutputReport getRelativeBalance(String account, Date fromDate, Date toDate);

}
