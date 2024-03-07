package com.crud.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.demo.dtos.RegisterRequest;
import com.crud.demo.dtos.StandardResponseDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
public class RegisterController {
    @PostMapping()
    public ResponseEntity<StandardResponseDTO> postRegister(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(new StandardResponseDTO().fullSuccess(request));
    }

    @GetMapping()
    public ResponseEntity<StandardResponseDTO> getRegister(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(new StandardResponseDTO().fullSuccess(request));
    }

    @DeleteMapping()
    public ResponseEntity<StandardResponseDTO> deleteRegister(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(new StandardResponseDTO().fullSuccess(request));
    }

    @PutMapping
    public ResponseEntity<StandardResponseDTO> putRegister(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(new StandardResponseDTO().fullSuccess(request));
    }
}
