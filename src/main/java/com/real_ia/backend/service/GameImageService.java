package com.real_ia.backend.service;

import com.real_ia.backend.model.GameImage;
import com.real_ia.backend.repository.GameImageRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GameImageService {

    private final GameImageRepository gameImageRepository;

    public GameImageService(GameImageRepository gameImageRepository) {
        this.gameImageRepository = gameImageRepository;
    }

    public List<GameImage> getImagesByType(String type) {
        return gameImageRepository.findByType(type);
    }

    public GameImage saveGameImage(GameImage gameImage) {
        return gameImageRepository.save(gameImage);
    }
}
