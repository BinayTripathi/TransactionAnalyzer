package com.me.relativebalance.dto;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

@Setter
public class TransactionDetails implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty
	@Getter
	String transactionId;
	
	@JsonProperty
	@Getter
	String fromAccountId;
	
	@JsonProperty
	@Getter
	String toAccountId;
	
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
	@JsonProperty
	String createdAt;
	
	@JsonProperty
	@Getter
	double amount;
	
	@JsonProperty
	@Getter
	String transactionType;
	
	@JsonProperty
	@Getter
	String relatedTransaction;
	
	public Date getCreatedAt( ) {
		String datePattern = "dd/MM/yyyy hh:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern);
		try {
			return simpleDateFormat.parse(this.createdAt);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


}
