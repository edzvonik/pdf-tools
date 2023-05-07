package com.dzvonik.pdftools.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class FileStorageServiceImpl implements FileStorageService {

    @Value("${spring.servlet.multipart.location}")
    private Path root;

    @Override
    public void init() {
        try {
            Files.createDirectories(root);
        } catch (IOException ioe) {
            throw new RuntimeException("Error create upload directory!", ioe);
        }
    }

    @Override
    public void save(List<MultipartFile> files) {

    }

}
