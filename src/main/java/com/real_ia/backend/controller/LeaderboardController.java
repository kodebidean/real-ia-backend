package com.real_ia.backend.controller;

import com.real_ia.backend.model.Leaderboard;
import com.real_ia.backend.service.LeaderboardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leaderboard")
public class LeaderboardController {

    private final LeaderboardService leaderboardService;

    public LeaderboardController(LeaderboardService leaderboardService) {
        this.leaderboardService = leaderboardService;
    }

    @GetMapping("/top100")
    public List<Leaderboard> getTop100Scores() {
        return leaderboardService.getTop100Scores();
    }

    @PostMapping
    public ResponseEntity<Leaderboard> saveLeaderboardEntry(@RequestBody Leaderboard leaderboard) {
        return ResponseEntity.ok(leaderboardService.saveLeaderboardEntry(leaderboard));
    }
}
