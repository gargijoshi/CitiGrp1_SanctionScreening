package com.citi.sanction_transaction.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "transactions")
public class TransactionDB {
	@Id
//	@Column(length = 11)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int TransactionID;
	
	@Column(columnDefinition = "varchar(255) default 'NULL'", unique=true)
	private String TransactionRefNo;
	
	private Date ValueDate;
	
	@Column(columnDefinition = "varchar(35) default 'NULL'")	
	private String PayerName;
	
	@Column(columnDefinition = "varchar(50) default 'NULL'")
	private String PayerAccountNo;
	
	@Column(columnDefinition = "varchar(35) default 'NULL'")
	private String PayeeName;
	
	@Column(columnDefinition = "varchar(50) default 'NULL'")
	private String PayeeAccountNo;
	
	@Column(columnDefinition = "decimal(10, 2) default 0.0")
	private Double Amount;
	
	@Column(length=1)
//	@Type(type = "org.hibernate.type.NumericBooleanType")
	private int validateStatus;
	
	@Column(length=1)
//	@Type(type = "org.hibernate.type.NumericBooleanType")
	private int sanctionStatus;
	
	@Column(columnDefinition = "varchar(35) default 'NULL'")
	private String fileName;
	
	//Inner Join
	
//	@ManyToOne
//	@NotFound(action = NotFoundAction.IGNORE)
//	@JoinColumn(
//		       name = "payer_name", 
//		       referencedColumnName = "name", 
//		       insertable = false, 
//		       updatable = false, 
//		       foreignKey = @javax.persistence
//		         .ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
//	
//	@JoinColumn(
//		       name = "payee_name", 
//		       referencedColumnName = "name", 
//		       insertable = false, 
//		       updatable = false, 
//		       foreignKey = @javax.persistence
//		         .ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
//	
//	@JoinColumn(
//		       name = "payer_account_no", 
//		       referencedColumnName = "account_no", 
//		       insertable = false, 
//		       updatable = false, 
//		       foreignKey = @javax.persistence
//		         .ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
//	
//	@JoinColumn(
//		       name = "payee_account_no", 
//		       referencedColumnName = "account_no", 
//		       insertable = false, 
//		       updatable = false, 
//		       foreignKey = @javax.persistence
//		         .ForeignKey(value = ConstraintMode.NO_CONSTRAINT))	
//	
//	@ManyToOne
//	@NotFound(action = NotFoundAction.IGNORE)
//	@JoinColumn(
//		       name = "AccountNo", 
//		       referencedColumnName = "PayeeAccountNo, PayerAccountNo", 
//		       insertable = false, 
//		       updatable = false, 
//		       foreignKey = @javax.persistence
//		         .ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
//	
//	@JoinColumn(
//		       name = "name", 
//		       referencedColumnName = "PayeeName, PayerName", 
//		       insertable = false, 
//		       updatable = false, 
//		       foreignKey = @javax.persistence
//		         .ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
	
//	private Keywords keyword;
	
	
	public String getTransactionRefNo() {
		return TransactionRefNo;
	}

	public void setTransactionRefNo(String transactionRefNo) {
		TransactionRefNo = transactionRefNo;
	}
	
	public Date getValueDate() {
		return ValueDate;
	}

	public void setValueDate(Date valueDate) {
		ValueDate = valueDate;
	}

	public String getPayerName() {
		return PayerName;
	}

	public void setPayerName(String payerName) {
		PayerName = payerName;
	}

	public String getPayerAccountNo() {
		return PayerAccountNo;
	}

	public void setPayerAccountNo(String payerAccountNo) {
		PayerAccountNo = payerAccountNo;
	}

	public String getPayeeName() {
		return PayeeName;
	}

	public void setPayeeName(String payeeName) {
		PayeeName = payeeName;
	}

	public String getPayeeAccountNo() {
		return PayeeAccountNo;
	}

	public void setPayeeAccountNo(String payeeAccountNo) {
		PayeeAccountNo = payeeAccountNo;
	}

	public Double getAmount() {
		return Amount;
	}

	public void setAmount(Double amount) {
		Amount = amount;
	}

	public int getValidateStatus() {
		return validateStatus;
	}

	public void setValidateStatus(int validateStatus) {
		this.validateStatus = validateStatus;
	}

	public int getSanctionStatus() {
		return sanctionStatus;
	}

	public void setSanctionStatus(int sanctionStatus) {
		this.sanctionStatus = sanctionStatus;
	}
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String file) {
		fileName = file;
	}

	public TransactionDB() {
		super();
	}

	@Override
	public String toString() {
		return "TransactionDB [TransactionID=" + TransactionID + ", TransactionRefNo=" + TransactionRefNo
				+ ", ValueDate=" + ValueDate + ", PayerName=" + PayerName + ", PayerAccountNo=" + PayerAccountNo
				+ ", PayeeName=" + PayeeName + ", PayeeAccountNo=" + PayeeAccountNo + ", Amount=" + Amount
				+ ", validateStatus=" + validateStatus + ", sanctionStatus=" + sanctionStatus + ", FileName=" + fileName
				+ "]";
	}

	public TransactionDB(String transactionRefNo, Date valueDate, String payerName, String payerAccountNo,
			String payeeName, String payeeAccountNo, Double amount, int validateStatus, String file_Name) {
		super();
		TransactionRefNo = transactionRefNo;
		ValueDate = valueDate;
		PayerName = payerName;
		PayerAccountNo = payerAccountNo;
		PayeeName = payeeName;
		PayeeAccountNo = payeeAccountNo;
		Amount = amount;
		this.validateStatus = validateStatus;
		fileName = file_Name;
	}

	public TransactionDB(String transactionRefNo, Date valueDate, String payerName,
			String payerAccountNo, String payeeName, String payeeAccountNo, Double amount, String file_Name) {
		super();
		TransactionRefNo = transactionRefNo;
		ValueDate = valueDate;
		PayerName = payerName;
		PayerAccountNo = payerAccountNo;
		PayeeName = payeeName;
		PayeeAccountNo = payeeAccountNo;
		Amount = amount;
		fileName = file_Name;
	}


	
}

