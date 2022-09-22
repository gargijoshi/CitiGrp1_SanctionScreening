package com.citi.sanction_transaction.model;

import javax.persistence.*;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@IdClass(keywordId.class)
@Table(name = "keywords")
public class Keywords {
	@Id
	@Column(name = "name")
	private String name;
	
	@Id
	@Column(name = "AccountNo")
	private String AccountNo;

//	@OneToMany
//	@NotFound(action = NotFoundAction.IGNORE)
//	@JoinColumn(
//		       name = "payee_account_no, payer_account_no", 
//		       referencedColumnName = "account_no", 
//		       insertable = false, 
//		       updatable = false, 
//		       foreignKey = @javax.persistence
//		         .ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
//	
//	@JoinColumn(
//		       name = "payee_name, payer_name", 
//		       referencedColumnName = "name", 
//		       insertable = false, 
//		       updatable = false, 
//		       foreignKey = @javax.persistence
//		         .ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
//	
//	private TransactionDB transDB;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccountNo() {
		return AccountNo;
	}

	public void setAccountNo(String accountNo) {
		AccountNo = accountNo;
	}
	
}

