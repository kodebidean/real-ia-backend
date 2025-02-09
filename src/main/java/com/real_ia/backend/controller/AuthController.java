package com.real_ia.backend.controller;
import com.real_ia.backend.service.AuthService;
import com.real_ia.backend.dto.auth.RegisterRequest;
import com.real_ia.backend.dto.auth.LoginRequest;
import com.real_ia.backend.dto.auth.AuthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/logout/{userId}")
    public ResponseEntity<Void> logout(@PathVariable Long userId) {
        authService.logout(userId);
        return ResponseEntity.ok().build();
    }
} 