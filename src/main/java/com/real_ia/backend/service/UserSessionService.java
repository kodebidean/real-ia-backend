package com.real_ia.backend.service;

import com.real_ia.backend.model.UserSession;
import com.real_ia.backend.repository.UserSessionRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserSessionService {

    private final UserSessionRepository userSessionRepository;

    public UserSessionService(UserSessionRepository userSessionRepository) {
        this.userSessionRepository = userSessionRepository;
    }

    public Optional<UserSession> getSessionByToken(String token) {
        return userSessionRepository.findByToken(token);
    }

    public void deleteSessionByUserId(Long userId) {
        userSessionRepository.deleteByUserId(userId);
    }
}
