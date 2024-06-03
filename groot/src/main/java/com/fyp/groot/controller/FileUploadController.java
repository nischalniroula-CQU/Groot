package com.fyp.groot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * FileUploadController handles HTTP requests for file upload operations.
 */
@RestController
@RequestMapping("/api/upload")
public class FileUploadController {

    // Directory where uploaded files will be saved
    private static final String UPLOAD_DIR = "src/main/resources/static/img/listing/";

    /**
     * Handles POST requests to upload multiple files.
     * 
     * @param files the array of files to upload
     * @return a ResponseEntity containing the list of uploaded file names or an error status
     */
    @PostMapping("/files")
    public ResponseEntity<List<String>> uploadFiles(@RequestParam("files") MultipartFile[] files) {
        List<String> fileNames = new ArrayList<>();

        for (MultipartFile file : files) {
            try {
                // Save the file to the directory
                String fileName = file.getOriginalFilename();
                Path path = Paths.get(UPLOAD_DIR + fileName);
                Files.write(path, file.getBytes());
                fileNames.add(fileName);
            } catch (IOException e) {
                // Return an internal server error status if an exception occurs
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }

        // Return the list of uploaded file names
        return ResponseEntity.ok(fileNames);
    }
}
