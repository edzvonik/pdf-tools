package com.dzvonik.pdftools.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("pdf")
public class PdfController {
    
    @GetMapping("/")
    public String index() {
        return "this is pdf root endpoint!";
    }

    @PostMapping("/merge")
    public String merge(@RequestParam("files") MultipartFile[] files) {
        // https://spring.io/guides/gs/uploading-files/
        // https://www.bezkoder.com/spring-boot-upload-multiple-files/
        
        return "";
    }

}
