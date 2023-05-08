package com.dzvonik.pdftools.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {FileStorageServiceImpl.class})
class FileStorageServiceImplTest {

    @MockBean
    private FileStorageService fileStorage;

    @Value("${spring.servlet.multipart.location}")
    private Path root;

    @Test
    void whenInitThenCreatedUploadsDirectory() {
        fileStorage.init();
        assertTrue(Files.exists(root));
    }

}