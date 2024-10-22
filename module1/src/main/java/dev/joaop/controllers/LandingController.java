package dev.joaop.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LandingController {
    @GetMapping("/")
    public ResponseEntity<String> landing() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Hello World!");
    }
}
