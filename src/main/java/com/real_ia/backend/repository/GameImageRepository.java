package com.real_ia.backend.repository;

import com.real_ia.backend.model.GameImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface GameImageRepository extends JpaRepository<GameImage, Long> {
    List<GameImage> findByType(String type);
}
