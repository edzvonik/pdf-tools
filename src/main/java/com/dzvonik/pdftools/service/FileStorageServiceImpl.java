package com.dzvonik.pdftools.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
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
    public List<File> save(List<MultipartFile> files) {
        List<File> savedFiles = new LinkedList<>();

        try {
            for (MultipartFile file : files) {
                Path pathToFile = root.resolve(Objects.requireNonNull(file.getOriginalFilename()));
                Files.copy(file.getInputStream(), pathToFile);
                File savedFile = pathToFile.toFile();
                savedFiles.add(savedFile);
            }
        } catch (IOException ioe) {
            throw new RuntimeException("Error save files!", ioe);
        }

        return savedFiles;
    }

}
