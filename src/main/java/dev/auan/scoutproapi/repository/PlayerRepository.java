package dev.auan.scoutproapi.repository;

import dev.auan.scoutproapi.model.PlayerModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<PlayerModel, Integer> {
}
