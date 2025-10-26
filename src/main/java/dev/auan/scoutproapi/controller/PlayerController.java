package dev.auan.scoutproapi.controller;

import dev.auan.scoutproapi.dto.PlayerRequestDTO;
import dev.auan.scoutproapi.dto.PlayerResponseDTO;
import dev.auan.scoutproapi.model.ClubModel;
import dev.auan.scoutproapi.model.PlayerModel;
import dev.auan.scoutproapi.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public ResponseEntity<List<PlayerResponseDTO>> getPlayers() {
        List<PlayerResponseDTO> players = playerService.getPlayers();
        return ResponseEntity.ok(players) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPlayerById(@PathVariable int id) {
        PlayerResponseDTO player = playerService.getPlayerById(id);
        if (player != null) {
            return ResponseEntity.ok(player);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Jogador com ID " + id + " não encontrado.");
        }
    }

    @PostMapping
    public ResponseEntity<String> createPlayer(@RequestBody PlayerRequestDTO player) {
        PlayerResponseDTO newPlayer = playerService.createPlayer(player);
        return ResponseEntity.ok("Jogador " + newPlayer.getKnowAs() + " criado com sucesso.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePlayerById(@PathVariable int id, @RequestBody PlayerRequestDTO player) {
        PlayerResponseDTO updatedPlayer = playerService.updatePlayerById(id, player);
        if (updatedPlayer != null) {
            return ResponseEntity.ok(updatedPlayer);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Jogador com ID " + id + " não encontrado.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePlayerById(@PathVariable int id) {
        if (playerService.getPlayerById(id) != null) {
            playerService.deletePlayerById(id);
            return ResponseEntity.ok("Jogador com ID " + id + " deletado com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Jogador com ID " + id + " não encontrado.");
        }
    }

}
