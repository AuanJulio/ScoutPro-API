package dev.auan.scoutproapi.repository;

import dev.auan.scoutproapi.model.ClubModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubRepository extends JpaRepository<ClubModel, Integer> {
}
