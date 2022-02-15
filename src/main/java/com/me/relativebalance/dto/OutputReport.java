package com.me.relativebalance.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@Data
@Setter
@AllArgsConstructor
public class OutputReport {
	
	double relativeBalance;
	int transactionCount;
	
	public void printReport( ) {
		
		String relBalReport = String.format("Relative balance for the period is: %s",relativeBalance);
		String transactionCnt = String.format("Number of transactions included is: %s",transactionCount);
		
		System.out.println(relBalReport);
		System.out.println(transactionCnt);
		
	}
	
	

}
