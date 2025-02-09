package com.real_ia.backend.service;

import com.real_ia.backend.model.Leaderboard;
import com.real_ia.backend.repository.LeaderboardRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LeaderboardService {

    private final LeaderboardRepository leaderboardRepository;

    public LeaderboardService(LeaderboardRepository leaderboardRepository) {
        this.leaderboardRepository = leaderboardRepository;
    }

    public List<Leaderboard> getTop10Scores() {
        return leaderboardRepository.findTop100ByOrderByScoreDesc();
    }

    public Leaderboard saveLeaderboardEntry(Leaderboard leaderboard) {
        return leaderboardRepository.save(leaderboard);
    }
}
