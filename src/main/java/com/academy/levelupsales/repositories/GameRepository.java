package com.academy.levelupsales.repositories;

import com.academy.levelupsales.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
