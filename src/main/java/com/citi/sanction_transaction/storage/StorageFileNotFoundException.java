package com.citi.sanction_transaction.storage;

import com.citi.sanction_transaction.storage.StorageException;

public class StorageFileNotFoundException extends StorageException {

	public StorageFileNotFoundException(String message) {
		super(message);
	}

	public StorageFileNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}

