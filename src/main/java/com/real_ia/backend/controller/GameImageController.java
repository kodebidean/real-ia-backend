package com.real_ia.backend.controller;

import com.real_ia.backend.model.GameImage;
import com.real_ia.backend.service.GameImageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/game-images")
public class GameImageController {

    private final GameImageService gameImageService;

    public GameImageController(GameImageService gameImageService) {
        this.gameImageService = gameImageService;
    }

    @GetMapping("/{type}")
    public List<GameImage> getImagesByType(@PathVariable String type) {
        return gameImageService.getImagesByType(type);
    }

    @PostMapping
    public ResponseEntity<GameImage> saveGameImage(@RequestBody GameImage gameImage) {
        return ResponseEntity.ok(gameImageService.saveGameImage(gameImage));
    }
}
