package dev.auan.scoutproapi.service;

import dev.auan.scoutproapi.model.ScoutReportModel;
import dev.auan.scoutproapi.repository.PlayerRepository;
import dev.auan.scoutproapi.repository.ScoutReportRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoutReportService {

    private final ScoutReportRepository scoutReportRepository;
    private final PlayerRepository playerRepository;

    public ScoutReportService(ScoutReportRepository scoutReportRepository, PlayerRepository playerRepository) {
        this.scoutReportRepository = scoutReportRepository;
        this.playerRepository = playerRepository;
    }

    public List<ScoutReportModel> getScoutReportsByPlayerId(int playerId) {
        return scoutReportRepository.findByPlayerId(playerId);
    }

    public ScoutReportModel createScoutReport(int playerId, ScoutReportModel scoutReport) {
        if (playerRepository.findById(playerId).isPresent()) {
            return scoutReportRepository.save(scoutReport);
        }
        return null;
    }

}
