package dev.auan.scoutproapi.controller;

import dev.auan.scoutproapi.dto.ScoutReportRequestDTO;
import dev.auan.scoutproapi.dto.ScoutReportResponseDTO;
import dev.auan.scoutproapi.model.ScoutReportModel;
import dev.auan.scoutproapi.service.ScoutReportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players/{playerId}/reports")
public class ScoutReportController {

    private final ScoutReportService scoutReportService;

    public ScoutReportController(ScoutReportService scoutReportService) {
        this.scoutReportService = scoutReportService;
    }

    @GetMapping
    public List<ScoutReportResponseDTO> getScoutReportsByPlayerId(@PathVariable int playerId) {
        return scoutReportService.getScoutReportsByPlayerId(playerId);
    }

    @PostMapping
    public ScoutReportResponseDTO createScoutReport(@PathVariable int playerId, @RequestBody ScoutReportRequestDTO scoutReport) {
        return scoutReportService.createScoutReport(playerId, scoutReport);
    }

}
