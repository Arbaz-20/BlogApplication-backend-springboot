package com.arbaz.blog.ServiceImplementation;

import com.arbaz.blog.Services.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileServiceImplementation implements FileService {

    @Override
    public String UploadImage(String path, MultipartFile file) throws IOException {

        //Selected FileName
        String currentFileName = file.getOriginalFilename();

        //RandomId generated
        String randomId = UUID.randomUUID().toString();

        //FileName
        String FileName = randomId.concat(currentFileName.substring(currentFileName.lastIndexOf(".")));

        //FullPath
        String filePath = path+ File.separator +FileName;

        //Create Folder if Not Exist
        File folder = new File(path);
        if(!folder.exists()){
            folder.mkdir();
        }

        //File to Copy
        Files.copy(file.getInputStream(), Paths.get(filePath));

        //Returning the fileName that we created
        return FileName;
    }

    @Override
    public InputStream getResource(String path, String fileName) throws FileNotFoundException {

        String fullPath = path+File.separator+fileName;
        InputStream inputStream = new FileInputStream(fullPath); //if using database then have to write the database logic appropriately
        return inputStream;
    }
}
