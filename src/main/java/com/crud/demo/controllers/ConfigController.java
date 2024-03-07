package com.crud.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.demo.dtos.RegisterRequest;
import com.crud.demo.dtos.StandardResponseDTO;
import com.crud.demo.models.Role;
import com.crud.demo.models.User;
import com.crud.demo.service.DataManagerService;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api/config")
public class ConfigController {
    @Autowired
    private DataManagerService registrationService;

    @PostMapping("/init")
    public ResponseEntity<StandardResponseDTO> initDatabases() {
        Date date = new Date();
        RegisterRequest request = new RegisterRequest("123456789", "admin1234", "admin", "a", "b", "c", date);
        User user = registrationService.registerUser(request,Role.ADMIN);
        return ResponseEntity.ok(new StandardResponseDTO().fullSuccess(user));
    }

}
