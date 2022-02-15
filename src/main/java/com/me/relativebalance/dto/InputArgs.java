package com.me.relativebalance.dto;

import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class InputArgs {
	
	String accountId;
	Date fromDate;
	Date toDate;
	
	

}
