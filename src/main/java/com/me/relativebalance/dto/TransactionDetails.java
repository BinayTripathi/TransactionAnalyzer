package com.me.relativebalance.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class TransactionDetails {
	
	@JsonProperty
	String transactionId;
	
	@JsonProperty
	String fromAccountId;
	
	@JsonProperty
	String toAccountId;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
	Date createdAt;
	
	@JsonProperty
	double amount;
	
	@JsonProperty
	String transactionType;
	
	@JsonProperty
	String relatedTransaction;


}
