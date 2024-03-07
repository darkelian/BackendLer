package com.crud.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.crud.demo.dtos.RegisterRequest;
import com.crud.demo.models.Role;
import com.crud.demo.models.User;
import com.crud.demo.models.UserProfile;
import com.crud.demo.repositories.UserProfileRepository;
import com.crud.demo.repositories.UserRepository;

import jakarta.transaction.Transactional;
import lombok.Data;

@Data
@Service
public class DataManagerService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public User registerUser(RegisterRequest registerDto,Role role) {
        // Suponiendo que el username es la cedula en RegisterRequest
        String cedula = registerDto.getUsername();

        // Asegúrate de que no exista un usuario con la misma cedula/username
        if (userRepository.existsById(cedula)) {
            throw new IllegalStateException("Ya existe un usuario con la cédula/username proporcionada.");
        }
        // Crea y guarda el usuario
        User newUser = User.builder()
                .username(registerDto.getUsername())
                .password(passwordEncoder.encode(registerDto.getPassword()))
                .role(role) // o ADMIN, según la lógica de negocio
                .build();

        newUser = userRepository.save(newUser);

        // Crea y guarda el perfil del usuario
        UserProfile newUserProfile = UserProfile.builder()
                .cedula(registerDto.getUsername())
                .fechaNacimiento(registerDto.getBirthDate())
                .primerNombre(registerDto.getFirstName())
                .segundoNombre(registerDto.getMiddleName())
                .primerApellido(registerDto.getLastName())
                .segundoApellido(registerDto.getSecondLastName())
                .user(newUser)
                .build();

        userProfileRepository.save(newUserProfile);

        return newUser;
    }
}
