package com.me.relativebalance.service;

import java.util.Date;

public interface TransactionFilter {
	
	double getRelativeBalance(String account, Date fromDate, Date toDate);

}
