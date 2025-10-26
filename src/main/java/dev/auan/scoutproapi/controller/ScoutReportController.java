package dev.auan.scoutproapi.controller;

import dev.auan.scoutproapi.dto.ScoutReportRequestDTO;
import dev.auan.scoutproapi.dto.ScoutReportResponseDTO;
import dev.auan.scoutproapi.model.ScoutReportModel;
import dev.auan.scoutproapi.service.ScoutReportService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getScoutReportsByPlayerId(@PathVariable int playerId) {
        List<ScoutReportResponseDTO> scoutReports = scoutReportService.getScoutReportsByPlayerId(playerId);
        if (scoutReports.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Nenhum relatório para o jogador ID " + playerId + " foi encontrado.");
        } else {
            return ResponseEntity.ok(scoutReports);
        }
    }

    @PostMapping
    public ResponseEntity<String> createScoutReport(@PathVariable int playerId, @RequestBody ScoutReportRequestDTO scoutReport) {
        ScoutReportResponseDTO newScoutReport = scoutReportService.createScoutReport(playerId, scoutReport);
        return ResponseEntity.ok("Relatório para o jogador ID " + playerId + " criado com sucesso.");
    }

}
