package com.dzvonik.pdftools.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

public interface FileStorageService {

    public void init();

    public List<File> save(List<MultipartFile> files);

}
