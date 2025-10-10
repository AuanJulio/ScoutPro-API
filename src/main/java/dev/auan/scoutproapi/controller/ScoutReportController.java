package dev.auan.scoutproapi.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/players/{playerId}/reports")
public class ScoutReportController {

    @GetMapping
    public String getScoutReportsByPlayerId() {
        return "Scout Reports by Player ID";
    }

    @PostMapping
    public String createScoutReport() {
        return "Create Scout Report for Player";
    }

    @GetMapping("/{reportId}")
    public String getScoutReportById() {
        return "Scout Report by ID";
    }

    @PutMapping("/{reportId}")
    public String updateScoutReportById() {
        return "Update Scout Report by ID";
    }

    @DeleteMapping("/{reportId}")
    public String deleteScoutReportById() {
        return "Delete Scout Report by ID";
    }

}
