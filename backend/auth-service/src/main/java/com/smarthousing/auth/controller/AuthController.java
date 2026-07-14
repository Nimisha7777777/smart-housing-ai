package com.smarthousing.auth.controller;

import com.smarthousing.auth.dto.request.LoginRequest;
import com.smarthousing.auth.dto.request.RegisterSocietyRequest;
import com.smarthousing.auth.dto.response.LoginResponse;
import com.smarthousing.auth.dto.response.RegisterSocietyResponse;
import com.smarthousing.auth.payload.ApiResponse;
import com.smarthousing.auth.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register-society")
    public ResponseEntity<ApiResponse<RegisterSocietyResponse>> registerSociety(
            @Valid @RequestBody RegisterSocietyRequest request) {

        RegisterSocietyResponse response =
                authService.registerSociety(request);

        ApiResponse<RegisterSocietyResponse> apiResponse =
                ApiResponse.<RegisterSocietyResponse>builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.CREATED.value())
                        .message("Society registered successfully.")
                        .data(response)
                        .build();

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(apiResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginResponse>> login(
            @Valid @RequestBody LoginRequest request){

        LoginResponse response =
                authService.login(request);

        ApiResponse<LoginResponse> apiResponse =
                ApiResponse.<LoginResponse>builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.OK.value())
                        .message("Login Successful")
                        .data(response)
                        .build();

        return ResponseEntity.ok(apiResponse);
    }
}
