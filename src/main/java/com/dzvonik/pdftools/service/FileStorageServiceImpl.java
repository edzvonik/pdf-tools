package com.dzvonik.pdftools.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

@Service
public class FileStorageServiceImpl implements FileStorageService {

    private final Path root = Paths.get("uploads");

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
        try {
            for (MultipartFile file : files) {
                 Files.copy(file.getInputStream(), root.resolve(Objects.requireNonNull(file.getOriginalFilename())));
            }
        } catch (IOException ioe) {
            throw new RuntimeException("Error save files!", ioe);
        }
    }

}
