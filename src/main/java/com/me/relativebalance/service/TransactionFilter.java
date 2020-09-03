package com.me.relativebalance.service;

import java.util.Date;

import com.me.relativebalance.dto.InputArgs;
import com.me.relativebalance.dto.OutputReport;

public interface TransactionFilter {
	
	OutputReport getRelativeBalance(InputArgs inputArgs);

}
