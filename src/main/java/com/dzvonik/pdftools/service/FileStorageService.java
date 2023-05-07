package com.dzvonik.pdftools.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileStorageService {

    public void init();

    public void save(List<MultipartFile> files);

}
