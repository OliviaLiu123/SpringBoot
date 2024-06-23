package com.example.demo.controller;


import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class FileDownloadController {
    private static final String UPLOAD_DIR="uploads/";
    @GetMapping("/dowmload/{filename:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String filename){
        Path filePath = Paths.get(UPLOAD_DIR+filename);
        Resource resource=null;
        try {
            if (Files.exists(filePath)) {
                resource = new FileSystemResource(filePath);
            } else {
                return ResponseEntity.notFound().build();
            }
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }

        //设置响应头

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition","attachment;filename="+resource.getFilename());
        headers.add("Cache-Control","no-cache,no-store,must-revalidate");
        headers.add("Pragma","no-cache");
        headers.add("Expires","0");
        return ResponseEntity.ok().headers(headers).contentType(MediaType.parseMediaType("application/octet-stream")).body(resource);





    }




}





