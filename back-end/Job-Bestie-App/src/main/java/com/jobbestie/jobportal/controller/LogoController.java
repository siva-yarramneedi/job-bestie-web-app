package com.jobbestie.jobportal.controller;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/logos")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class LogoController {
	
    private final String LOGO_DIRECTORY = "src/main/resources/static/logos/";

    @GetMapping(value="/{fileName}",produces = "image/svg+xml")
    public ResponseEntity<Resource> getLogo(@PathVariable String fileName) {
        try {
            Path filePath = Paths.get(LOGO_DIRECTORY).resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());

            if (resource.exists()) {
                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                        .contentType(MediaType.parseMediaType("image/svg+xml"))
                        .body(resource);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (MalformedURLException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}

