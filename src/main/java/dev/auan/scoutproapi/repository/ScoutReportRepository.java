package dev.auan.scoutproapi.repository;

import dev.auan.scoutproapi.model.ScoutReportModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoutReportRepository extends JpaRepository<ScoutReportModel, Integer> {
}
