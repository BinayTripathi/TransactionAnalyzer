package com.me.relativebalance.service.impl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
	
	private List<TransactionDetails> allTransactions;

	public CsvDataParser() {

		 this.allTransactions = new ArrayList<TransactionDetails>();

		CsvMapper csvMapper = new CsvMapper();
		CsvSchema schema = CsvSchema.emptySchema().withHeader();
		ObjectReader oReader = csvMapper.reader(TransactionDetails.class).with(schema);

		try (Reader reader = new FileReader("C:/Study/JAVA/CodingChallange/TransactionAnalyzer/src/main/resources/transaction.csv")) {
			MappingIterator<TransactionDetails> mapItr = oReader.readValues(reader);
			while (mapItr.hasNext()) {
				allTransactions.add(mapItr.next());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<TransactionDetails> getAllTransaction() {
		
		return allTransactions;
	}

}
