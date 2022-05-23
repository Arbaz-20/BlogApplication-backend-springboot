package com.arbaz.blog.Controller;

import com.arbaz.blog.DTO.APIResponse;
import com.arbaz.blog.Services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping(value = "/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @Value("${project.image}")
    private String path;

    //Method to Save Image in the Images folder
    @PostMapping("/upload")
    public ResponseEntity<APIResponse> fileUpload(@RequestParam("image") MultipartFile file) throws Exception{

        String fileName = null;

            fileName = this.fileService.UploadImage(path, file);
            if(file.isEmpty()){
                String message = "Please Select the Image to Upload";
                new ResponseEntity<>(new APIResponse(message,false),HttpStatus.BAD_REQUEST);
            }
        return new ResponseEntity<>(new APIResponse("Image Uploaded Successfully",true), HttpStatus.OK);
    }


    //Method to serve Image files
    @GetMapping(value = "/profile/{ImageName}",produces = MediaType.IMAGE_JPEG_VALUE)
    public void DownloadImage(@PathVariable("ImageName") String ImageName, HttpServletResponse response) throws IOException {
             InputStream resource = this.fileService.getResource(path,ImageName);
             response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(resource,response.getOutputStream());

    }
}
