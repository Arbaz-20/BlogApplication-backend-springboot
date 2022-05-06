package com.arbaz.blog.Services;

import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public interface FileService {

    public String UploadImage(String path, MultipartFile file) throws IOException;

    public InputStream getResource(String path, String fileName) throws FileNotFoundException;

}
