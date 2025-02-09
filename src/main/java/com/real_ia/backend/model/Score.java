package com.real_ia.backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "score")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne // Relación uno a uno con la entidad User
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "best_score", nullable = false, columnDefinition = "INTEGER DEFAULT 0")
    private int bestScore;

    @Column(name = "last_score", nullable = false, columnDefinition = "INTEGER DEFAULT 0")
    private int lastScore;

    @Column(name = "lifes", nullable = false, columnDefinition = "INTEGER DEFAULT 10")
    private int lifes;

    @Column(name = "lifes_time")
    private LocalDateTime lifesTime; // Controla el tiempo de renovación de vidas
}
