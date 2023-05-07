package com.dzvonik.pdftools;

import com.dzvonik.pdftools.service.FileStorageService;
import jakarta.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PdfToolsApplication implements CommandLineRunner {

	@Resource
	private	FileStorageService fileStorage;

	public static void main(String[] args) {
		SpringApplication.run(PdfToolsApplication.class, args);
	}

	@Override
	public void run(String...args) throws Exception {
		fileStorage.init();
	}

}
