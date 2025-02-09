package com.real_ia.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "game_images")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GameImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @Column(name = "type", nullable = false, length = 10)
    private String type; // Puede ser "real" o "ia"
}
