package dev.auan.scoutproapi.controller;

import dev.auan.scoutproapi.dto.PlayerRequestDTO;
import dev.auan.scoutproapi.dto.PlayerResponseDTO;
import dev.auan.scoutproapi.model.ClubModel;
import dev.auan.scoutproapi.model.PlayerModel;
import dev.auan.scoutproapi.service.PlayerService;
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
    public List<PlayerResponseDTO> getPlayers() {
        return playerService.getPlayers();
    }

    @GetMapping("/{id}")
    public PlayerResponseDTO getPlayerById(@PathVariable int id) {
        return playerService.getPlayerById(id);
    }

    @PostMapping
    public PlayerResponseDTO createPlayer(@RequestBody PlayerRequestDTO player) {
        return playerService.createPlayer(player);
    }

    @PutMapping("/{id}")
    public PlayerResponseDTO updatePlayerById(@PathVariable int id, @RequestBody PlayerRequestDTO player) {
        return playerService.updatePlayerById(id, player);
    }

    @DeleteMapping("/{id}")
    public void deletePlayerById(@PathVariable int id) {
        playerService.deletePlayerById(id);
    }

}
