package com.dzvonik.pdftools.util;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PdfUtilsTest {

    @Test
    void whenMergeThenReturnMergedDocument() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File pdf1 = new File(classLoader.getResource("test-1.pdf").getFile());
        File pdf2 = new File(classLoader.getResource("test-1.pdf").getFile());

        List<File> files = new ArrayList<>();
        files.add(pdf1);
        files.add(pdf2);

        File mergedFile = PdfUtils.merge(files);

        assertTrue(mergedFile.exists());
        assertTrue(mergedFile.getName().startsWith("result"));

        mergedFile.delete();
    }

}