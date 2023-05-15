package com.dzvonik.pdftools.util;

import org.apache.pdfbox.multipdf.PDFMergerUtility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class PdfUtils {

    public static File merge(List<File> files) throws IOException {
        PDFMergerUtility PDFmerger = new PDFMergerUtility();
        PDFmerger.setDestinationFileName("uploads/result-" + LocalDate.now());

        for (File file : files) {
            PDFmerger.addSource(file);
        }

        PDFmerger.mergeDocuments();
        return new File(PDFmerger.getDestinationFileName());
    }

}
