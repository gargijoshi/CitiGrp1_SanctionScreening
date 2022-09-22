package com.citi.sanction_transaction.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "uploads")

public class FileDB {
	@Id
	@Column(length = 11)
	private int fileID;
	
	@Column(columnDefinition = "varchar(50) default 'NULL'", unique=true)
	private String fileName =  "MyFile";
	
	private String fileType;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public FileDB() {
		super();
		this.fileName = "MyFile";
		this.fileType = "";
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public FileDB(String fileName, String fileType) {
		super();
		this.fileName = fileName;
		this.fileType = fileType;
	}

	@Override
	public String toString() {
		return "FileDB [fileName=" + fileName + ", fileType=" + fileType + "]";
	}	
}

