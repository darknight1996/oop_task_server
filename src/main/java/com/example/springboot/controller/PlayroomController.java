package com.example.springboot.controller;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.service.ResponseMessage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@RestController
public class PlayroomController {


    @GetMapping("/getPlayrooms")
    public void getPlayrooms(HttpServletResponse response) {
        try {
            System.out.println("qwerty");
            InputStream is = new FileInputStream("src/main/resources/playrooms.dat");
            IOUtils.copy(is, response.getOutputStream());
            response.flushBuffer();
            is.close();
        } catch (IOException ex) {
        }

    }

    @PostMapping("/updatePlayrooms")
    public void uploadFile(MultipartFile file) {
        try {
            System.out.println("qwerty");
            Files.copy(file.getInputStream(), Paths.get("src/main/resources").resolve(file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
