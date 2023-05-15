package com.dzvonik.pdftools.service;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {FileStorageServiceImpl.class})
class FileStorageServiceImplTest {

    @Autowired
    private FileStorageService storageService;

    private Path root = Paths.get("uploads");

    @BeforeEach
    void setUp() throws IOException {
        FileUtils.deleteDirectory(root.toFile());
    }

    @Test
    void whenInitThenCreatedUploadsDirectory() {
        storageService.init();
        assertTrue(Files.exists(root));
    }

    @Test
    void whenSaveFilesThenCopyItsToUploadsDirectory() throws IOException {
        MockMultipartFile firstFile = new MockMultipartFile("files[]", "temp1.txt", "multipart/form-data", "Test String".getBytes());
        MockMultipartFile secondFile = new MockMultipartFile("files[]", "temp2.txt", "multipart/form-data", "Test String".getBytes());

        storageService.init();
        storageService.save(List.of(firstFile, secondFile));

        assertTrue(Files.exists(Paths.get("uploads/temp1.txt")));
        assertTrue(Files.exists(Paths.get("uploads/temp2.txt")));
    }

}