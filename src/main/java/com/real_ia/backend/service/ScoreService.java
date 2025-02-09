package com.real_ia.backend.service;

import com.real_ia.backend.model.Score;
import com.real_ia.backend.repository.ScoreRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ScoreService {

    private final ScoreRepository scoreRepository;

    public ScoreService(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    public Optional<Score> getScoreByUserId(Long userId) {
        return scoreRepository.findByUserId(userId);
    }

    public Score saveScore(Score score) {
        return scoreRepository.save(score);
    }
}
