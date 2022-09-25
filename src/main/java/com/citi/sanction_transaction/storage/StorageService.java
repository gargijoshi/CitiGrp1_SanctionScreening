package com.citi.sanction_transaction.storage;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.text.ParseException;
import java.util.stream.Stream;

public interface StorageService {

	void init();

	String store(MultipartFile file);

	Stream<Path> loadAll();

	Path load(String filename);

	Resource loadAsResource(String filename);

//	void deleteAll();
	
//	void saveTransactions(MultipartFile file) throws NumberFormatException, ParseException;

}

