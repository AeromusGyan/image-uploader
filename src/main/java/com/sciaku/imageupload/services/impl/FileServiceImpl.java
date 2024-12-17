package com.sciaku.imageupload.services.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import com.sciaku.imageupload.entity.ImageData;
import com.sciaku.imageupload.repo.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sciaku.imageupload.services.FileService;

@Service
public class FileServiceImpl implements FileService{
    @Autowired
    private ImageRepository imageRepository;
    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {

        // File name
        String name = file.getOriginalFilename();
//        System.out.println(name);
        // random filename generate
        String randomId = UUID.randomUUID().toString();
        String fileName1 = randomId.concat(name.substring(name.lastIndexOf(".")));

//        System.out.println(fileName1 + randomId);
        String type = file.getContentType();

        ImageData imageData = new ImageData(name,fileName1, type);

        // Full path
        String filePath = path + File.separator+ fileName1;

        // create folder if not created
        File f = new File(path);
//        System.out.println(path);
        if(!f.exists()){
             f.mkdir();
        }
        // file copy
        Files.copy(file.getInputStream(), Paths.get(filePath));

//  this.imageRepository.save(ImageData)

        ImageData save = this.imageRepository.save(imageData);
        return name;
    }

    @Override
    public InputStream getResource(String path, String fileName) throws FileNotFoundException {
        String fullPath =  path+File.separator+fileName;
        InputStream is = new FileInputStream(fullPath);
        return is;
    }
}
