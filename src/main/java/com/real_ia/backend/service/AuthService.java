package com.real_ia.backend.service;

import com.real_ia.backend.model.User;
import com.real_ia.backend.model.UserSession;
import com.real_ia.backend.repository.UserRepository;
import com.real_ia.backend.security.JwtUtil;
import com.real_ia.backend.dto.auth.AuthResponse;
import com.real_ia.backend.dto.auth.RegisterRequest;
import com.real_ia.backend.dto.auth.LoginRequest;
import com.real_ia.backend.exception.AuthenticationException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final UserSessionService userSessionService;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Transactional
    public AuthResponse register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new AuthenticationException("El email ya está registrado");
        }

        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .username(request.getUsername())
                .profilePictureUrl(request.getProfilePictureUrl())
                .build();

        user = userRepository.save(user);
        String token = jwtUtil.generateToken(user.getEmail());
        
        createUserSession(user, token);

        return createAuthResponse(user, token);
    }

    @Transactional
    public AuthResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new AuthenticationException("Usuario no encontrado"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new AuthenticationException("Contraseña incorrecta");
        }

        String token = jwtUtil.generateToken(user.getEmail());
        createUserSession(user, token);

        return createAuthResponse(user, token);
    }

    @Transactional
    public void logout(Long userId) {
        userSessionService.deleteSessionByUserId(userId);
    }

    private void createUserSession(User user, String token) {
        UserSession session = UserSession.builder()
                .user(user)
                .token(token)
                .createdAt(LocalDateTime.now())
                .build();
        userSessionService.saveSession(session);
    }

    private AuthResponse createAuthResponse(User user, String token) {
        return AuthResponse.builder()
                .token(token)
                .userId(user.getId())
                .email(user.getEmail())
                .username(user.getUsername())
                .build();
    }
} 