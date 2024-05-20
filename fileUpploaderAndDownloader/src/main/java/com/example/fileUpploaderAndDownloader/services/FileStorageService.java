package com.example.fileUpploaderAndDownloader.services;

import lombok.SneakyThrows;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileStorageService {

    @Value("${fileRepositoryFolder}")
    private String fileRepositoryFolder;


    public String upload(MultipartFile file) throws IOException {
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        String newFileName = UUID.randomUUID().toString();
        String completeFileName = newFileName + "." + extension;
        File finalFolder = new File(fileRepositoryFolder);
        if(!finalFolder.exists()) throw new IOException("Final folder doesn't exist");
        if(!finalFolder.isDirectory()) throw new IOException("Final folder is not a directory");

        File fileDestination = new File(fileRepositoryFolder + "\\" + completeFileName);
        if(!fileDestination.exists()) throw new IOException("File conflict");

        file.transferTo(fileDestination);
        return completeFileName;
    }

    public byte[] download(String fileName) throws IOException {
        File fileFromRepository = new File(fileRepositoryFolder + "\\" + fileName);
        if(!fileFromRepository.exists()) throw new IOException("File doesn't exist");
        return IOUtils.toByteArray(new FileInputStream(fileFromRepository));

    }

    @SneakyThrows
    public void remove(String fileName)   {
        File fileFromRepository = new File(fileRepositoryFolder + "\\" + fileName);
        if(!fileFromRepository.exists()) return;
        if(!fileFromRepository.delete()) throw new Exception("Cannot delete file");

    }
}
