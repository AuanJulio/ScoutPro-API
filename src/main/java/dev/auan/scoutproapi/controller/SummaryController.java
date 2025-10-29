package dev.auan.scoutproapi.controller;

import dev.auan.scoutproapi.service.GeminiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class SummaryController {

    private GeminiService geminiService;

    public SummaryController(GeminiService geminiService) {
        this.geminiService = geminiService;
    }

    @GetMapping("/generate/{playerId}")
    public Mono<ResponseEntity<String>> generateSummary(@PathVariable int playerId) {
        return geminiService.generateSummary(playerId)
                .map(summary -> ResponseEntity.ok(summary))
                .defaultIfEmpty(ResponseEntity.noContent().build());
    }


}
