package com.dzvonik.pdftools.controller;

import com.dzvonik.pdftools.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("pdf")
public class PdfController {
    
    @Value("${spring.servlet.multipart.location}")
    private Path root;

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
    public void merge(@RequestPart("files") List<MultipartFile> files) throws IOException {
        // https://spring.io/guides/gs/uploading-files/
        // https://www.bezkoder.com/spring-boot-upload-multiple-files/

        // final Path root = Paths.get("/tmp/pdf-tools-files");
        // Files.createDirectories(root);

        storageService.save(files);

//        for (MultipartFile file : files) {
//            Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
//        }


//        1.List<File> save(List<MultipartFile>);
//        2.File mergeFiles(List<File>);
//        3.fileToByteArray(File pdf);

        //        PDFMergerUtility mergerUtility = new PDFMergerUtility();
        //        mergerUtility.setDestinationFileName("merged.pdf");
        //
        //        for (MultipartFile file : files) {
        //            System.out.println(file.getSize());
        //            File convertFile = convertMultiPartToFile(file);
        //            mergerUtility.addSource(convertFile);
        //        }
        //
        //        mergerUtility.mergeDocuments(null);
        //        File merged = new File(mergerUtility.getDestinationFileName());
        //        Resource resource = new InputStreamResource(new FileInputStream(merged));
        //
        //        return ResponseEntity.ok()
        //                .contentLength(merged.length())
        //                .contentType(MediaType.APPLICATION_OCTET_STREAM)
        //                .body(resource);
    }

}
