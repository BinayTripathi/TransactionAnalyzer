package com.me.relativebalance.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.me.relativebalance.dto.TransactionDetails;
import com.me.relativebalance.service.DataParser;

@Singleton
public class CsvDataParser implements DataParser {

	private List<TransactionDetails> allTransactions = null;

	@Override
	public List<TransactionDetails> getAllTransaction() {

		if (null != this.allTransactions)
			return  this.allTransactions;
		
		this.allTransactions = new ArrayList<TransactionDetails>();
		
		

		CsvMapper csvMapper = new CsvMapper();
		CsvSchema schema = CsvSchema.emptySchema().withHeader();
		ObjectReader oReader = csvMapper.reader(TransactionDetails.class).with(schema);
		
		InputStream csvFileStream = CsvDataParser.class.getClassLoader().getResourceAsStream("transaction.csv");
		try(Reader reader = new InputStreamReader(csvFileStream)){
			MappingIterator<TransactionDetails> mapItr = oReader.readValues(reader);
			while (mapItr.hasNext()) {
				allTransactions.add( mapItr.next());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allTransactions;
	}

}
