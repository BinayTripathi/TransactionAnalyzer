package com.me.relativebalance.dto;

import java.util.Date;

import lombok.Data;
import lombok.Setter;

@Data
@Setter
public class InputArgs {
	
	String accountId;
	Date fromDate;
	Date toDate;
	
	

}
