package com.citi.sanction_transaction.model;

import java.io.Serializable;

public class keywordId implements Serializable {
	private String name;
	private String AccountNo;
	public keywordId(String name, String accountNo) {
		super();
		this.name = name;
		AccountNo = accountNo;
	}
}