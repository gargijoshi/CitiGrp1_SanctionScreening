package com.citi.sanction_transaction.helper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.QuoteMode;
import org.springframework.web.multipart.MultipartFile;

import com.citi.sanction_transaction.model.TransactionDB;



public class CSVHelper {
	public static String TYPE = "text/csv";
	  static String[] Headers = { "TransactionRefNo", "ValueDate", "PayerName", "PayerAccountNo", "PayeeName", "PayeeAccountNo", "Amount"};

	  public static boolean hasCSVFormat(MultipartFile file) {

	    if (!TYPE.equals(file.getContentType())) {
	      return false;
	    }

	    return true;
	  }

	  public static List<TransactionDB> csvToDB(InputStream is, String fileName) throws NumberFormatException, ParseException {
	    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
	        CSVParser csvParser = new CSVParser(fileReader,
	            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

	      List<TransactionDB> transactions = new ArrayList<TransactionDB>();

	      Iterable<CSVRecord> csvRecords = csvParser.getRecords();

	      for (CSVRecord csvRecord : csvRecords) {
	    	  TransactionDB t = new TransactionDB(
	    			  csvRecord.get("TransactionRefNo"),
	    			  new SimpleDateFormat("ddMMyyyy").parse(csvRecord.get("ValueDate")),
	    			  csvRecord.get("PayerName"),
	    			  csvRecord.get("PayerAccountNo"),
	    			  csvRecord.get("PayeeName"),
	    			  csvRecord.get("PayeeAccountNo"),
	    			  Double.parseDouble(csvRecord.get("Amount")), fileName
	            );
	    	  
	    	  System.out.println(t.getValueDate());  
	    	  if(t.getTransactionRefNo().length() <= 12 && isAlphaNumeric(t.getTransactionRefNo())) {
//	    		  System.out.println("1");
	    		  if(isAlphaNumeric(t.getPayeeName())) {
//	    			  System.out.println("2");
	    			  if(t.getPayerAccountNo().length() <= 12 && isAlphaNumeric(t.getPayeeAccountNo())) {
//	    				  System.out.println("3");
	    				  if(isAlphaNumeric(t.getPayerName())) {
//	    					  System.out.println("4");
	    					  if(t.getPayerAccountNo().length() <= 12 && isAlphaNumeric(t.getPayerAccountNo())) {
//	    						  System.out.println("5");
	    						  String []dblToStr = String.valueOf(t.getAmount()).split("\\.");
	    						  if(t.getAmount() > 0 && dblToStr[0].length() <= 10 && dblToStr[1].length() <= 2) {
//	    							  System.out.println(dblToStr[0].length() + "  " + dblToStr[1].length());
	    							  t.setValidateStatus(1);  
	    						  }
	    						  else {
	    							  t.setValidateStatus(0);
	    						  }
	    					  }
	    					  else {
	    						  t.setValidateStatus(0);
	    					  }
	    				  }
	    				  else {
	    					  t.setValidateStatus(0);
	    				  }
	    			  }
	    			  else {
	    				  t.setValidateStatus(0);
	    			  }
	    		  }
	    		  else {
	    			  t.setValidateStatus(0);
	    		  }
	    	  }
	    	  else {
	    		  t.setValidateStatus(0);
	    	  }
//	    	System.out.println(t.getValidateStatus());
	        transactions.add(t);
	        
	      }

	      return transactions;
	    } catch (IOException e) {
	      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
	    }
	  }
	  
	  public static boolean isAlphaNumeric(String s) {
	        return s != null && s.matches("^[a-zA-Z0-9]*$");
	    }
}

