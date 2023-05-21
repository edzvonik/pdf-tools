package com.dzvonik.pdftools.controller;

import com.dzvonik.pdftools.service.FileStorageService;
import com.dzvonik.pdftools.util.PdfUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("pdf")
public class PdfController {

    private Path root = Paths.get("uploads");

    @Autowired
    FileStorageService storageService;

    @GetMapping("/")
    public String index() {
        return "this is pdf root endpoint!";
    }

    @PostMapping(
            value = "/merge",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}
    )
    public ResponseEntity<Resource> merge(@RequestPart("files") List<MultipartFile> files) throws IOException {
        // https://spring.io/guides/gs/uploading-files/
        // https://www.bezkoder.com/spring-boot-upload-multiple-files/
        List<File> savedFiles = storageService.save(files);
        File mergedFile = PdfUtils.merge(savedFiles);
        Resource resource = new InputStreamResource(new FileInputStream(mergedFile));

        return ResponseEntity.ok()
                        .contentLength(mergedFile.length())
                        .contentType(MediaType.APPLICATION_PDF)
                        .body(resource);
    }

}
