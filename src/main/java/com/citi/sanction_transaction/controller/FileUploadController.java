package com.citi.sanction_transaction.controller;

import java.io.IOException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.citi.sanction_transaction.model.FileDB;
import com.citi.sanction_transaction.storage.StorageFileNotFoundException;
import com.citi.sanction_transaction.storage.StorageService;


@Controller
public class FileUploadController {

	private final StorageService storageService;
	private FileDB fileDB;

	@Autowired
	public FileUploadController(StorageService storageService) {
		this.storageService = storageService;
	}

	@GetMapping("/uploadForm")
	public String listUploadedFiles(Model model) throws IOException {

		model.addAttribute("files", storageService.loadAll().map(
				path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
						"serveFile", path.getFileName().toString()).build().toUri().toString())
				.collect(Collectors.toList()));

		return "uploadForm";
	}

	@GetMapping("/files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
		
		Resource file = storageService.loadAsResource(filename);
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
				"attachment; filename=\"" + file.getFilename() + "\"").body(file);
	}

	@PostMapping("/")
//	@GetMapping("/")
	public String handleFileUpload(@RequestParam("file") MultipartFile file,
			RedirectAttributes redirectAttributes) {
		
		String msg = storageService.store(file);
		if(!msg.equals("Success")) {
			System.out.println("True!" + msg);
			return msg;
		}
		else {
		System.out.println("msg: " + msg);
		redirectAttributes.addFlashAttribute("message",
				"You successfully uploaded " + file.getOriginalFilename() + "!");

//		return "redirect:/uploadForm";
		System.out.println("File uploaded: " + file.getOriginalFilename());
		redirectAttributes.addFlashAttribute("file", file.getOriginalFilename());
		return "redirect:/sanction";
//		return "redirect:/list";
		}
	}
	
	@GetMapping({"/uploadBlank", "/uploadBlank"})
    public String uploadBlankFile()
    {
    return "uploadBlank";
    }
	
	@GetMapping({"/uploadFail", "/uploadFail"})
    public String uploadFileFail()
    {
    return "uploadFail";
    }

	@ExceptionHandler(StorageFileNotFoundException.class)
	public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
		return ResponseEntity.notFound().build();
	}

}