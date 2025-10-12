package dev.auan.scoutproapi.controller;

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
    public List<ScoutReportModel> getScoutReportsByPlayerId(@PathVariable int playerId) {
        return scoutReportService.getScoutReportsByPlayerId(playerId);
    }

    @PostMapping
    public ScoutReportModel createScoutReport(@PathVariable int playerId, @RequestBody ScoutReportModel scoutReport) {
        return scoutReportService.createScoutReport(playerId, scoutReport);
    }

}
