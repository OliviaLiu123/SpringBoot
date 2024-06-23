package com.example.demo.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class FileUploadController {
    private static final String UPLOAD_DIR="uploads/";

    //POST METHOD
    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file){
        if (file.isEmpty()){
            return ResponseEntity.badRequest().body("请选择一个上传文件");
        }
        try{
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_DIR+file.getOriginalFilename());
            Files.write(path,bytes);
            return ResponseEntity.ok("文件上传成功：" + file.getOriginalFilename());


        }catch (IOException e){
            e.printStackTrace();
            return ResponseEntity.status(500).body("文件上传失败：" + e.getMessage());

        }
    }



}
