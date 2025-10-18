package dev.auan.scoutproapi.service;

import dev.auan.scoutproapi.dto.ScoutReportRequestDTO;
import dev.auan.scoutproapi.dto.ScoutReportResponseDTO;
import dev.auan.scoutproapi.mapper.ScoutReportMapper;
import dev.auan.scoutproapi.model.PlayerModel;
import dev.auan.scoutproapi.model.ScoutReportModel;
import dev.auan.scoutproapi.repository.PlayerRepository;
import dev.auan.scoutproapi.repository.ScoutReportRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ScoutReportService {

    private final ScoutReportRepository scoutReportRepository;
    private final PlayerRepository playerRepository;
    private final ScoutReportMapper scoutReportMapper;

    public ScoutReportService(ScoutReportRepository scoutReportRepository, PlayerRepository playerRepository, ScoutReportMapper scoutReportMapper) {
        this.scoutReportRepository = scoutReportRepository;
        this.playerRepository = playerRepository;
        this.scoutReportMapper = scoutReportMapper;
    }

    public List<ScoutReportResponseDTO> getScoutReportsByPlayerId(int playerId) {
        List<ScoutReportModel> scoutReports = scoutReportRepository.findByPlayerId(playerId);
        return scoutReports.stream().map(scoutReportMapper::mapResponse).toList();
    }

    public ScoutReportResponseDTO createScoutReport(int playerId, ScoutReportRequestDTO scoutReport) {
        Optional<PlayerModel> playerOptional = playerRepository.findById(playerId);

        return playerOptional.map(player -> {
            ScoutReportModel newReport = scoutReportMapper.mapRequest(scoutReport);
            newReport.setReportDate(LocalDateTime.now());
            newReport.setPlayer(player);
            ScoutReportModel savedReport = scoutReportRepository.save(newReport);
            return scoutReportMapper.mapResponse(savedReport);
        }).orElse(null);
    }

}
