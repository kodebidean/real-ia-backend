package com.real_ia.backend.service;

import com.real_ia.backend.model.UserSession;
import com.real_ia.backend.repository.UserSessionRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserSessionService {

    private final UserSessionRepository userSessionRepository;

    public Optional<UserSession> getSessionByToken(String token) {
        return userSessionRepository.findByToken(token);
    }

    public void deleteSessionByUserId(Long userId) {
        userSessionRepository.deleteByUserId(userId);
    }

    public UserSession saveSession(UserSession session) {
        return userSessionRepository.save(session);
    }
}
