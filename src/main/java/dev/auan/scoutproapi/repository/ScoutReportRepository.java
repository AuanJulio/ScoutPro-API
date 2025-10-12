package dev.auan.scoutproapi.repository;

import dev.auan.scoutproapi.model.ScoutReportModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScoutReportRepository extends JpaRepository<ScoutReportModel, Integer> {

    List<ScoutReportModel> findByPlayerId(int playerId);

}
