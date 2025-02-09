package com.real_ia.backend.controller;

import com.real_ia.backend.model.Score;
import com.real_ia.backend.service.ScoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/score")
public class ScoreController {

    private final ScoreService scoreService;

    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Score> getScoreByUser(@PathVariable Long userId) {
        return scoreService.getScoreByUserId(userId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Score> saveScore(@RequestBody Score score) {
        return ResponseEntity.ok(scoreService.saveScore(score));
    }
}
