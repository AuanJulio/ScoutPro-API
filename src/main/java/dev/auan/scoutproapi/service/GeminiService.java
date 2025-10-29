package dev.auan.scoutproapi.service;

import dev.auan.scoutproapi.dto.PlayerResponseDTO;
import dev.auan.scoutproapi.dto.ScoutReportResponseDTO;
import dev.auan.scoutproapi.model.PlayerModel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class GeminiService {

    private final WebClient webClient;
    private final PlayerService playerService;
    private final ScoutReportService scoutReportService;
    private final String apiKey = System.getenv("GEMINI_API_KEY");

    public GeminiService(WebClient webClient, PlayerService playerService, ScoutReportService scoutReportService) {
        this.webClient = webClient;
        this.playerService = playerService;
        this.scoutReportService = scoutReportService;
    }

    public Mono<String> generateSummary(int playerId) {

        PlayerResponseDTO player = playerService.getPlayerById(playerId);
        if (player == null) {
            return Mono.just("Jogador com não encontrado na base de dados.");
        }

        List<ScoutReportResponseDTO> scoutReports = scoutReportService.getScoutReportsByPlayerId(playerId);
        if (scoutReports.isEmpty()) {
            return Mono.just("Nenhum relatório para o jogador ID " + playerId + " foi encontrado.");
        }

        String playerProfile = String.format(
                "Perfil: %s (conhecido como %s), %d anos, %dcm, &.1fkg, Posição: %s.",
                player.getFullName(),
                player.getKnowAs(),
                calculateAge(player.getBirthDate()),
                player.getHeightCm(),
                player.getWeightKg(),
                player.getPosition()
        );

        String allStrengths = scoutReports.stream()
                .map(ScoutReportResponseDTO::getStregths)
                .collect(Collectors.joining("; "));

        String allWeaknesses = scoutReports.stream()
                .map(ScoutReportResponseDTO::getWeaknesses)
                .collect(Collectors.joining("; "));

        String prompt = "Sua tarefa é escrever um resumo executivo (em 3 parágrafos) para um Diretor Esportivo, " +
                "com base nas notas de campo brutas e no perfil do jogador.\n\n" +
                "DADOS BRUTOS:\n" +
                "Perfil: " + playerProfile + "\n" +
                "Notas de Pontos Fortes: " + allStrengths + "\n" +
                "Notas de Pontos Fracos: " + allWeaknesses + "\n\n" +
                "RESUMO EXECUTIVO (em português):";

        Map<String, Object> requestBody = Map.of(
                "system_instruction", Map.of(
                        "parts", List.of(
                                Map.of("text", "Você é um Olheiro de Futebol profissional e sênior, com um tom analítico e formal.")
                        )
                ),
                "contents", List.of(
                        Map.of("parts", List.of(
                                Map.of("text", prompt)
                        ))
                ),
                "generationConfig", Map.of(
                        "thinkingConfig", Map.of("thinkingBudget", 0)
                )
        );

        return webClient.post()
                .header("x-goog-api-key", apiKey)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(Map.class)
                .map(response -> {
                    var candidates = (List<Map<String, Object>>) response.get("candidates");
                    if (candidates != null && !candidates.isEmpty()) {
                        Map<String, Object> candidate = candidates.get(0);
                        Map<String, Object> content = (Map<String, Object>) candidate.get("content");
                        var parts = (List<Map<String, Object>>) content.get("parts");
                        if (parts != null && !parts.isEmpty()) {
                            return parts.get(0).get("text").toString();
                        }
                    }

                    return "Não foi possível gerar um resumo. Tente novamente mais tarde.";
                });

    }

    private int calculateAge(LocalDate birthDate) {
        if (birthDate == null) {
            return 0;
        }

        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(birthDate, currentDate);
        return period.getYears();
    }

}